package Thread.resposta.swing;

import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

class Contador {
	protected JProgressBar pg = null;
	protected int value = 0;
	protected int interval = 5;
	private String nome = "Contador";
	private boolean parar = false;
	
	public Contador(String nome, int value) {
		pg = new JProgressBar(0, value);
		setValue(value);
		setNome(nome);
	}

	public Contador(String nome, int value, int interval) {
		pg = new JProgressBar(0, value);
		setValue(value);
		setNome(nome);
		setInterval(interval);
	}
	
	public boolean isParar() {
		return parar;
	}

	public void setParar(boolean parar) {
		this.parar = parar;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public JPanel getBar() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 2, 2));
		panel.setBorder(BorderFactory.createEmptyBorder(5, 3, 5, 3));
		panel.add(new JLabel(nome));
		panel.add(pg);
		pg.setStringPainted(true);

		return panel;
	}

	public void run() {
		try {
			for (int i = 1; i <= value;) {
				Thread.sleep(interval);
				pg.setValue(i++);
			}
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
