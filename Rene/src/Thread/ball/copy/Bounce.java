package Thread.ball.copy;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

@SuppressWarnings("serial")
class Bounce extends JFrame{
	JPanel temp = new JPanel();
	private JPanel canvas = new JPanel();
	JButton btStart = new JButton("Iniciar");
	
	public Bounce() {
		setTitle("Bounce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		canvas.setPreferredSize(new Dimension(450, 200));
		contentPane.add(canvas, "Center");
		
		
		JButton btStart = new JButton("Iniciar");
		btStart.addActionListener((e) -> {
				Ball b = new SimpleBall(canvas);
				Ball b2 = new SimpleBall(canvas, java.awt.Color.RED);
				
				b.setPriority(1);
				b.start();
				
				b2.start();
				b2.setPriority(10);
				//Thread aThread = new Thread(b);
				//aThread.start();
				//b.run();
			});
		temp.add(btStart);
		
		JButton btClose = new JButton("Fechar");
		btClose.addActionListener((e) -> {
				canvas.setVisible(false);
				System.exit(0);
			});
		temp.add(btClose);

		contentPane.add(temp, "South");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class SimpleBall extends Ball {

		public SimpleBall(JPanel painel) {
			super(painel);
		}

		public SimpleBall(JPanel b, java.awt.Color c) {
			super(b, c);
		}

		public void run() {
			try {
				draw();
				for(int i =0 ; i< 1000;i++) {
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
