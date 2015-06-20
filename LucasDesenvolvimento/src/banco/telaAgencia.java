package banco;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;

@SuppressWarnings("serial")
public class telaAgencia extends JFrame implements ActionListener{
	
	JPanel painel = new JPanel();
	JButton button1 = new JButton("Abre Agencia");
	JButton button2 = new JButton("Fecha Agencia");
	JButton button3 = new JButton("Salvar");
	
	static JTextField texto1 = new JTextField();
	static JTextField texto2 = new JTextField();
	static JTextField texto3 = new JTextField();
	static JTextField texto4 = new JTextField();
	static JTextField texto5 = new JTextField();
	static JTextField texto6 = new JTextField();
	static JTextField texto7 = new JTextField();
	static JTextField texto8 = new JTextField();
	static JTextField[] textos = {texto1, texto2, texto3, texto4, texto5, texto6, texto7, texto8};
		
	JLabel label = new JLabel("Agencia Bancaria - Simulacao de Filas");
	JLabel label1 = new JLabel("Caixas");
	JLabel label2 = new JLabel("Fila Preferencial");
	JLabel label3 = new JLabel("Fila Normal");
	JLabel label4 = new JLabel("Pessoas por Vez");
	private final JSpinner spinner = new JSpinner();
		
	public telaAgencia() {
		
		setLocation(200,200);
		setSize(500,350);
		setResizable(false);
		setTitle("Banco 1/2 Boca");
		
		getContentPane().add(painel);
		painel.setLayout(null);
		painel.add(label);
		painel.add(label1);
		painel.add(label2);
		painel.add(label3);
		painel.add(label4);
		painel.add(button1);
		painel.add(button3);
		
		button1.setSize(120,30);
		button1.setLocation(280,270);
		button2.setSize(120,30);
		button2.setLocation(100,270);
		button3.setSize(70,25);
		button3.setLocation(210,115);
		
		label.setSize(480,50);
		label.setLocation(110,5);
		label.setFont(new Font("",Font.BOLD,16));
		
		label1.setSize(90,40);
		label1.setLocation(220,150);
		
		label2.setSize(100,40);
		label2.setLocation(72,70);
		
		label3.setSize(100,40);
		label3.setLocation(337,70);
		
		label4.setSize(100,40);
		label4.setLocation(200,45);
		spinner.setBounds(210, 80, 70, 30);
		
		painel.add(spinner);
		
		for (int i = 0; i< textos.length; i++) {
			textos[i].setSize(80,40);
			painel.add(textos[i]);
			textos[i].setHorizontalAlignment(SwingConstants.CENTER);
		}

		texto1.setLocation(80,100);
		texto2.setLocation(330,100);
		texto3.setLocation(30,200);
		texto4.setLocation(120,200);
		texto5.setLocation(210,200);
		texto6.setLocation(300,200);
		texto7.setLocation(390,200);
		texto8.setLocation(225,80);
		texto8.setSize(40,30);
		
	}
	
	
	public static void main (String args[])   {
		
	JFrame telaAgencia = new telaAgencia();	
		agencia.setVisible(true);
			
	}
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		if(equals(button1)){
			number
		}
				
				
	}	
	

}
