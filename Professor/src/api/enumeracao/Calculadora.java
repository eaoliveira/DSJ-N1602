package api.enumeracao;

import static api.gui.Util.criaPainel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Calculadora extends JFrame implements ActionListener {
	private Operacao op = null;
	private boolean posOp = false;
	private double num = Double.MIN_VALUE;
	private JTextField entrada = new JTextField(10);
	private String[] botoes = { 
			"7", "8", "9", "/", 
			"4", "5", "6", "*", 
			"1", "2",	"3", "-", 
			"0", "C", "=", "+" };
	
	public Calculadora() {
		setTitle("Calculadora");
		
		entrada.setEditable(false);
		entrada.setBackground(Color.white);
		entrada.setHorizontalAlignment(JTextField.RIGHT);
		add(criaPainel(new FlowLayout(), entrada), "North");
		JPanel pnBotoes = new JPanel(new GridLayout(4, 4));
		for(String n : botoes) {
			JButton bt = new JButton(n);
			bt.addActionListener(this);
			pnBotoes.add(bt);
		}
		add(pnBotoes, "Center");
		
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		try {
			if(cmd.equals("C")) {
				entrada.setText("");
				op = null;
				num = Double.MIN_VALUE;
			} else if(cmd.equals("+")) {
				op = Operacao.SOMA;
				num = Double.parseDouble(entrada.getText());
				entrada.setText("");
			} else if(cmd.equals("-")) {
				op = Operacao.SUBTRACAO;
				num = Double.parseDouble(entrada.getText());
				entrada.setText("");
			} else if(cmd.equals("*")) {
				op = Operacao.MULTIPLICACAO;
				num = Double.parseDouble(entrada.getText());
				entrada.setText("");
			} else if(cmd.equals("/")) {
				op = Operacao.DIVISAO;
				num = Double.parseDouble(entrada.getText());
				entrada.setText("");
			} else if(cmd.equals("=")) {
				if(op != null && num != Double.MIN_VALUE) {
					int num2 = Integer.parseInt(entrada.getText());
					num = op.execute((int) num, num2);
					entrada.setText(String.valueOf((int) num));
					op = null;
					posOp = true;
				}
			} else {
				if(posOp) {
					entrada.setText(cmd);
					posOp = false;
				} else {
				  entrada.setText(entrada.getText() + cmd);
				}
			}
		} catch(NumberFormatException ex) {
			op = null;
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Calculadora();
			}
		});
	}
}
