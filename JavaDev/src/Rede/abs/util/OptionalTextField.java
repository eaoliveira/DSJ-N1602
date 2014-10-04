package Rede.abs.util;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OptionalTextField extends JTextField {
	private boolean optional = false;

	public boolean isOptional() {
		return optional;
	}

	public void setOptional(boolean optional) {
		this.optional = optional;
	}
}
