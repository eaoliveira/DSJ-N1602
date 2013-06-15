package Rede.cliente;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ModeloDeCliente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField tfMens;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnConectar;
	private JButton btnSair;

	//....
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModeloDeCliente frame = new ModeloDeCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ModeloDeCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(30, 34, 75, 16);
		contentPane.add(lblMensagem);
		
		tfMens = new JTextField();
		tfMens.setBounds(116, 28, 241, 28);
		contentPane.add(tfMens);
		tfMens.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		btnEnviar.setBounds(369, 29, 75, 29);
		contentPane.add(btnEnviar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 74, 403, 150);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		btnConectar.setBounds(16, 236, 117, 29);
		contentPane.add(btnConectar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		btnSair.setBounds(145, 236, 117, 29);
		contentPane.add(btnSair);
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		if(cmd.equals("Conectar")) {
			
		} else if(cmd.equals("Enviar")) {
			
		} else {
			
		}
	}
}
