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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Ciclista extends JFrame implements ActionListener {
	private JTextField tfVoltas = new JTextField(7);
	private JTextField tfDiametro = new JTextField(7);
	private JTextField tfResposta = new JTextField(7);

	public Ciclista() {
		setTitle("Ciclista");
    // desativa a edição, o foco e configura a cor de fundo
		// do textfield de resposta
		tfResposta.setEditable(false);
		tfResposta.setFocusable(false);
		tfResposta.setBackground(getBackground());

		add(criaPainel(new GridLayout(3, 1), 
				criaPainel("Voltas", tfVoltas), 
				criaPainel("Diâmetro", tfDiametro), 
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
				NumberFormat fmt = 	NumberFormat.getNumberInstance(new Locale("pt", "BR"));
				fmt.setMaximumFractionDigits(2);
				double voltas = fmt.parse(	tfVoltas.getText()).doubleValue();
				double diametro = fmt.parse(tfDiametro.getText()).doubleValue();
				double perimetro = Math.PI * diametro * voltas; 
				tfResposta.setText(fmt.format(perimetro));
					
				tfVoltas.setText("");
				tfVoltas.requestFocus();
				tfDiametro.setText("");
			} catch(ParseException ex) {
			}
		} else {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Ciclista();
	}
}
