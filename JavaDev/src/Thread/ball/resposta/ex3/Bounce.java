package Thread.ball.resposta.ex3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Bounce extends JFrame {
	private JPanel canvas = new JPanel();
	private ThreadGroup grupo = new ThreadGroup("");
	private int contador = 0;
	private JLabel contagem = new JLabel("nº de bolas: " + contador);

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
			    Thread t1 = new Thread(grupo, b1);
			    t1.setPriority(Thread.MIN_PRIORITY);
				t1.start();
				
			    SimpleBall b2 = new SimpleBall(canvas, Color.red);
			    Thread t2 = new Thread(grupo, b2);
			    t2.setPriority(Thread.MAX_PRIORITY);
				t2.start();
				contador += 2;
				contagem.setText("nº de bolas: " + contador);
			});
		temp.add(btStart);

		JButton btParar = new JButton("Parar");
		btParar.addActionListener((e) -> {
				grupo.interrupt();
				canvas.repaint();
				contador = 0;
				contagem.setText("nº de bolas: " + contador);
			});
		temp.add(btParar);
		
		JButton btClose = new JButton("Fechar");
		btClose.addActionListener((e) -> {
				canvas.setVisible(false);
				System.exit(0);
			});
		temp.add(btClose);

		temp.add(contagem);
		

		contentPane.add(temp, "South");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class SimpleBall extends Ball implements Runnable {
		public SimpleBall(JPanel painel) {
			super(painel);
		}

		public SimpleBall(JPanel b, Color c) {
			super(b, c);
		}

		public void run() {
			try {
				
				draw();
				while(!Thread.interrupted()) {
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
