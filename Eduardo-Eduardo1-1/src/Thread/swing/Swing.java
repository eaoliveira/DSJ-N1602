package Thread.swing;

import java.awt.*;

import javax.swing.*;

public class Swing {
  public static void main(String[] args) {
    new Swing();
  }

  public Swing() {
    JFrame frame = new JFrame("Swing");

    Contador c1 = new Contador("Contador 1", 100), 
             c2 = new Contador("Contador 2", 100),
             c3 = new Contador("Contador 3", 100);
    c1.setInterval(20);
    c2.setInterval(40);
    c3.setInterval(50);

    Container panel = frame.getContentPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(c1.getBar());
    panel.add(c2.getBar());
    panel.add(c3.getBar());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    new Thread(c1).start();;
    new Thread(c2).start();;
    new Thread(c3).start();;
    
    
   // c1.run();
   // c2.run();
    //c3.run();
  }
}
