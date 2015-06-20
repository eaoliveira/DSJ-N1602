package banco;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Tela extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JTextField tfFilaPreferencial;
	private JLabel lblFilaNormal;
	private JTextField tfFilaNormal;
	private JLabel lblNDePessoas;
	private JSpinner spinner;
	private JButton btnSlavar;
	private JLabel lblCaixas;
	private JTextField tfCaixa1;
	private JTextField tfCaixa2;
	private JTextField tfCaixa3;
	private JTextField tfCaixa4;
	private JTextField tfCaixa5;
	private JButton btnAbreAg;
	private JButton btnFechaAg;
	private JLabel lblAgnciaBancria;
	private Agencia ag;

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable ex) {
			ex.getMessage();
			ex.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFilaPreferencial = new JLabel("Fila Preferencial");
		
		tfFilaPreferencial = new JTextField();
		tfFilaPreferencial.setBackground(new Color(233, 150, 122));
		tfFilaPreferencial.setColumns(10);
		tfFilaPreferencial.setEditable(false);
		
		lblFilaNormal = new JLabel("Fila Normal");
		
		tfFilaNormal = new JTextField();
		tfFilaNormal.setBackground(new Color(135, 206, 250));
		tfFilaNormal.setColumns(10);
		tfFilaNormal.setEditable(false);
		
		lblNDePessoas = new JLabel("N\u00BA de pessoas p/ 5seg");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(10, 0, 25, 1));
		
		
		btnSlavar = new JButton("Salvar");
		btnSlavar.addActionListener(this);
		
		lblCaixas = new JLabel("Caixas");
		
		tfCaixa1 = new JTextField();
		tfCaixa1.setBackground(new Color(233, 150, 122));
		tfCaixa1.setColumns(10);
		tfCaixa1.setEditable(false);
		
		tfCaixa2 = new JTextField();
		tfCaixa2.setBackground(new Color(233, 150, 122));
		tfCaixa2.setColumns(10);
		tfCaixa2.setEditable(false);
		
		tfCaixa3 = new JTextField();
		tfCaixa3.setBackground(new Color(135, 206, 250));
		tfCaixa3.setColumns(10);
		tfCaixa3.setEditable(false);
		
		tfCaixa4 = new JTextField();
		tfCaixa4.setBackground(new Color(135, 206, 250));
		tfCaixa4.setColumns(10);
		tfCaixa4.setEditable(false);
		
		tfCaixa5 = new JTextField();
		tfCaixa5.setBackground(new Color(135, 206, 250));
		tfCaixa5.setColumns(10);
		tfCaixa5.setEditable(false);
		
		btnAbreAg = new JButton("Abre Ag\u00EAncia Banc\u00E1ria");
		btnAbreAg.addActionListener(this);
		
		btnFechaAg = new JButton("Fecha Ag\u00EAncia Banc\u00E1ria");
		btnFechaAg.addActionListener(this);
		
		lblAgnciaBancria = new JLabel("Ag\u00EAncia Banc\u00E1ria - Simulador de Filas");
		lblAgnciaBancria.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFilaPreferencial)
										.addComponent(tfFilaPreferencial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(35)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFilaNormal)
										.addComponent(tfFilaNormal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(32)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNDePessoas)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnSlavar))))
								.addComponent(lblCaixas)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(tfCaixa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tfCaixa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tfCaixa3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tfCaixa4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(tfCaixa5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAbreAg)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnFechaAg))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAgnciaBancria)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAgnciaBancria)
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFilaPreferencial)
						.addComponent(lblFilaNormal)
						.addComponent(lblNDePessoas))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfFilaPreferencial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfFilaNormal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSlavar))
					.addGap(38)
					.addComponent(lblCaixas)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfCaixa1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCaixa2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCaixa3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCaixa4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCaixa5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbreAg)
						.addComponent(btnFechaAg))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
	
	}

	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnSlavar)) {
			Agencia ag = new Agencia();
			ag.setnClientes(Integer.parseInt(spinner.getValue().toString()));
			
			
		} else if(botao.equals(btnAbreAg)) {
			
			
		} else {
			System.exit(0);
		}
		
	}
	
	public void run() {
		
	}
	
}
