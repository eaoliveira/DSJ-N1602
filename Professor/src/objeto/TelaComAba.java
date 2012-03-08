package objeto;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import objeto.resposta.Endereco;

@SuppressWarnings("serial")
public class TelaComAba extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btOk;
	private JButton btListar;
	private JButton button;
  private Endereco endereco;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComAba frame = new TelaComAba();
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
	public TelaComAba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(31, 12, 70, 15);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(119, 10, 231, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(26, 74, 408, 209);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Especial", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblCc = new JLabel("CC");
		lblCc.setBounds(38, 33, 70, 15);
		panel.add(lblCc);
		
		textField_1 = new JTextField();
		textField_1.setBounds(136, 31, 114, 19);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Vip", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblBeneficios = new JLabel("Beneficios");
		lblBeneficios.setBounds(31, 81, 110, 15);
		panel_1.add(lblBeneficios);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(159, 76, 157, 24);
		panel_1.add(comboBox);
		
		btOk = new JButton("OK");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idx = tabbedPane.getSelectedIndex();
				JOptionPane.showMessageDialog(null, "A aba selecionada é " +
						(idx == 0 ? "Especial" : "VIP"));
			}
		});
		btOk.setBounds(26, 295, 117, 25);
		contentPane.add(btOk);
		
		btListar = new JButton("Listar");
		btListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, endereco);
			}
		});
		btListar.setBounds(167, 295, 117, 25);
		contentPane.add(btListar);
		
		JLabel lblEnd = new JLabel("End.");
		lblEnd.setBounds(31, 39, 70, 15);
		contentPane.add(lblEnd);
		
		button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// continua ....
				TelaEndereco dialog = new TelaEndereco();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

				endereco = dialog.getEndereco();
			}
		});
		button.setBounds(80, 39, 37, 25);
		contentPane.add(button);
	}
}
