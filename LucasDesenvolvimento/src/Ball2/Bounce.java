package Ball2;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

@SuppressWarnings("serial")
class Bounce extends JFrame {
	private JPanel canvas = new JPanel();
	private int contador = 0;
	private JLabel lbBotas = new JLabel("Nº de bolas: " + contador );
	ThreadGroup bolas = new ThreadGroup("bolas");
	public Bounce() {
		setTitle("Bounce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		canvas.setPreferredSize(new Dimension(450, 200));
		contentPane.add(canvas, "Center");
		JPanel temp = new JPanel();
		
		JButton btStart = new JButton("Iniciar");
		btStart.addActionListener((e) -> {
			Ball b1 = new SimpleBall(canvas,3,Color.RED);
			Ball b2 = new SimpleBall(canvas,3,Color.BLACK);
			new Thread((Runnable)b2).start();
			new Thread((Runnable)b1).start();
			
				lbBotas.setText("Nº de bolas: " + ++contador);
			});
		temp.add(btStart);
		
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

		public SimpleBall(JPanel b, java.awt.Color c) {
			super(b, c);
			
		}

		public SimpleBall(JPanel painel, int i, Color red) {
			super(painel);
		}

		public void run() {
			try {
				draw();
				for(;;) {
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