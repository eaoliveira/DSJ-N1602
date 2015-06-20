package Rmi.calculadora;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton btnC;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton btnX;
	private JButton button_11;
	private JButton button_12;
	private JButton button_3;
	private JTextField textField;
	private JButton button_13;
	private JButton button_14;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 257);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		button = new JButton("7");
		button.setBounds(10, 52, 56, 23);
		contentPane.add(button);
		
		button_1 = new JButton("4");
		button_1.setBounds(10, 86, 56, 23);
		contentPane.add(button_1);
		
		button_2 = new JButton("1");
		button_2.setBounds(10, 120, 56, 23);
		contentPane.add(button_2);
		
		btnC = new JButton("C");
		btnC.setForeground(Color.BLACK);
		btnC.setBackground(Color.RED);
		btnC.setBounds(10, 154, 56, 23);
		contentPane.add(btnC);
		
		button_4 = new JButton("8");
		button_4.setBounds(76, 52, 56, 23);
		contentPane.add(button_4);
		
		button_5 = new JButton("5");
		button_5.setBounds(76, 86, 56, 23);
		contentPane.add(button_5);
		
		button_6 = new JButton("2");
		button_6.setBounds(76, 120, 56, 23);
		contentPane.add(button_6);
		
		button_7 = new JButton("6");
		button_7.setBounds(142, 86, 56, 23);
		contentPane.add(button_7);
		
		button_8 = new JButton("9");
		button_8.setBounds(142, 52, 56, 23);
		contentPane.add(button_8);
		
		button_9 = new JButton("3");
		button_9.setBounds(142, 120, 56, 23);
		contentPane.add(button_9);
		
		button_10 = new JButton("/");
		button_10.setBounds(208, 52, 56, 23);
		contentPane.add(button_10);
		
		btnX = new JButton("x");
		btnX.setBounds(208, 86, 56, 23);
		contentPane.add(btnX);
		
		button_11 = new JButton("+");
		button_11.setBounds(208, 120, 56, 23);
		contentPane.add(button_11);
		
		button_12 = new JButton("-");
		button_12.setBounds(208, 154, 56, 23);
		contentPane.add(button_12);
		
		button_3 = new JButton("0");
		button_3.setBounds(76, 154, 56, 23);
		contentPane.add(button_3);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 254, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		button_13 = new JButton(".");
		button_13.setBounds(142, 154, 56, 23);
		contentPane.add(button_13);
		
		button_14 = new JButton("=");
		button_14.setBounds(10, 188, 254, 23);
		contentPane.add(button_14);
	}
}
