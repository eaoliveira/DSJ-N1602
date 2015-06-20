package Rmi.randomNum;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.Naming;

@SuppressWarnings("serial")
public class RandomClient extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnGerar;
	private JScrollPane scrollPane;
	private JTextArea tfTela;
	private JLabel lblGerarNmerosAleatrios;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					System.setSecurityManager(new SecurityManager());
					RandomClient frame = new RandomClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public RandomClient() {
		setTitle("Gerar Aleat\u00F3rio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		btnGerar = new JButton("Gerar N\u00FAmero");
		btnGerar.addActionListener(this);
		contentPane.add(btnGerar, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tfTela = new JTextArea();
		scrollPane.setViewportView(tfTela);
		
		lblGerarNmerosAleatrios = new JLabel("Gerar n\u00FAmeros aleat\u00F3rios pelo servidor");
		lblGerarNmerosAleatrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblGerarNmerosAleatrios.setFont(new Font("Tahoma", Font.BOLD, 18));
		scrollPane.setColumnHeaderView(lblGerarNmerosAleatrios);
		this.setLocationRelativeTo(null);
	}

	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		try {
			if (botao.equals(btnGerar)) {
				for (int i = 0; i < 10; i++) {
					RandomInt ri = (RandomInt)Naming.lookup("rmi://10.84.144.41/iRandom");
					tfTela.append("Número" + (i+1) + ": " + ri.nextInt() + "\n");
				}
			}
			
			
		} catch (Exception ex) {

		}
		
	}
}
