package Rmi.bounce;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Thread.ball.Ball;

@SuppressWarnings("serial")
public class BounceServer extends UnicastRemoteObject 
                            implements  BounceInterface {
	
  private JPanel canvas = new JPanel();
  private int cnt = 0;
  private JLabel contador = new JLabel(Integer.toString(cnt));
  private ThreadGroup tg = new ThreadGroup("txt");

  public BounceServer() throws RemoteException {
    JFrame frame = new JFrame("Bounce Server");

    Container contentPane = frame.getContentPane();
    canvas.setPreferredSize(new Dimension(350, 200));
    contentPane.add(canvas, "Center");
    
    JPanel lbCnt = new JPanel();
    JButton btParar = new JButton("Parar");
    btParar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tg.interrupt();
        synchronized(contador) {
          contador.setText(Integer.toString((cnt = 0)));
        }
        canvas.repaint();
      }
    });
    lbCnt.add(btParar);
    lbCnt.add(new JLabel("Nº bolas: "));
    lbCnt.add(contador);
    contentPane.add(lbCnt, "South");
    
    frame.setSize(300, 300);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void createBall(Color c) throws RemoteException {
    ThreadBall b = new ThreadBall(canvas, c);
    new Thread(tg, b).start();

    synchronized(contador) {
      contador.setText(Integer.toString(++cnt));
    }
  }

  class ThreadBall extends Ball implements Runnable {
    public ThreadBall(JPanel b, Color c) {
      super(b, c);
    }

    public void run() {
      try {
        draw();
        while(true) {
          move();
          Thread.sleep(5);
        }
      } catch(InterruptedException e) {
      }
    }
  }

 public static void main(String[] args) throws Exception {
	 System.setProperty("java.net.preferIPv4Stack", "true");
     Registry reg = LocateRegistry.createRegistry(1099);
      reg.bind("ball", new BounceServer());
   }
}
