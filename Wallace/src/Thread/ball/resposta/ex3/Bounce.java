package Thread.ball.resposta.ex3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Thread.ball.Ball;

@SuppressWarnings("serial")
class Bounce extends JFrame {
	private JPanel canvas = new JPanel();
	private int contador = 0;
	private JLabel lbBotas = new JLabel("Nº de bolas: " + contador );
	private ThreadGroup bolas = new ThreadGroup("X");

	public Bounce() {
		setTitle("Bounce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		canvas.setPreferredSize(new Dimension(450, 200));
		contentPane.add(canvas, "Center");
		JPanel temp = new JPanel();
		
		JButton btStart = new JButton("Iniciar");
		btStart.addActionListener((e) -> {
			    SimpleBall b1 = new SimpleBall(canvas);
				Thread t1 = new Thread(bolas, b1);
			    b1.setThread(t1);
				t1.setPriority(Thread.MAX_PRIORITY);
				t1.start();
				
				SimpleBall b2 = new SimpleBall(canvas, Color.red);
				Thread t2 = new Thread(bolas, b2);
				b2.setThread(t2);
				t2.setPriority(Thread.MIN_PRIORITY);
				t2.start();
				
				contador +=2;
				lbBotas.setText("Nº de bolas: " + contador);
			});
		temp.add(btStart);
		
		JButton btPara = new JButton("Parar");
		btPara.addActionListener((e) -> {
			bolas.interrupt();
			canvas.repaint();
			contador = 0;
			lbBotas.setText("Nº de bolas: " + contador);			
		});
		temp.add(btPara);
		
		JButton btClose = new JButton("Fechar");
		btClose.addActionListener((e) -> {
				canvas.setVisible(false);
				System.exit(0);
			});
		temp.add(btClose);

		temp.add(lbBotas);
		
		contentPane.add(temp, "South");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class SimpleBall extends Ball implements Runnable {
		private Thread minhaThread;
		
		
		public SimpleBall(JPanel painel) {
			super(painel);
		}

		public SimpleBall(JPanel b, Color c) {
			super(b, c);
		}

		public void setThread(Thread t) {
			minhaThread = t;
		}
		
		public void run() {
			try {
				
				draw();
				while(!minhaThread.isInterrupted()) {
					move();
					Thread.sleep(5);
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public static void main(String[] args) {
		new Bounce();
	}
}
