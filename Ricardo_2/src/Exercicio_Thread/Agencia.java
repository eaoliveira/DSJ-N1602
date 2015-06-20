package Exercicio_Thread;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class Agencia extends JFrame implements ActionListener{
	
	JPanel painel = new JPanel();
	JButton button1 = new JButton("Abre Agencia");
	JButton button2 = new JButton("Fecha Agencia");
	JButton button4 = new JButton("Salvar");
	static JSpinner button3 = new JSpinner(new SpinnerNumberModel(10,10,30,1));
	
	static JTextField texto1 = new JTextField();
	static JTextField texto2 = new JTextField();
	static JTextField texto3 = new JTextField();
	static JTextField texto4 = new JTextField();
	static JTextField texto5 = new JTextField();
	static JTextField texto6 = new JTextField();
	static JTextField texto7 = new JTextField();
	static JTextField texto8 = new JTextField();
	static JTextField[] textos = {texto1, texto2, texto3, texto4, texto5, texto6, texto7};
		
	JLabel label = new JLabel("Agencia Bancaria - Simulacao de Filas");
	JLabel label1 = new JLabel("Caixas");
	JLabel label2 = new JLabel("Fila Preferencial");
	JLabel label3 = new JLabel("Fila Normal");
	JLabel label4 = new JLabel("Pessoas por Vez");
	
	Thread t, cx1, cx2, cx3, cx4, cx5;
	int x;
		
		
	public Agencia() {
		
		x = 0;
		
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
		painel.add(button2);
		painel.add(button3);
		
		button1.setSize(120,30);
		button1.setLocation(280,270);
		button1.addActionListener(this);
		button2.setSize(120,30);
		button2.setLocation(100,270);
		button2.addActionListener(this);
		button3.setSize(70,25);
		button3.setLocation(210,105);

		
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
		
		
		texto1.setEnabled(false);
		texto2.setEnabled(false);
		texto3.setEnabled(false);
		texto4.setEnabled(false);
		texto5.setEnabled(false);
		texto6.setEnabled(false);
		texto7.setEnabled(false);
		texto8.setEnabled(false);
		texto8.setEnabled(false);
		
		
		
		
		texto1.setText(Integer.toString(0));
		texto2.setText(Integer.toString(0));
		
	}
	
//****************************************************************************************
	public static void main (String args[])   {
		
	JFrame agencia = new Agencia();	
		agencia.setVisible(true);
			
	}

//********ACTION LISTENERS *********************************************

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource(); 
		
		// Encerra Aplicativo
		
		if (source == button2) {
			t.interrupt();
			x = 0;
			}
		
		// Inicia Entrada de Clientes na agencia
		
		if (source == button1) {
			
			if(x == 1) {
				return;
			}
			
			x = 1;
			
			Organiza_Fila thread_fila = new Organiza_Fila();
			t = new Thread(thread_fila);
			t.start();
			
			Caixa caixa = new Caixa("Preferencial","caixa1");
			cx1 = new Thread(caixa);
			cx1.start();
			
			
			
		}
		
//****************************************************************************************				
		
	}
	
}
	
	
