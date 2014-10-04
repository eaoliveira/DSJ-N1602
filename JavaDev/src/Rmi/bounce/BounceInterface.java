package Rmi.bounce;

import java.awt.Color;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BounceInterface extends Remote {
  public void createBall(Color c) throws RemoteException;
}
