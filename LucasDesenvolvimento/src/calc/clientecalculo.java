package calc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import Rmi.randomNum.RandomInt;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.Naming;

public class clientecalculo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnsete;
	private JButton btnoito;
	private JButton btnnove;
	private JButton btnquatro;
	private JButton btncinco;
	private JButton btnseis;
	private JButton btnum;
	private JButton btndois;
	private JButton btntres;
	private JButton btnzero;
	private JButton btndividir;
	private JButton btnmulti;
	private JButton btnmais;
	private JButton btnmenos;
	private JButton btnigual;
	private JTextField txtnum;
	private JButton btnSair;

	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setSecurityManager(new SecurityManager());
					clientecalculo frame = new clientecalculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public clientecalculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		
		btnsete = new JButton("7");
		btnsete.addActionListener(this);
		
		btnoito = new JButton("8");
		btnoito.addActionListener(this);
		
		btnnove = new JButton("9");
		btnnove.addActionListener(this);
		
		btnquatro = new JButton("4");
		btnquatro.addActionListener(this);
		
		btncinco = new JButton("5");
		btncinco.addActionListener(this);
		
		btnseis = new JButton("6");
		btnseis.addActionListener(this);
		
		btnum = new JButton("1");
		btnum.addActionListener(this);
		
		btndois = new JButton("2");
		btndois.addActionListener(this);
		
		btntres = new JButton("3");
		btntres.addActionListener(this);
		
		btnzero = new JButton("0");
		btnzero.addActionListener(this);
		
		btndividir = new JButton("/");
		btndividir.addActionListener(this);
		
		btnmulti = new JButton("X");
		btnmulti.addActionListener(this);
		
		btnmais = new JButton("+");
		btnmais.addActionListener(this);
		
		btnmenos = new JButton("-");
		btnmenos.addActionListener(this);
		
		btnigual = new JButton("=");
		btnigual.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnsete)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnoito, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnnove, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btndividir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnquatro, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btncinco, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnseis, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnmulti, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnigual, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnum, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btndois, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btntres, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnzero, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnmenos, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnmais, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(8, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(btnSair)
					.addGap(79))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnsete)
						.addComponent(btnoito)
						.addComponent(btnnove)
						.addComponent(btndividir))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnquatro)
						.addComponent(btncinco)
						.addComponent(btnseis)
						.addComponent(btnmulti))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnum)
						.addComponent(btndois)
						.addComponent(btntres)
						.addComponent(btnmais))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnzero)
						.addComponent(btnmenos))
					.addGap(18)
					.addComponent(btnigual)
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(btnSair)
					.addContainerGap())
		);
		
		txtnum = new JTextField();
		panel.add(txtnum);
		txtnum.setColumns(10);
		contentPane.setLayout(gl_contentPane);
	}
	public void actionPerformed(ActionEvent ev) {
		
		Object botao = ev.getSource();
		Calculo obj = (Calculo) Naming.lookup("rmi://10.84.144.250/random");
			if(botao.equals(btnum)){
				try{
					txtnum.setText(String.valueOf(getDefaultCloseOperation()));
					}catch(Exception ex){
						ex.printStackTrace();
					}
			}else
					System.exit(0);
			}
		
		
}
