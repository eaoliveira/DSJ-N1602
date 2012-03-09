package api.fileio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TesteMenu extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu mnTeste;
	private JMenuItem mntmItem;
	private JMenuItem mntmItem_1;
	private JSeparator separator;
	private JMenuItem mntmItemsalvar;
	private File arquivo;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteMenu frame = new TesteMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TesteMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}

	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnTeste());
		}
		return menuBar;
	}

	public JMenu getMnTeste() {
		if (mnTeste == null) {
			mnTeste = new JMenu("Teste");
			mnTeste.add(getMntmItem());
			mnTeste.add(getMntmItemsalvar());
			mnTeste.add(getSeparator());
			mnTeste.add(getMntmItem_1());
		}
		return mnTeste;
	}

	public JMenuItem getMntmItem() {
		if (mntmItem == null) {
			mntmItem = new JMenuItem("Item1");
			mntmItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						JFileChooser cho = new JFileChooser();
						cho.showOpenDialog(null);
						arquivo = cho.getSelectedFile();
						
						FileReader fi = new FileReader(arquivo);
						BufferedReader in = new BufferedReader(fi);
						
						String linha = in.readLine();
						textArea.setText("");
						while (linha != null) {
							textArea.append(linha + "\n");
							linha = in.readLine();
						}
						textArea.setEditable(true);
					} catch (FileNotFoundException ex) {
						JOptionPane.showMessageDialog(null, "Arquivo não encontrado");
					} catch (IOException ex) {
						JOptionPane.showMessageDialog(null, "Problemas na leitura do arquivo");
					}
				}
			});
		}
		return mntmItem;
	}

	public JMenuItem getMntmItem_1() {
		if (mntmItem_1 == null) {
			mntmItem_1 = new JMenuItem("Item2");
			mntmItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return mntmItem_1;
	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}

	public JMenuItem getMntmItemsalvar() {
		if (mntmItemsalvar == null) {
			mntmItemsalvar = new JMenuItem("itemSalvar");
		}
		return mntmItemsalvar;
	}
}
