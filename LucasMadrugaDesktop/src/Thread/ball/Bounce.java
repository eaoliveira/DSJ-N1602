package Thread.ball;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.javafx.sg.prism.GrowableDataBuffer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
class Bounce extends JFrame {
	private JPanel canvas = new JPanel();
	ThreadGroup grupo = new ThreadGroup("grupoBolas");
	public Bounce() {
		setTitle("Bounce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		canvas.setPreferredSize(new Dimension(450, 200));
		contentPane.add(canvas, "Center");
		JPanel temp = new JPanel();
		
		JButton btStart = new JButton("Iniciar");
		btStart.addActionListener((e) -> {
				Ball b1 = new SimpleBall(canvas,2,Color.RED);
				Ball b2= new SimpleBall(canvas,5,Color.BLACK);
				
				
				Thread t1 = new Thread(grupo,b1);
				Thread t2 = new Thread(grupo,b2);
				t1.start();
				t2.start();
				
				
			});
		temp.add(btStart);
		
		JButton btClose = new JButton("Fechar");
		btClose.addActionListener((e) -> {
				canvas.setVisible(false);
				System.exit(0);
			});
		temp.add(btClose);

		contentPane.add(temp, "South");
		
		JButton btnParar = new JButton("Parar");
		btnParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grupo.interrupt();
				canvas.repaint();
			}
		});
		temp.add(btnParar);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class SimpleBall extends Ball {
		private int prioridade;
		public SimpleBall(JPanel painel, int prioridade, Color c) {
			super(painel,c);
			this.prioridade = prioridade;
			
		}

		public void run() {
			try {
				draw();
				for(int i =0 ; i< 1000;i++) {
					move();
					Thread.sleep(this.prioridade);	
					
					
				}
			} catch (InterruptedException e) {
			}
		}
	}
	
    

	public static void main(String[] args) {
		new Bounce();
	}
}
