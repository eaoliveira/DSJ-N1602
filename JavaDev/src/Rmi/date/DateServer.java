package Rmi.date;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;

@SuppressWarnings("serial")
public class DateServer extends UnicastRemoteObject implements DataInterface {

	public DateServer() throws RemoteException {
		super();
	}

	public Date getDate() throws RemoteException {
		return Calendar.getInstance().getTime();
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			DateServer d = new DateServer();
			Context ctx = new InitialContext();
			ctx.bind("data", d);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
