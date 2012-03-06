package objeto;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class NovaTela4 extends JFrame {

	private JPanel contentPane;
	private JButton btOk;
	private JButton btSair;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovaTela4 frame = new NovaTela4();
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
	public NovaTela4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Graphics g = getGraphics();
		//setBounds(100, 100, 450, 300)
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btOk = new JButton("Ok");
		btOk.setBounds(70, 241, 117, 25);
		contentPane.add(btOk);
		
		btSair = new JButton("Sair");
		btSair.setBounds(257, 241, 117, 25);
		contentPane.add(btSair);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(70, 36, 70, 15);
		contentPane.add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(70, 115, 70, 15);
		contentPane.add(lblIdade);
		
		textField = new JTextField();
		textField.setBounds(178, 34, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 113, 63, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
