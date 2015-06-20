package Rmi.registrosRmi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RegistradorRMI {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(
				new InputStreamReader(RegistradorRMI.class.getResourceAsStream("registro.config")));
		
		Registry rmi = LocateRegistry.createRegistry(1099);
	
		String reg = in.readLine();
		while(reg != null) {
			String[] campo = reg.split(",");
			rmi.bind(campo[0], (Remote) Class.forName(campo[1]).newInstance());
			reg = in.readLine();
		}
		in.close();
	}
}
