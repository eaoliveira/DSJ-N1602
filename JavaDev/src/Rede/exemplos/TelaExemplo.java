package Rede.exemplos;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaExemplo extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblMensagem;
	private JTextField tfMsg;
	private JButton btnEnviar;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnConectar;
	private JButton btnDesconectar;
	private JButton btnSair;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					TelaExemplo frame = new TelaExemplo();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
	}

	public TelaExemplo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblMensagem = new JLabel("Mensagem");
		
		tfMsg = new JTextField();
		tfMsg.setActionCommand("Enviar");
		tfMsg.addActionListener(this);
		tfMsg.setColumns(10);
		
		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(this);
		
		scrollPane = new JScrollPane();
		
		btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(this);
		
		btnDesconectar = new JButton("Desconectar");
		btnDesconectar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMensagem)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfMsg, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnEnviar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnConectar, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addComponent(btnDesconectar)
							.addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMensagem)
						.addComponent(tfMsg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEnviar))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConectar)
						.addComponent(btnDesconectar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		
		textArea = new JTextArea();
		textArea.setFocusable(false);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object opcao = ev.getSource();
		
		if(opcao.equals(tfMsg) || opcao.equals(btnEnviar)) {
			
		} else if(opcao.equals(btnConectar)) {
			
		} else if(opcao.equals(btnDesconectar)) {
			
		} else {
			System.exit(0);
		}
	}
}

