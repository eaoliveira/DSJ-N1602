package Rmi.objetoServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ObjetoInterface extends Remote{
  public void salva(Object obj) throws RemoteException;
  public void salvaLista(List<? extends Object> lista) throws RemoteException;
}
