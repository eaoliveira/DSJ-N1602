package Rmi.objetoServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetoInterface extends Remote{
  public void salva(Object obj) throws RemoteException;
}
