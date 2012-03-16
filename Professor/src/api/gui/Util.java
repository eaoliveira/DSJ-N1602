package api.gui;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

public class Util {
	public static JPanel criaPainel(String label, JComponent obj) {

		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEADING));
		p.add(new JLabel(label));
		p.add(obj);
		return p;
	}

	public static JPanel criaPainel(LayoutManager layout, JComponent... obj) {

		JPanel p = new JPanel(layout);
		for (JComponent comp : obj)
			p.add(comp);

		return p;
	}

	public static JPanel criaPainel(JButton... obj) {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
		for (JComponent comp : obj) {
			p.add(comp);
		}
		return p;
	}

	public static JButton criaBotao(String label, int key, ActionListener act) {
		JButton bt = new JButton(label);
		bt.setMnemonic(key);
		bt.addActionListener(act);
		return bt;
	}

	public static JFormattedTextField criaMascara(String s) {
		return criaMascara(s, null);
	}

	public static JFormattedTextField criaMascara(String s, String chars) {
		MaskFormatter formatter = null;

		try {
			formatter = new MaskFormatter(s);
			if(chars != null)
				formatter.setValidCharacters(chars);
		} catch(ParseException exc) {
			System.err.println("Máscara inválida: " + exc.getMessage());
			System.exit(-1);
		}

		JFormattedTextField field = 
			new JFormattedTextField(formatter);
		field.setColumns(s.length());

		return field;
	}

}
