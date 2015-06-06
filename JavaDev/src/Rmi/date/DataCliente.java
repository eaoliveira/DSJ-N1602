package Rmi.date;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class DataCliente {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			// RMI conectando utilizando InitialContext
			Properties prop = new Properties();
			prop.put("java.naming.factory.initial", "com.sun.jndi.rmi.registry.RegistryContextFactory");
			prop.put("java.naming.provider.url", "rmi://10.84.144.250:1099");
			Context ctx = new InitialContext(prop);
			DataInterface dataCtx = (DataInterface) ctx.lookup("data");
			
			// RMI conectando utilizando InitialContext e o arquivo jndi.properties
			Context ctx1 = new InitialContext();
			DataInterface dataCtx1 = (DataInterface) ctx1.lookup("data");

			// RMI Conectando Utilizando LocateRegistry
			Registry reg = LocateRegistry.getRegistry("10.84.144.250");
			DataInterface dataReg = (DataInterface) reg.lookup("data");

			// RMI conectando utizando Naming
			DataInterface data = (DataInterface) Naming.lookup("rmi://10.84.144.250/data");
			
			
			System.out.println(data.getDate() + "\n" + dataReg.getDate() + "\n" + dataCtx.getDate()+ "\n" + dataCtx1.getDate());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
