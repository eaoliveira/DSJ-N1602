package Rmi.calc;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Rmi.randomNum.RandomInt;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraView extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn0;
	private JButton btnPonto;
	private JButton btnDivide;
	private JButton btnMultiplica;
	private JButton btnSubtrai;
	private JButton btnSoma;
	private JButton btnResult;
	private JButton btnRestoDivisao;
	private JPanel panel_1;
	private JTextField txtResult;
	private String valor = "";
	private String operacao = "";
	private double num1, num2, result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setSecurityManager(new SecurityManager());
					CalculadoraView frame = new CalculadoraView();
					frame.setLocationRelativeTo(null);
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
	public CalculadoraView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 268);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 298, 227);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(10, 81, 278, 130);
		panel.add(panel_1);
		panel_1.setLayout(null);

		btn7 = new JButton("7");
		btn7.addActionListener(this);
		btn7.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn7.setBounds(10, 11, 45, 23);
		panel_1.add(btn7);

		btn8 = new JButton("8");
		btn8.addActionListener(this);
		btn8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn8.setBounds(61, 11, 45, 23);
		panel_1.add(btn8);

		btn9 = new JButton("9");
		btn9.addActionListener(this);
		btn9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn9.setBounds(112, 11, 45, 23);
		panel_1.add(btn9);

		btnDivide = new JButton("/");
		btnDivide.addActionListener(this);
		btnDivide.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnDivide.setBounds(167, 11, 45, 23);
		panel_1.add(btnDivide);

		btnRestoDivisao = new JButton("%");
		btnRestoDivisao.addActionListener(this);
		btnRestoDivisao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));
		btnRestoDivisao.setBounds(222, 11, 45, 23);
		panel_1.add(btnRestoDivisao);

		btnResult = new JButton("=");
		btnResult.addActionListener(this);
		btnResult.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnResult.setBounds(222, 40, 45, 81);
		panel_1.add(btnResult);

		btnSubtrai = new JButton("-");
		btnSubtrai.addActionListener(this);
		btnSubtrai
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSubtrai.setBounds(167, 69, 45, 23);
		panel_1.add(btnSubtrai);

		btnSoma = new JButton("+");
		btnSoma.addActionListener(this);
		btnSoma.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnSoma.setBounds(167, 98, 45, 23);
		panel_1.add(btnSoma);

		btnMultiplica = new JButton("*");
		btnMultiplica.addActionListener(this);
		btnMultiplica.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null,
				null));
		btnMultiplica.setBounds(167, 40, 45, 23);
		panel_1.add(btnMultiplica);

		btn6 = new JButton("6");
		btn6.addActionListener(this);
		btn6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn6.setBounds(112, 40, 45, 23);
		panel_1.add(btn6);

		btn3 = new JButton("3");
		btn3.addActionListener(this);
		btn3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn3.setBounds(112, 69, 45, 23);
		panel_1.add(btn3);

		btnPonto = new JButton(",");
		btnPonto.addActionListener(this);
		btnPonto.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnPonto.setBounds(112, 98, 45, 23);
		panel_1.add(btnPonto);

		btn0 = new JButton("0");
		btn0.addActionListener(this);
		btn0.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn0.setBounds(10, 98, 96, 23);
		panel_1.add(btn0);

		btn2 = new JButton("2");
		btn2.addActionListener(this);
		btn2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn2.setBounds(61, 69, 45, 23);
		panel_1.add(btn2);

		btn5 = new JButton("5");
		btn5.addActionListener(this);
		btn5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn5.setBounds(61, 40, 45, 23);
		panel_1.add(btn5);

		btn4 = new JButton("4");
		btn4.addActionListener(this);
		btn4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn4.setBounds(10, 40, 45, 23);
		panel_1.add(btn4);

		btn1 = new JButton("1");
		btn1.addActionListener(this);
		btn1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btn1.setBounds(10, 69, 45, 23);
		panel_1.add(btn1);

		txtResult = new JTextField();
		txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		txtResult.setBackground(Color.CYAN);
		txtResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtResult.setForeground(Color.BLACK);
		txtResult.setBounds(10, 11, 278, 59);
		panel.add(txtResult);
		txtResult.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();
		
		
			try {
				Calculo calcular = (Calculo) Naming.lookup("rmi://10.84.144.250/calculadora");
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NotBoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
	}		


		
			
	
	public enum Operadores {
		SOMA, SUBTRACAO, MULTIPLICACAO, DIVISAO, RESTO_DIVISAO;
	}

}
