package Rmi.Exercicio3;

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
import javax.swing.border.EmptyBorder;

import Rmi.calc.Calculo;

public class ClienteCalculadora extends JFrame implements ActionListener {

	// Variaveis
	float var1, var2;
	boolean var1FoiSelecionada;
	String operacao;
	static Calculo bi;
	private JPanel contentPane;
	private JButton bt7;
	private JButton bt8;
	private JButton bt9;
	private JButton bt4;
	private JButton bt5;
	private JButton bt6;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private JButton btSomar;
	private JButton btPonto;
	private JButton btLimpar;
	private JButton bt0;
	private JButton btSinal;
	private JButton btDividir;
	private JButton btIgual;
	private JButton btMultiplicar;
	private JButton btSubitrair;
	private JTextField tftVisor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCalculadora frame = new ClienteCalculadora();
					frame.setVisible(true);
//					 bi = (Calculo) Naming.lookup("rmi://10.84.144.250/calculadora");//asçdklfjasçldkfjaçslkdjfaçlskdjfaçslkdfjaçslkdjfaçlskdjfaçlskdjfçlaksdjfçalkd
					 bi = (Calculo) Naming.lookup("rmi://127.0.0.1/calcular");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteCalculadora() {
		System.setSecurityManager(new SecurityManager());// sçdjfhasçjkldfhasjklçdfhaçsjdfhçasjkldafslkdfjçaskldjfçlaksdjfasdfas
		// SetaVariaveis
		this.var1 = 0;
		this.var2 = 0;
		this.var1FoiSelecionada = false;
		this.operacao = "";

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 234, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		bt7 = new JButton("7");
		bt7.addActionListener(this);
		bt7.setBounds(10, 112, 50, 23);
		contentPane.add(bt7);

		bt8 = new JButton("8");
		bt8.addActionListener(this);
		bt8.setBounds(59, 112, 50, 23);
		contentPane.add(bt8);

		bt9 = new JButton("9");
		bt9.addActionListener(this);
		bt9.setBounds(108, 112, 49, 23);
		contentPane.add(bt9);

		bt4 = new JButton("4");
		bt4.addActionListener(this);
		bt4.setBounds(10, 146, 50, 23);
		contentPane.add(bt4);

		bt5 = new JButton("5");
		bt5.addActionListener(this);
		bt5.setBounds(59, 146, 50, 23);
		contentPane.add(bt5);

		bt6 = new JButton("6");
		bt6.addActionListener(this);
		bt6.setBounds(108, 146, 49, 23);
		contentPane.add(bt6);

		bt1 = new JButton("1");
		bt1.addActionListener(this);
		bt1.setBounds(10, 180, 50, 23);
		contentPane.add(bt1);

		bt2 = new JButton("2");
		bt2.addActionListener(this);
		bt2.setBounds(59, 180, 50, 23);
		contentPane.add(bt2);

		bt3 = new JButton("3");
		bt3.addActionListener(this);
		bt3.setBounds(108, 180, 49, 23);
		contentPane.add(bt3);

		btSomar = new JButton("+");
		btSomar.addActionListener(this);
		btSomar.setBounds(157, 112, 51, 23);
		contentPane.add(btSomar);

		btPonto = new JButton(".");
		btPonto.addActionListener(this);
		btPonto.setBounds(157, 146, 51, 23);
		contentPane.add(btPonto);

		btLimpar = new JButton("C");
		btLimpar.addActionListener(this);
		btLimpar.setBounds(10, 78, 50, 23);
		contentPane.add(btLimpar);

		bt0 = new JButton("0");
		bt0.addActionListener(this);
		bt0.setBounds(10, 214, 99, 23);
		contentPane.add(bt0);

		btSinal = new JButton("+/-");
		btSinal.addActionListener(this);
		btSinal.setBounds(108, 214, 49, 23);
		contentPane.add(btSinal);

		btDividir = new JButton("/");
		btDividir.addActionListener(this);
		btDividir.setBounds(59, 78, 50, 23);
		contentPane.add(btDividir);

		btIgual = new JButton("=");
		btIgual.addActionListener(this);
		btIgual.setBounds(157, 180, 51, 57);
		contentPane.add(btIgual);

		btMultiplicar = new JButton("*");
		btMultiplicar.addActionListener(this);
		btMultiplicar.setBounds(108, 78, 49, 23);
		contentPane.add(btMultiplicar);

		btSubitrair = new JButton("-");
		btSubitrair.addActionListener(this);
		btSubitrair.setBounds(157, 78, 51, 23);
		contentPane.add(btSubitrair);

		tftVisor = new JTextField();
		tftVisor.setHorizontalAlignment(SwingConstants.RIGHT);
		tftVisor.setFont(new Font("Tahoma", Font.BOLD, 22));
		tftVisor.setBounds(10, 11, 198, 56);
		contentPane.add(tftVisor);
		tftVisor.setColumns(10);
	}

	public void setaVar() {
		if (var1FoiSelecionada) {
			if (this.tftVisor.getText().trim().length() != 0) {

				this.var2 = Float.parseFloat(this.tftVisor.getText().trim());

			} else {
				JOptionPane.showMessageDialog(null,
						"Atribua um Valor antes de setar a operação");
			}

		} else {

			if (this.tftVisor.getText().trim().length() != 0) {
				this.var1 = Float.parseFloat(this.tftVisor.getText().trim());
				this.tftVisor.setText("");
			} else {
				JOptionPane.showMessageDialog(null,
						"Atribua um Valor antes de setar a operação");
			}
			this.var1FoiSelecionada = true;
		}
	}

	public void actionPerformed(ActionEvent e) {
		Object botao = e.getSource();

		// tfData.setText(String.valueOf(bi.nextInt()));
		if (botao == btSomar) {
			setaVar();
			this.operacao = "somar";

		}else if(botao == btMultiplicar){
			setaVar();
			this.operacao = "multiplicar";
		}else if(botao == btDividir){
			setaVar();
			this.operacao = "dividirr";
		}else if(botao == btSubitrair){
			setaVar();
			this.operacao = "Subtrair";
		
		} else if (botao == btIgual) {
			setaVar();
			try {
				//Calculo bi = (Calculo) Naming
				//		.lookup("rmi://10.84.144.250/calculadora");
				switch (this.operacao) {
				case "somar":
					this.tftVisor.setText(String.valueOf(bi.soma((int) var1,
							(int) var2)));
					break;
					
				case "subtrair":
					this.tftVisor.setText(String.valueOf(bi.subtrai((int) var1,
							(int) var2)));
					break;
				case "multiplicar":
					this.tftVisor.setText(String.valueOf(bi.multiplica((int) var1,
							(int) var2)));
					break;
				case "div  midir":
					this.tftVisor.setText(String.valueOf(bi.divide((int) var1,
							(int) var2)));
					break;
				default:
					break;
				}
				this.var1FoiSelecionada = false;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());
				ex.printStackTrace();
			}

		}else if(botao == btLimpar){
			tftVisor.setText("");
			var1=0;
			var2 =0;
			var1FoiSelecionada=false;
		}else if(botao == bt0){
			tftVisor.setText(tftVisor.getText()+0);
		}else if(botao == bt1){
			tftVisor.setText(tftVisor.getText()+1);
		}else if(botao == bt2){
			tftVisor.setText(tftVisor.getText()+2);
		}else if(botao == bt3){
			tftVisor.setText(tftVisor.getText()+3);
		}else if(botao == bt4){
			tftVisor.setText(tftVisor.getText()+4);
		}
		else if(botao == bt5){
			tftVisor.setText(tftVisor.getText()+5);
		}
		else if(botao == bt6){
			tftVisor.setText(tftVisor.getText()+6);
		}
		else if(botao == bt7){
			tftVisor.setText(tftVisor.getText()+7);
		}
		else if(botao == bt8){
			tftVisor.setText(tftVisor.getText()+8);
		}
		else if(botao == bt9){
			tftVisor.setText(tftVisor.getText()+9);
		}else if(botao == btSinal){
			double d = Double.parseDouble(tftVisor.getText());
			d*=-1;
			tftVisor.setText(String.valueOf(d));
		}
		

	}
}
