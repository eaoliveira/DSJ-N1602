package api.math.resposta;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

@SuppressWarnings("serial")
public class Ciclista2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfResultado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ciclista2 frame = new Ciclista2();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ciclista2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 226, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Voltas");
		lblNewLabel.setBounds(59, 14, 45, 15);

		NumberFormatter fmt = new NumberFormatter(NumberFormat.getInstance());

		final JFormattedTextField tfVoltas = new JFormattedTextField();
		tfVoltas.setFormatterFactory(new DefaultFormatterFactory(fmt));
		tfVoltas.setBounds(110, 12, 59, 19);
		tfVoltas.setColumns(5);

		JLabel lblNewLabel_1 = new JLabel("Di\u00E2metro");
		lblNewLabel_1.setBounds(39, 41, 65, 15);

		final JFormattedTextField tfDiametro = new JFormattedTextField();
		tfDiametro.setFormatterFactory(new DefaultFormatterFactory(fmt));
		tfDiametro.setBounds(110, 39, 59, 19);
		tfDiametro.setColumns(5);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(32, 68, 72, 15);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel);
		contentPane.add(tfVoltas);
		contentPane.add(lblNewLabel_1);
		contentPane.add(tfDiametro);
		contentPane.add(lblResultado);

		tfResultado = new JTextField();
		tfResultado.setEditable(false);
		tfResultado.setBounds(110, 66, 72, 19);
		contentPane.add(tfResultado);
		tfResultado.setColumns(10);

		JButton btCalcular = new JButton("Calcular");
		btCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NumberFormat fmt = NumberFormat.getNumberInstance();
					fmt.setMaximumFractionDigits(2);
					Number obj = null;

					obj = (Number)tfVoltas.getValue();
					int voltas = obj.intValue();

					obj = (Number)tfDiametro.getValue();
					double diametro = obj.doubleValue();

					double perimetro = Math.PI * diametro * voltas; 
					tfResultado.setText(fmt.format(perimetro));
						
					tfVoltas.setText("");
					tfVoltas.requestFocus();
					tfDiametro.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Valor invalido");
				//	ex.printStackTrace();
				}
			}
		});
		btCalcular.setMnemonic('c');
		btCalcular.setBounds(12, 106, 91, 25);
		contentPane.add(btCalcular);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btSair.setBounds(117, 106, 81, 25);
		contentPane.add(btSair);
	}
}
