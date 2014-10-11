package cadFoneDerby;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CadFone extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JLabel lblDdd;
	private JTextField tfDdd;
	private JLabel lblN;
	private JTextField tfNum;
	private JLabel lblTipo;
	private JComboBox<TipoFone> cbTipo;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnSalvar;
	private JButton btnApagar;
	private JButton btnSair;

	private GerenteDeDados dados;
	private FoneModel model;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFone frame = new CadFone();
					frame.conecta();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CadFone() {
		setTitle("Cadastro de Telefones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblDdd = new JLabel("DDD");
		
		tfDdd = new JTextField();
		tfDdd.setColumns(10);
		
		lblN = new JLabel("N\u00BA");
		
		tfNum = new JTextField();
		tfNum.setColumns(10);
		
		lblTipo = new JLabel("Tipo");
		
		cbTipo = new JComboBox<>();
		cbTipo.setModel(new DefaultComboBoxModel<TipoFone>(TipoFone.values()));
		
		scrollPane = new JScrollPane();
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		
		btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(this);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(124)
							.addComponent(btnApagar, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addGap(130)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblDdd)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfDdd, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblN)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(tfNum, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(lblTipo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cbTipo, 0, 172, Short.MAX_VALUE)))
					.addGap(18))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDdd)
						.addComponent(tfDdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblN)
						.addComponent(tfNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipo)
						.addComponent(cbTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnSair)
						.addComponent(btnApagar))
					.addGap(4))
		);
		
		table = new JTable();
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void conecta() throws GerenteException {
		dados = new GerenteDeDados();
		model = new FoneModel(dados);
		table.setModel(model);
		
		JComboBox<TipoFone> combo = new JComboBox<>(TipoFone.values());
		table.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(combo));
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ev) {
		Object botao  = ev.getSource();
		
		try {
			if(botao.equals(btnSalvar)) {
				String ddd = tfDdd.getText();
				String num = tfNum.getText();
				TipoFone tipo = (TipoFone)cbTipo.getSelectedItem();
			
				Fone obj = new Fone();
				obj.setDdd(ddd);
				obj.setNumero(num);
				obj.setTipo(tipo);
			
				model.adiciona(obj);
			
				tfDdd.setText("");
				tfNum.setText("");
				cbTipo.setSelectedIndex(0);
				
				tfDdd.requestFocus();
			} else if(botao.equals(btnApagar)) {
				int linha = table.getSelectedRow();
				
				if(linha > 0) {
					if(table.getRowSorter() != null) 
						linha = table.getRowSorter().convertRowIndexToModel(linha);
					
					model.remove(linha);
				} else {
					JOptionPane.showMessageDialog(this, "Selecione uma Linha");
				}
			} else {
				dados.fecha();
				System.exit(0);
			}
		} catch(GerenteException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
}
