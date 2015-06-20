package meu_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface DataInterface extends Remote {
  public Date getDate() throws RemoteException;
}
