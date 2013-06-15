package Thread.resposta.ballExpress;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Bounce extends JFrame {
	private JPanel canvas = new JPanel();

	public Bounce() {
		setTitle("Bounce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		canvas.setPreferredSize(new Dimension(450, 200));
		contentPane.add(canvas, "Center");
		JPanel temp = new JPanel();
		
		JButton btStart = new JButton("Iniciar");
		btStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ball b = new SimpleBall(canvas);
				b.setPriority(Thread.MIN_PRIORITY);
				b.start();
				
				Ball b2 = new SimpleBall(canvas, Color.red);
				b2.setPriority(Thread.MAX_PRIORITY);
				b2.start();
			}
		});
		temp.add(btStart);
		
		JButton btClose = new JButton("Fechar");
		btClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canvas.setVisible(false);
				System.exit(0);
			}
		});
		temp.add(btClose);

		contentPane.add(temp, "South");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class SimpleBall extends Ball  {

		public SimpleBall(JPanel painel) {
			super(painel);
		}

		public SimpleBall(JPanel b, Color c) {
			super(b, c);
		}

		public void run() {
			try {
				draw();
				for(;;) {
				//while(true) {
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