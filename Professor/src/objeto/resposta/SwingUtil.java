package objeto.resposta;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SwingUtil {
	public static JButton criaBotao(String label, int atalho, ActionListener act) {
		JButton bt = new JButton(label);
		bt.setMnemonic(atalho);
		bt.addActionListener(act);
		return bt;
	}

	public static JPanel criaCampo(String label, JComponent obj) {
		return criaPainel(new FlowLayout(FlowLayout.LEFT, 5, 5), new JLabel(label), obj);
	}

	public static JPanel painelBotao(JComponent ... obj) {
		return criaPainel(new FlowLayout(FlowLayout.CENTER, 15, 5), obj);
	}
	
	public static JPanel criaPainel(LayoutManager lay, JComponent ...  obj){
		JPanel panel = new JPanel();
		panel.setLayout(lay);
		for (JComponent comp : obj)
			panel.add(comp);
		
		return panel;
	}
}
