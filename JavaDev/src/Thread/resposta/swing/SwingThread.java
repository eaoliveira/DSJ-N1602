package Thread.resposta.swing;

import java.awt.Container;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import Thread.swing.Contador;

public class SwingThread {
	public static void main(String[] args) {
		new SwingThread();
	}

	public SwingThread() {
		JFrame frame = new JFrame("Threads com Swing");

		MeuContador[] c = { 
				new MeuContador("Contador 1", 1000),
				new MeuContador("Contador 2", 2000),
				new MeuContador("Contador 3", 100),
				new MeuContador("Contador 4", 5000),
				new MeuContador("Contador 5", 500),
				new MeuContador("Contador 6", 3000) 
		};

		Container panel = frame.getContentPane();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		for (MeuContador cont : c) {
			panel.add(cont.getBar());
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		ExecutorService exe = Executors.newCachedThreadPool();
		for (MeuContador cont : c) {
			exe.execute(cont);
		}
	}

	class MeuContador extends Contador implements Runnable {
		public MeuContador(String nome, int value) {
			super(nome, value);
		}

		@Override
		public void run() {
			try {
				for (;;) {
					for (int i = 1; i <= getValue();) {
						Thread.sleep(getInterval());
						getPg().setValue(i++);
					}
					for (int i = getValue(); i >= 1;) {
						Thread.sleep(getInterval());
						getPg().setValue(i--);
					}
				}
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}

	}
}
