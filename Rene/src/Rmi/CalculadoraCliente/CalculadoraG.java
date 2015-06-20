package Rmi.CalculadoraCliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import Rmi.calc.Calculo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CalculadoraG extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JTextField txfJanela;
	private JButton btnSoma;
	private JButton btnResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraG frame = new CalculadoraG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalculadoraG() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn1 = new JButton("1");
		btn1.addActionListener(this);
		btn1.setBounds(38, 71, 66, 23);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addActionListener(this);
		btn2.setBounds(151, 71, 89, 23);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addActionListener(this);
		btn3.setBounds(250, 71, 89, 23);
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.addActionListener(this);
		btn4.setBounds(41, 105, 89, 23);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addActionListener(this);
		btn5.setBounds(171, 105, 89, 23);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addActionListener(this);
		btn6.setBounds(264, 108, 89, 23);
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.addActionListener(this);
		btn7.setBounds(41, 172, 89, 23);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addActionListener(this);
		btn8.setBounds(171, 172, 89, 23);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addActionListener(this);
		btn9.setBounds(264, 172, 89, 23);
		contentPane.add(btn9);
		
		txfJanela = new JTextField();
		txfJanela.setBounds(38, 27, 306, 20);
		contentPane.add(txfJanela);
		txfJanela.setColumns(10);
		
		btnSoma = new JButton("+");
		btnSoma.addActionListener(this);
		btnSoma.setBounds(38, 216, 89, 23);
		contentPane.add(btnSoma);
		
		btnResultado = new JButton("=");
		btnResultado.addActionListener(this);
		btnResultado.setBounds(319, 227, 89, 23);
		contentPane.add(btnResultado);
	}
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		Calculo calc = null;
		int conta =  0;
		try {
			calc = (Calculo) Naming.lookup("rmi://10.84.144.250/calculadora");
		} catch (Exception e) {
			e.printStackTrace();
		}
		int a = 0;
		if(botao.equals(btn1)){
			txfJanela.setText("1");
			a = 1;
		}else if(botao.equals(btn2)){
			txfJanela.setText("2");
			a = 2;
		}else if(botao.equals(btn3)){
			txfJanela.setText("3");
			a = 3;
		}else if(botao.equals(btn4)){
			txfJanela.setText("4");
			a = 4;
		}else if(botao.equals(btn5)){
			txfJanela.setText("5");
			a = 5;
		}else if(botao.equals(btn6)){
			txfJanela.setText("6");
			a = 6;
		}
		if(botao.equals(btn7)){
			txfJanela.setText("7");
		}
		if(botao.equals(btn8)){
			txfJanela.setText("8");
		}
		if(botao.equals(btn9)){
			txfJanela.setText("9");
		}else if(botao.equals(btnSoma)){
			conta = Integer.parseInt(txfJanela.getText());
			a = Integer.parseInt( txfJanela.getText());
		}if(botao.equals(btnResultado)){
			
			try {
				txfJanela.setText(String.valueOf(calc.soma(a, Integer.parseInt(txfJanela.getText()))));
				System.out.println(String.valueOf(calc.soma(a, Integer.parseInt(txfJanela.getText()))));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
}
