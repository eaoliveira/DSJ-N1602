package Rede;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Frame_Rede extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton = new JButton("Sair");
	private JButton btnNewButton_1 = new JButton("Conectar");
	private JButton btnNewButton_2 = new JButton("Desconectar");
	private JButton btnEnviar = new JButton("Enviar");
	private JScrollPane scrollPane = new JScrollPane();
	static JTextArea textArea = new JTextArea();
	Conexao_Cliente cliente;
	Thread t;
	int Conexao_Iniciada = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_Rede frame = new Frame_Rede();
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
	public Frame_Rede() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(67, 8, 264, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Mensagem");
		lblNewLabel.setBounds(10, 11, 66, 14);
		contentPane.add(lblNewLabel);

		scrollPane.setBounds(10, 53, 414, 160);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(textArea);

		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(335, 224, 89, 23);
		contentPane.add(btnNewButton);

		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(10, 224, 89, 23);
		contentPane.add(btnNewButton_1);

		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(151, 224, 132, 23);
		contentPane.add(btnNewButton_2);

		btnEnviar.setBounds(335, 7, 89, 23);
		btnEnviar.addActionListener(this);
		contentPane.add(btnEnviar);
	}

	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		// *******************************************************
		// Encerra o Programa
		if (source.equals(btnNewButton)) {
			System.exit(0);
		}
		// ******************************************************
		// Inicia Conexao + Thread
		else if (source.equals(btnNewButton_1)) {
			if (Conexao_Iniciada == 0) {
				cliente = new Conexao_Cliente(textArea);
				Conexao_Iniciada = 1;
			}
		}
		// *******************************************************

		else if (source.equals(btnEnviar)) {
			cliente.send(textField.getText());
			textField.setText("");
			textField.requestFocus();
		}
		// *******************************************************
		else if (source.equals(btnNewButton_2)) {
			if (Conexao_Iniciada == 1) {
				cliente.close();
				Conexao_Iniciada = 0;
			}
		}

	}
}
