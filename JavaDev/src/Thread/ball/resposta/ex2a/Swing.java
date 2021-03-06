package Thread.ball.resposta.ex2a;

import java.awt.*;

import javax.swing.*;

public class Swing {
  public static void main(String[] args) {
    new Swing();
  }

  public Swing() {
    JFrame frame = new JFrame("Swing");

    Contador c1 = new Contador("Contador 1", 1000, 7), 
             c2 = new Contador("Contador 2", 1000, 2),
             c3 = new Contador("Contador 3", 500, 10),
             c4 = new Contador("Contador 4", 700);

    Container panel = frame.getContentPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(c1.getBar());
    panel.add(c2.getBar());
    panel.add(c3.getBar());
    panel.add(c4.getBar());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    new Thread(c1).start();
    new Thread(c2).start();
    new Thread(c3).start();
    new Thread(c4).start();
  }
}
