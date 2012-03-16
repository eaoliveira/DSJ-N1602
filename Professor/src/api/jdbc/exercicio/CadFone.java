package api.jdbc.exercicio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CadFone extends JFrame {
	private JPanel contentPane;
	private JLabel lblDdd;
	private JTextField tfDDD;
	private JLabel lblNumero;
	private JTextField tfNumero;
	private JLabel lblTipo;
	private JComboBox<TipoFone> cbTipo;
	private JButton btnSalvar;
	private JButton btnListar;
	private JButton btnSair;
	private Connection con;
	private PreparedStatement ins;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadFone frame = new CadFone();
					frame.setLocationRelativeTo(null);
					if (frame.conecta())
						frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public boolean conecta() {
		try {
			// Registrar o Driver JDBC na VM Java
			Class.forName("com.mysql.jdbc.Driver");

			// Inicia a conexão ao Banco de Dados
			con = DriverManager.getConnection("jdbc:mysql://localhost/Fone",	"root", "");

			// Preparar uma instrução SQL para a inserção de dados de Aluno
			ins = con	.prepareStatement("insert into Fone (ddd, numero, tipo) values (?,?,?)");

			return true;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this,	"Problemas na Conexão ao Banco de Dados");
			return false;
		}
	}

	public CadFone() {
		setTitle("Cad Fone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnSalvar());
		contentPane.add(getBtnListar());
		contentPane.add(getBtnSair());
		contentPane.add(getLblDdd());
		contentPane.add(getTfDDD());
		contentPane.add(getLblNumero());
		contentPane.add(getTfNumero());
		contentPane.add(getLblTipo());
		contentPane.add(getCbTipo());
	}

	private JLabel getLblDdd() {
		if (lblDdd == null) {
			lblDdd = new JLabel("DDD");
			lblDdd.setBounds(5, 19, 42, 15);
		}
		return lblDdd;
	}

	private JTextField getTfDDD() {
		if (tfDDD == null) {
			tfDDD = new JTextField();
			tfDDD.setBounds(47, 17, 51, 19);
			tfDDD.setColumns(10);
		}
		return tfDDD;
	}

	private JLabel getLblNumero() {
		if (lblNumero == null) {
			lblNumero = new JLabel("Nº");
			lblNumero.setBounds(105, 19, 30, 15);
		}
		return lblNumero;
	}

	private JTextField getTfNumero() {
		if (tfNumero == null) {
			tfNumero = new JTextField();
			tfNumero.setBounds(143, 17, 86, 19);
			tfNumero.setColumns(10);
		}
		return tfNumero;
	}

	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo");
			lblTipo.setBounds(5, 59, 42, 15);
		}
		return lblTipo;
	}

	private JComboBox<TipoFone> getCbTipo() {
		if (cbTipo == null) {
			cbTipo = new JComboBox<TipoFone>();
			cbTipo.setModel(new DefaultComboBoxModel<TipoFone>(TipoFone.values()));
			cbTipo.setBounds(45, 54, 134, 24);
		}
		return cbTipo;
	}

	private JButton getBtnSalvar() {
		if (btnSalvar == null) {
			btnSalvar = new JButton("Salvar");
			btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ins.setString(1, tfDDD.getText());
						ins.setString(2, tfNumero.getText());
						ins.setString(3, ((TipoFone) cbTipo.getSelectedItem()).toString());
						ins.execute();
						
						tfDDD.setText("");
						tfNumero.setText("");
						cbTipo.setSelectedIndex(0);
						tfDDD.requestFocus();
					} catch (SQLException ex) {
						JOptionPane.showMessageDialog(null,
								"Erro:\n" + ex.getLocalizedMessage());
					}
				}
			});
			btnSalvar.setBounds(13, 96, 78, 25);
		}
		return btnSalvar;
	}

	private JButton getBtnListar() {
		if (btnListar == null) {
			btnListar = new JButton("Listar");
			btnListar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
					String msg = "Cadastro de Telefones\n\n";
					
					// Executar um SQL de consulta ao banco
					Statement sql  = con.createStatement();
					ResultSet resposta = sql.executeQuery("select * from Fone");
					
					// Apresenta o resultado da consulta SQL
					while(resposta.next()) {
					  msg +=	"(" + resposta.getString("ddd") + ") " + 
					  		                   resposta.getString("numero") + " - " +
					  		                   resposta.getString("tipo") +		"\n";
					}
					JOptionPane.showMessageDialog(null, msg);
					} catch(SQLException ex) {
						JOptionPane.showMessageDialog(null,
								"Erro:\n" + ex.getLocalizedMessage());
					}
				}
			});
			btnListar.setBounds(104, 96, 75, 25);
		}
		return btnListar;
	}

	private JButton getBtnSair() {
		if (btnSair == null) {
			btnSair = new JButton("Sair");
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						con.close();
					} catch (SQLException ex) {
					}

					System.exit(0);
				}
			});
			btnSair.setBounds(192, 96, 62, 25);
		}
		return btnSair;
	}
}
