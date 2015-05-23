package banco;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import banco.model.Agencia;
import banco.model.Caixa;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AgenciaBancaria extends JFrame implements ActionListener, Runnable {

	private JPanel contentPane;
	private JTextField tfFilaPref;
	private JTextField tfFileNorm;
	private JTextField tfCx1;
	private JTextField tfCx2;
	private JTextField tfCx3;
	private JTextField tfCx4;
	private JTextField tfCx5;
	private JSpinner spinner;
	private JTextField[] tx = new JTextField[5];
	private JButton btnSalvar;
	private JButton btnAbreAAgncia;
	private JButton btnFechaAAgncia;
	
	private Agencia ag = new Agencia();
	private Thread thread;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgenciaBancaria frame = new AgenciaBancaria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AgenciaBancaria() {
		setResizable(false);
		setTitle("Ag\u00EAncia Banc\u00E1ria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Simula\u00E7\u00E3o de Filas");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 28));
		
		JLabel lblFilaPreferencial = new JLabel("Fila Preferencial");
		
		JLabel lblNewLabel_1 = new JLabel("N\u00BA de Pessoa p/ 5 seg");
		
		JLabel lblFilaNormal = new JLabel("Fila Normal");
		
		tfFilaPref = new JTextField();
		tfFilaPref.setEditable(false);
		tfFilaPref.setBackground(Color.PINK);
		tfFilaPref.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(10, 0, 10, 1));
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		tfFileNorm = new JTextField();
		tfFileNorm.setEditable(false);
		tfFileNorm.setBackground(Color.CYAN);
		tfFileNorm.setColumns(10);
		
		JLabel lblCaixas = new JLabel("Caixas");
		
		tfCx1 = new JTextField();
		tfCx1.setBackground(Color.PINK);
		tfCx1.setColumns(10);
		tx[0] = tfCx1;
		
		tfCx2 = new JTextField();
		tfCx2.setColumns(10);
		tfCx2.setBackground(Color.PINK);
		tx[1] = tfCx2;
		
		tfCx3 = new JTextField();
		tfCx3.setColumns(10);
		tfCx3.setBackground(Color.CYAN);
		tx[2] = tfCx3;
		
		tfCx4 = new JTextField();
		tfCx4.setColumns(10);
		tfCx4.setBackground(Color.CYAN);
		tx[3] = tfCx4;

		tfCx5 = new JTextField();
		tfCx5.setColumns(10);
		tfCx5.setBackground(Color.CYAN);
		tx[4] = tfCx5;

		btnAbreAAgncia = new JButton("Abre a Ag\u00EAncia");
		btnAbreAAgncia.addActionListener(this);
		
		btnFechaAAgncia = new JButton("Fecha a Ag\u00EAncia");
		btnFechaAAgncia.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(100)
					.addComponent(lblNewLabel))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addComponent(lblFilaPreferencial)
					.addGap(38)
					.addComponent(lblNewLabel_1)
					.addGap(29)
					.addComponent(lblFilaNormal, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(tfFilaPref, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnSalvar)
					.addGap(21)
					.addComponent(tfFileNorm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(199)
					.addComponent(lblCaixas))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addComponent(tfCx1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(tfCx2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(tfCx3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(tfCx4, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(tfCx5, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAbreAAgncia)
					.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
					.addComponent(btnFechaAAgncia))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFilaPreferencial)
						.addComponent(lblNewLabel_1)
						.addComponent(lblFilaNormal))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tfFilaPref, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSalvar)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(tfFileNorm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(24)
					.addComponent(lblCaixas)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tfCx1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCx2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCx3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCx4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfCx5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAbreAAgncia)
						.addComponent(btnFechaAAgncia)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object botao = ev.getSource();
		
		if(botao.equals(btnSalvar)) {
			Number num = (Number)spinner.getValue();
			ag.setQtdClientes(num.intValue());
		} else if(botao.equals(btnAbreAAgncia)) {
			ag.abrir();
			thread = new Thread(this);
			thread.start();
		} else {
			thread.interrupt();
			ag.fechar();
		}
	}
	
	public void run() {
		try {
			while(!thread.isInterrupted()) {
				tfFilaPref.setText(String.valueOf(ag.getPreferencial().quantos()));
				tfFileNorm.setText(String.valueOf(ag.getNormal().quantos()));
				
				Caixa[] cx = ag.getCaixas();
				for (int i = 0;i < tx.length;i++) {
					tx[i].setText(String.valueOf(cx[i].getAtendimento()));
				}
				
				Thread.sleep(5000);
			}
		} catch(InterruptedException ex) {
		}
	}
}
