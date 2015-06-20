package banco;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class BancoView extends JFrame{
	private JPanel contentPane;
	
	public static void main(String[] args) {
		BancoView frame = new BancoView();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);				
	}

	
	public BancoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 684);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 851, 645);
		contentPane.add(panel);
		
		JLabel lblCaixa = new JLabel("Caixa 01");
		lblCaixa.setBounds(114, 337, 117, 172);
		lblCaixa.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCaixa.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCaixa.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaixa.setIcon(new ImageIcon("C:\\Users\\javades\\Desktop\\Lucas\\workspace\\Lucas\\src\\banco\\imagens\\pdv.png"));
		
		JLabel lblCaixa_1 = new JLabel("Caixa 02");
		lblCaixa_1.setBounds(243, 337, 117, 172);
		lblCaixa_1.setIcon(new ImageIcon("C:\\Users\\javades\\Desktop\\Lucas\\workspace\\Lucas\\src\\banco\\imagens\\pdv.png"));
		lblCaixa_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCaixa_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCaixa_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCaixa_2 = new JLabel("Caixa 03");
		lblCaixa_2.setBounds(372, 337, 117, 172);
		lblCaixa_2.setIcon(new ImageIcon("C:\\Users\\javades\\Desktop\\Lucas\\workspace\\Lucas\\src\\banco\\imagens\\pdv.png"));
		lblCaixa_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCaixa_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCaixa_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCaixa_3 = new JLabel("Caixa 04");
		lblCaixa_3.setBounds(501, 337, 117, 172);
		lblCaixa_3.setIcon(new ImageIcon("C:\\Users\\javades\\Desktop\\Lucas\\workspace\\Lucas\\src\\banco\\imagens\\pdv.png"));
		lblCaixa_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCaixa_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCaixa_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCaixa_4 = new JLabel("Caixa 05");
		lblCaixa_4.setBounds(630, 337, 117, 172);
		lblCaixa_4.setIcon(new ImageIcon("C:\\Users\\javades\\Desktop\\Lucas\\workspace\\Lucas\\src\\banco\\imagens\\pdv.png"));
		lblCaixa_4.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblCaixa_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCaixa_4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(54, 515, 40, 16);
		
		JLabel lblStatusCx1 = new JLabel("Livre");
		lblStatusCx1.setBounds(112, 515, 119, 16);
		lblStatusCx1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusCx1.setHorizontalTextPosition(SwingConstants.CENTER);
		
		JLabel lblStatusCx2 = new JLabel("Livre");
		lblStatusCx2.setBounds(243, 515, 119, 16);
		lblStatusCx2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblStatusCx2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStatusCx3 = new JLabel("Livre");
		lblStatusCx3.setBounds(374, 515, 119, 16);
		lblStatusCx3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblStatusCx3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStatusCx4 = new JLabel("Livre");
		lblStatusCx4.setBounds(505, 515, 119, 16);
		lblStatusCx4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblStatusCx4.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblStatusCx5 = new JLabel("Livre");
		lblStatusCx5.setBounds(636, 515, 119, 16);
		lblStatusCx5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblStatusCx5.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblQtdeFilaPreferencial = new JLabel("Qtde: ");
		lblQtdeFilaPreferencial.setBounds(219, 153, 100, 16);
		
		JLabel lblFilaPreferencial_1 = new JLabel("Fila Preferencial");
		lblFilaPreferencial_1.setBounds(106, 153, 117, 172);
		lblFilaPreferencial_1.setIcon(new ImageIcon("C:\\Users\\javades\\Desktop\\Lucas\\workspace\\Lucas\\src\\banco\\imagens\\filaPreferencial.png"));
		lblFilaPreferencial_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFilaPreferencial_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFilaPreferencial_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblFilaNormal = new JLabel("Fila Normal");
		lblFilaNormal.setBounds(626, 147, 117, 172);
		lblFilaNormal.setIcon(new ImageIcon("C:\\Users\\javades\\Desktop\\Lucas\\workspace\\Lucas\\src\\banco\\imagens\\filaNormal.png"));
		lblFilaNormal.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFilaNormal.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFilaNormal.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblQtdeFilaNormal = new JLabel("Qtde: ");
		lblQtdeFilaNormal.setBounds(514, 153, 100, 16);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 0, 851, 67);
		panel.setLayout(null);
		panel.add(lblCaixa);
		panel.add(lblStatus);
		panel.add(lblStatusCx1);
		panel.add(lblCaixa_1);
		panel.add(lblCaixa_2);
		panel.add(lblCaixa_3);
		panel.add(lblCaixa_4);
		panel.add(lblStatusCx2);
		panel.add(lblStatusCx3);
		panel.add(lblStatusCx4);
		panel.add(lblStatusCx5);
		panel.add(lblFilaPreferencial_1);
		panel.add(lblFilaNormal);
		panel.add(lblQtdeFilaNormal);
		panel.add(lblQtdeFilaPreferencial);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AG\u00CANCIA BANC\u00C1RIA  -  SIMULADOR DE FILAS E ATENDIMENTO");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 0, 827, 67);
		panel_1.add(lblNewLabel);
		
		JButton btnAbrir = new JButton("Abrir Agência");
		btnAbrir.setBounds(10, 79, 213, 55);
		panel.add(btnAbrir);
		
		JButton btnFecharAgncia = new JButton("Fechar Agência");
		btnFecharAgncia.setBounds(626, 79, 213, 55);
		panel.add(btnFecharAgncia);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(10, 0, 10, 1));
		spinner.setFont(new Font("Dialog", Font.BOLD, 30));
		spinner.setBounds(329, 96, 63, 38);
		panel.add(spinner);
		
		JLabel lblPessoasseg = new JLabel("Pessoas/5seg.");
		lblPessoasseg.setBounds(323, 79, 84, 16);
		panel.add(lblPessoasseg);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(0, 615, 851, 30);
		panel.add(panel_2);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(404, 93, 98, 41);
		panel.add(btnSalvar);
	}


}
