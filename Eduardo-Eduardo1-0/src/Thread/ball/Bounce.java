package Thread.ball;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.ArrayList;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.javafx.webkit.ThemeClientImpl;


@SuppressWarnings("serial")
class Bounce extends JFrame {
	ArrayList<Thread> balls;
	private JPanel canvas = new JPanel();
	ThreadGroup grupoT;//grupo de thread
	boolean t;
	//int contador;//contador
	public Bounce() {
		setTitle("Bounce");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		canvas.setPreferredSize(new Dimension(450, 200));
		contentPane.add(canvas, "Center");
		JPanel temp = new JPanel();
		
		this.balls = new ArrayList<Thread>();//instancia balls
		this.t = false;
		//this.contador = 0;
		this.grupoT = new ThreadGroup("servico");//iniciando o grupo de thread
		
		JButton btStart = new JButton("Iniciar");
		btStart.addActionListener((e) -> {
			
		//	this.balls.add(new Thread(new SimpleBall(canvas)) );
			//this.balls.get(contador).run();
		//	this.balls.get(contador).start();
		//	contador++;
			/*if(t){
			Thread t =  new Thread(this.grupoT,new SimpleBall(canvas));
			}else{
				Thread t =  new Thread(this.grupoT,new SimpleBall(canvas,Color.re));//Fazer o exercicio em casa.
			}*/
			//t.start();
				//Ball b = new SimpleBall(canvas);
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

	class SimpleBall extends Ball implements Runnable  {

		public SimpleBall(JPanel painel) {
			super(painel);
		}

		@Override
		public void run() {
			try {
				draw();
			//	for(int i =0 ; i< 1000;i++) {
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
