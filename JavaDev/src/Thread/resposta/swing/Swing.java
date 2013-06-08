package Thread.resposta.swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Swing {
	JButton btIniciar = new JButton("Parar");

	public static void main(String[] args) {
		new Swing();
	}

	public Swing() {
		JFrame frame = new JFrame("Swing");

		final MeuContador c1 = new MeuContador("Contador 1", 1000), 
				c2 = new MeuContador("Contador 2", 1000);

		Container panel = frame.getContentPane();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(c1.getBar());
		panel.add(c2.getBar());

		btIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.setParar(!c1.isParar());
				c2.setParar(!c2.isParar());
				if (c1.isParar())
					btIniciar.setText("Continuar");
				else
					btIniciar.setText("Parar");
			}
		});
		panel.add(btIniciar);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		new Thread(c1).start();
		new Thread(c2).start();
	}

	class MeuContador extends Contador implements Runnable {

		public MeuContador(String nome, int value) {
			super(nome, value);
		}

		public void run() {
			try {
				while (true) {
					for (int i = 1; i <= value;) {
						Thread.sleep(interval);
						if (!isParar())
							pg.setValue(i++);
					}
					for (int i = value; i >= 0;) {
						Thread.sleep(interval);
						if (!isParar())
							pg.setValue(i--);
					}
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
