package api.math.resposta;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Jogada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea tela = null;
	private JButton btJogar = null;

	/**
	 * This method initializes tela	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTela() {
		if(tela == null) {
			tela = new JTextArea();
			tela.setBounds(new Rectangle(73, 18, 147, 193));
			tela.setEditable(false);
			tela.setFont(new Font("Dialog", Font.ITALIC, 14));
			tela.setBackground(jContentPane.getBackground());
		}
		return tela;
	}

	/**
	 * This method initializes btJogar	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtJogar() {
		if(btJogar == null) {
			btJogar = new JButton();
			btJogar.setBounds(new Rectangle(80, 224, 71, 26));
			btJogar.setText("Jogar");
			btJogar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					geraNum();
				}
			});
		}
		return btJogar;
	}

	public void geraNum() {
		tela.setText("");
		for (int i = 0; i < 10; i++) {
			int num = (int)Math.ceil(Math.random()*6);
			tela.append(String.format("Jogada %d: %d%n", i+1, num));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Jogada thisClass = new Jogada();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public Jogada() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(237, 292);
		this.setContentPane(getJContentPane());
		this.setTitle("Jogada");
		this.setLocationRelativeTo(null);
		geraNum();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if(jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getTela(), null);
			jContentPane.add(getBtJogar(), null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="35,12"
