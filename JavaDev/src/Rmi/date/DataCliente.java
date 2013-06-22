package Rmi.date;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class DataCliente {
	public static void main(String[] args) {
		System.setSecurityManager(new RMISecurityManager());
		try {
			// RMI conectando utilizando InitialContext
			Properties prop = new Properties();
			prop.put("java.naming.factory.initial",
					"com.sun.jndi.rmi.registry.RegistryContextFactory");
			prop.put("java.naming.provider.url", "rmi://10.190.39.250:1099");
			Context ctx = new InitialContext(prop);
			DataInterface dataCtx = (DataInterface) ctx.lookup("data");

			// RMI Conectando Utilizando LocateRegistry
			Registry reg = LocateRegistry.getRegistry("10.190.39.250");
			DataInterface dataReg = (DataInterface) reg.lookup("data");

			// RMI conectando utizando Naming
			DataInterface data = (DataInterface) Naming
					.lookup("rmi://10.190.39.250/data");
			System.out.println(data.getDate() + "\n" + dataReg.getDate() + "\n"
					+ dataCtx.getDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
