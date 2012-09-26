package api.fileio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class TelaComMenu extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenu mnAjuda;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmFechar;
	private JSeparator separator;
	private JMenuItem mntmSair;
	private JMenuItem mntmSocorro;
	private JMenuItem mntmVerso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComMenu frame = new TelaComMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaComMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnArquivo());
			menuBar.add(getMnAjuda());
		}
		return menuBar;
	}
	private JMenu getMnArquivo() {
		if (mnArquivo == null) {
			mnArquivo = new JMenu("Arquivo");
			mnArquivo.add(getMntmAbrir());
			mnArquivo.add(getMntmFechar());
			mnArquivo.add(getSeparator());
			mnArquivo.add(getMntmSair());
		}
		return mnArquivo;
	}
	private JMenu getMnAjuda() {
		if (mnAjuda == null) {
			mnAjuda = new JMenu("Ajuda");
			mnAjuda.add(getMntmSocorro());
			mnAjuda.add(getMntmVerso());
		}
		return mnAjuda;
	}
	private JMenuItem getMntmAbrir() {
		if (mntmAbrir == null) {
			mntmAbrir = new JMenuItem("Abrir");
		}
		return mntmAbrir;
	}
	private JMenuItem getMntmFechar() {
		if (mntmFechar == null) {
			mntmFechar = new JMenuItem("Fechar");
		}
		return mntmFechar;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmSair() {
		if (mntmSair == null) {
			mntmSair = new JMenuItem("Sair");
			mntmSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return mntmSair;
	}
	private JMenuItem getMntmSocorro() {
		if (mntmSocorro == null) {
			mntmSocorro = new JMenuItem("Socorro");
		}
		return mntmSocorro;
	}
	private JMenuItem getMntmVerso() {
		if (mntmVerso == null) {
			mntmVerso = new JMenuItem("Versão");
		}
		return mntmVerso;
	}
}
