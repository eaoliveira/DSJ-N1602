package MeuBanco;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaBanco extends JFrame implements Runnable{

	JPanel janela = new JPanel();
	private JPanel canvas = new JPanel();
	JButton btAbre = new JButton("Abre a agencia");
	JButton btFecha = new JButton("Fecha a agencia");
	JLabel jlFilaPreferencial = new JLabel("Fila Preferencial");
	JTextField jtFilaPrefencial = new JTextField();
	Agencia agencia = new Agencia();
	
	public TelaBanco(){
		setTitle("Banco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container contentPane = getContentPane();
		//canvas.setPreferredSize(new Dimension(450, 200));
		//contentPane.add(canvas, "Center");
		
		btAbre.addActionListener((e) -> {
			Agencia agencia = new Agencia();
			agencia.abrir();
			
			Thread tread = new Thread(this);
			tread.start();
		});
		janela.add(btAbre);
		
		btFecha.addActionListener((e) -> {
			System.exit(0);
		});
		janela.add(btFecha);
		
		janela.add(jlFilaPreferencial);
		jtFilaPrefencial.setText(""+agencia.preferencial.quantos());
		jtFilaPrefencial.setText(""+agencia.preferencial.quantos());
		janela.add(jtFilaPrefencial);
		
		
		contentPane.add(janela, "South");
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public class AtualizaTela extends Thread{
		@Override
		public void run(){
			try {

				while (!isInterrupted()) {
					jtFilaPrefencial.setText(""+agencia.preferencial.quantos());
					jlFilaPreferencial.setText(""+agencia.preferencial.quantos());
					
				}
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
		}
	}
	
	public static void main(String[] args) {
		new TelaBanco();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
