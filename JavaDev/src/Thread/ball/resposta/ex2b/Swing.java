package Thread.ball.resposta.ex2b;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class Swing {
  public static void main(String[] args) {
    new Swing();
  }

  public Swing() {
    JFrame frame = new JFrame("Swing");

    MeuContador c1 = new MeuContador(1, 1000, 7), 
             c2 = new MeuContador(2, 1000, 2),
             c3 = new MeuContador(3, 500, 10),
             c4 = new MeuContador(4, 700);

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

class MeuContador extends Contador implements Runnable {

	public MeuContador(int nome, int value) {
		super("Meu Contador" + nome, value);
	}

	public MeuContador(int nome, int value, int interval) {
		super("Meu Contador" + nome, value, interval);
	}
	
	public void run() {
		try {
			for (int i = getValue();i >= 1;) {
				Thread.sleep(getInterval());
				pg.setValue(i--);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

}