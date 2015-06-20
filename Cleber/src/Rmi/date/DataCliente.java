package Rmi.date;

import java.rmi.Naming;

public class DataCliente {

	public static void main(String[] args) throws Exception {
	
		System.setSecurityManager(new SecurityManager());
		
		DataInterface data = (DataInterface)Naming.lookup("rmi://10.84.144.250/data");
		System.out.println(data.getDate().toLocaleString());
	}

}
