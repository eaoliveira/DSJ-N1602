package api.math.resposta;

import static api.gui.Util.criaBotao;
import static api.gui.Util.criaPainel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Volume extends JFrame implements ActionListener {
	private JTextField tfLado = new JTextField(7);
	private JTextField tfResposta = new JTextField(12);

	public Volume() {
		setTitle("Volume");

		tfResposta.setEditable(false);
		tfResposta.setBackground(getBackground());

		add(criaPainel(new GridLayout(2, 1), 
				criaPainel("Lado", tfLado), 
				criaPainel("Resultado", tfResposta))
			, "Center");

		add(criaPainel(
				criaBotao("Calcular", KeyEvent.VK_C, this), 
				criaBotao("Sair", KeyEvent.VK_S, this))
			, "South");

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();

		if(cmd.equals("Calcular")) {
			try {
				NumberFormat fmt = 
					NumberFormat.getNumberInstance(new Locale("pt", "BR"));
				fmt.setMaximumFractionDigits(2);
				fmt.setMinimumFractionDigits(2);
				double volume = fmt.parse(	tfLado.getText()).doubleValue();
				tfResposta.setText(fmt.format(Math.pow(volume, 3)));
					
				tfLado.setText("");
				tfLado.requestFocus();
			} catch(ParseException ex) {
				JOptionPane.showMessageDialog(this, "Número Inválido!");
			}
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Volume();
	}
}
