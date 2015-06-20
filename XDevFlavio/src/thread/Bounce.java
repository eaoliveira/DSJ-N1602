package thread;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;




import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
		btStart.addActionListener((e) -> {
						
				Ball b = new SimpleBall(canvas);
			
				Thread nt = new Thread(b);
		
				nt.start();
		
				
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
		
		public SimpleBall(JPanel painel, Color cor) {
			super(painel, cor);
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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		new Bounce();
	}
}
