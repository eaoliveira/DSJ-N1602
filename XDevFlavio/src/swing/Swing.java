package swing;

import java.awt.*;

import javax.swing.*;

public class Swing {
  public static void main(String[] args) {
	  try {
		  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	  } catch (Throwable ex){
		  
	  }
    new Swing();
  }

  public Swing() {
    JFrame frame = new JFrame("Swing");

    Contador c1 = new Contador("Contador 1", 1000), 
             c2 = new Contador("Contador 2", 1000),
             c3 = new Contador("Contador 3", 500);

    Container panel = frame.getContentPane();
    panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
    panel.add(c1.getBar());
    panel.add(c2.getBar());
    panel.add(c3.getBar());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    c1.start();
    c2.start();
    c3.start();
  }
}
