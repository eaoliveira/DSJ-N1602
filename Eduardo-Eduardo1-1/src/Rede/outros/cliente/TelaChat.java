package Rede.outros.cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaChat {

	private  JFrame frame;
	private  JPanel panel;
	private JScrollPane scrollPane;
	private  JTextArea textArea1;
	private JLabel label1;
	private JTextField textField;
	private JButton button;
	
	//private  EmissorDeMensagem emissorDeMensagem;

	public TelaChat() {
		
		this.frame = new JFrame("K19 - Chat");
		this.panel = new JPanel();
		this.textArea1 = new JTextArea(10, 60);
		this.textArea1.setEditable(false);
		this.scrollPane = new JScrollPane(this.textArea1);
		this.label1 = new JLabel("Digite uma mensagem...");
		this.textField = new JTextField(60);
		this.button = new JButton("Enviar");
		this.frame.setContentPane(this.panel);
		this.panel.add(this.scrollPane);
		this.panel.add(this.label1);
		this.panel.add(this.textField);
		this.panel.add(button);
		class EnviaMensagemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
		//		emissorDeMensagem.envia(textField.getText());
				textField.setText("");
			}
		}
		this.button.addActionListener(new EnviaMensagemListener());
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setSize(700, 300);
		this.frame.setVisible(true);
	}

	public void adicionaMensagem(String mensagem) {
		this.textArea1.append(mensagem + "\n");
	}
}
