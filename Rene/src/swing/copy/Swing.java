package swing.copy;

import java.awt.*;

import javax.swing.*;

public class Swing {
  public static void main(String[] args) {
    new Swing();
  }

  public Swing() {
    JFrame frame = new JFrame("Swing");

    Contador c1 = new Contador("Contador 1", 1000), 
             c2 = new Contador("Contador 2", 1000),
             c3 = new Contador("Contador 3", 500);
    
    JLabel lContador = new JLabel();
    lContador.setText("" + c1.getValue());
    
    
    Container panel = frame.getContentPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(c1.getBar());
    panel.add(c2.getBar());
    panel.add(c3.getBar());
    panel.add(lContador);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    /*c1.run();
    c2.run();
    c3.run();*/
    
    Thread t = new Thread(c1);
    t.start();
    Thread t2 = new Thread(c2);    
    t2.start();
    Thread t3 = new Thread(c3);
    t3.start();
    
    
  }
}
