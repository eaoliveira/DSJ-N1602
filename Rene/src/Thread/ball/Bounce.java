package Thread.ball;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
				Thread aThread = new Thread(b);
				aThread.start();
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
