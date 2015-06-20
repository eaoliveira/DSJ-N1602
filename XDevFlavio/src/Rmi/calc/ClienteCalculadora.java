package Rmi.calc;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

@SuppressWarnings("serial")
public class ClienteCalculadora extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfPainel;
	private JButton btnSoma;
	private JButton btnSubtracao;
	private JButton btnMultiplicacao;
	private JButton btnDivisao;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager
							.getSystemLookAndFeelClassName());

					System.setSecurityManager(new SecurityManager());
					ClienteCalculadora frame = new ClienteCalculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ClienteCalculadora() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 225, 231);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		tfPainel = new JTextField();
		tfPainel.setBackground(Color.WHITE);
		tfPainel.setBounds(15, 16, 176, 32);
		tfPainel.setHorizontalAlignment(SwingConstants.RIGHT);
		tfPainel.setFont(new Font("Tahoma", Font.BOLD, 13));
		tfPainel.setColumns(10);

		btnSoma = new JButton("Somar");
		btnSoma.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSoma.setBackground(new Color(100, 149, 237));
		btnSoma.addActionListener(this);
		btnSoma.setBounds(15, 66, 176, 23);

		btnSubtracao = new JButton("Subtrair");
		btnSubtracao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSubtracao.setBackground(new Color(100, 149, 237));
		btnSubtracao.addActionListener(this);
		btnSubtracao.setBounds(15, 95, 176, 23);

		btnMultiplicacao = new JButton("Multiplicar");
		btnMultiplicacao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMultiplicacao.setBackground(new Color(100, 149, 237));
		btnMultiplicacao.addActionListener(this);
		btnMultiplicacao.setBounds(15, 124, 176, 23);

		btnDivisao = new JButton("Dividir");
		btnDivisao.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDivisao.setBackground(new Color(100, 149, 237));
		btnDivisao.addActionListener(this);
		btnDivisao.setBounds(15, 153, 176, 23);
		contentPane.setLayout(null);
		contentPane.add(tfPainel);
		contentPane.add(btnDivisao);
		contentPane.add(btnMultiplicacao);
		contentPane.add(btnSubtracao);
		contentPane.add(btnSoma);
		this.setLocationRelativeTo(null);
		tfPainel.setEditable(false);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		try {
			
			Calculo cl = (Calculo) Naming.lookup("rmi://10.84.144.41/iCalculo");
			
			int var1 = 0;
			int var2 = 0;
			float resultado = 0;
			
			
			if (botao.equals(btnSoma)) {
				tfPainel.setText("");
				var1 = Integer.parseInt(JOptionPane.showInputDialog("Valor 1"));
				var2 = Integer.parseInt(JOptionPane.showInputDialog("Valor 2"));
				resultado = cl.soma(var1, var2);				
				tfPainel.setText(String.valueOf(resultado));
				
			} else if (botao.equals(btnSubtracao)) {
				tfPainel.setText("");
				var1 = Integer.parseInt(JOptionPane.showInputDialog("Valor 1"));
				var2 = Integer.parseInt(JOptionPane.showInputDialog("Valor 2"));
				resultado = cl.subtrai(var1, var2);				
				tfPainel.setText(String.valueOf(resultado));
				
			} else if (botao.equals(btnMultiplicacao)) {
				tfPainel.setText("");
				var1 = Integer.parseInt(JOptionPane.showInputDialog("Valor 1"));
				var2 = Integer.parseInt(JOptionPane.showInputDialog("Valor 2"));
				resultado = cl.multiplica(var1, var2);				
				tfPainel.setText(String.valueOf(resultado));
				
			} else if (botao.equals(btnDivisao)) {
				tfPainel.setText("");
				var1 = Integer.parseInt(JOptionPane.showInputDialog("Valor 1"));
				var2 = Integer.parseInt(JOptionPane.showInputDialog("Valor 2"));
				resultado = cl.divide(var1, var2);				
				tfPainel.setText(String.valueOf(resultado));
				
			}

			
		} catch (Exception ex) {
			ex.printStackTrace();
			ex.getMessage();
		
		}
		
	}
}
