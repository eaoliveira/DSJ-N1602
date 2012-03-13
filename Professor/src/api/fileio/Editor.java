package api.fileio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
public class Editor extends JFrame implements ActionListener {
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu mnArquivo;
	private JMenuItem mntmAbrir;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmFechar;
	private JMenuItem mntmSair;
	private JSeparator separator;
	private JMenu mnInformaes;
	private JMenuItem mntmVerso;
	private JMenuItem mntmNovo;
	private File nomeArquivo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editor frame = new Editor();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Editor() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
		contentPane.add(getMenuBar_1(), BorderLayout.NORTH);
	}
	
	private JScrollPane getScrollPane() {
		if(scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	
	private JTextArea getTextArea() {
		if(textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
		}
		return textArea;
	}
	
	private JMenuBar getMenuBar_1() {
		if(menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnArquivo());
			menuBar.add(getMnInformaes());
		}
		return menuBar;
	}
	
	private JMenu getMnArquivo() {
		if(mnArquivo == null) {
			mnArquivo = new JMenu("Arquivo");
			mnArquivo.setMnemonic('a');
			mnArquivo.add(getMntmNovo());
			mnArquivo.add(getMntmAbrir());
			mnArquivo.add(getMntmSalvar());
			mnArquivo.add(getMntmFechar());
			mnArquivo.add(getSeparator());
			mnArquivo.add(getMntmSair());
		}
		return mnArquivo;
	}
	
	private JMenuItem getMntmNovo() {
		if(mntmNovo == null) {
			mntmNovo = new JMenuItem("Novo");
			mntmNovo.addActionListener(this);
		}
		return mntmNovo;
	}
	
	private JMenuItem getMntmAbrir() {
		if(mntmAbrir == null) {
			mntmAbrir = new JMenuItem("Abrir");
			mntmAbrir.addActionListener(this);
		}
		return mntmAbrir;
	}
	
	private JMenuItem getMntmSalvar() {
		if(mntmSalvar == null) {
			mntmSalvar = new JMenuItem("Salvar");
			mntmSalvar.addActionListener(this);
			mntmSalvar.setEnabled(false);
		}
		return mntmSalvar;
	}
	
	private JMenuItem getMntmFechar() {
		if(mntmFechar == null) {
			mntmFechar = new JMenuItem("Fechar");
			mntmFechar.addActionListener(this);
			mntmFechar.setEnabled(false);
		}
		return mntmFechar;
	}
	
	private JMenuItem getMntmSair() {
		if(mntmSair == null) {
			mntmSair = new JMenuItem("Sair");
			mntmSair.addActionListener(this);
		}
		return mntmSair;
	}
	
	private JSeparator getSeparator() {
		if(separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	
	private JMenu getMnInformaes() {
		if(mnInformaes == null) {
			mnInformaes = new JMenu("Informações");
			mnInformaes.setMnemonic('i');
			mnInformaes.add(getMntmVerso());
		}
		return mnInformaes;
	}
	
	private JMenuItem getMntmVerso() {
		if(mntmVerso == null) {
			mntmVerso = new JMenuItem("Versão");
			mntmVerso.addActionListener(this);
		}
		return mntmVerso;
	}
	
	public void actionPerformed(ActionEvent ev) {
		String cmd = ev.getActionCommand();
		
		if(cmd.equals("Novo")) {
			getTextArea().setText("");
			setMenuEdit(true);
		} else if(cmd.equals("Abrir")) {
			FileDialog fd = new FileDialog(this, "Selecione um arquivo", FileDialog.LOAD);
			fd.setLocationRelativeTo(this);
			fd.setFile("*.txt");
			fd.setVisible(true);
			
			String nome = fd.getFile();
			
			if(nome != null) {
				try {
					setNomeArquivo(new File(fd.getDirectory() + nome));
					BufferedReader in = new BufferedReader(new FileReader(getNomeArquivo()));
					
					getTextArea().setText("");
					
					for(String linha; (linha = in.readLine()) != null;)
						getTextArea().append(linha + "\n");
					
					in.close();
					getTextArea().setCaretPosition(0);
					setMenuEdit(true);
				} catch(IOException e) {
					JOptionPane.showMessageDialog(this, "Erro na leitura do arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if(cmd.equals("Salvar")) {
			FileDialog fd = new FileDialog(this, "Selecione o nome do arquivo", FileDialog.SAVE);
			
			if(getNomeArquivo() != null) {
				fd.setDirectory(getNomeArquivo().getParent());
				fd.setFile(getNomeArquivo().getName());
			}
			
			fd.setLocationRelativeTo(this);
			fd.setVisible(true);
			
			String nome = fd.getFile();
			
			if(nome != null) {
				try {
					PrintWriter out = new PrintWriter(fd.getDirectory() + nome);
					
					out.println(getTextArea().getText());
					out.close();
					
					getTextArea().setText("");
					setMenuEdit(false);
					setNomeArquivo(null);
				} catch(IOException e) {
					JOptionPane.showMessageDialog(this, "Erro na leitura do arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if(cmd.equals("Fechar")) {
			int resp = JOptionPane.showConfirmDialog(this, "Confirma fechar o arquivo\nas alterações serão descartadas!",
					"Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(resp == 0) {
				getTextArea().setText("");
				setMenuEdit(false);
				setNomeArquivo(null);
			}
		} else if(cmd.equals("Versão")) {
			JOptionPane
					.showMessageDialog(this, "Editor 1/2 Boca\nVersão 0.1", "Informações", JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.exit(0);
		}
	}
	
	public File getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(File nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public void setMenuEdit(boolean val) {
		getMntmNovo().setEnabled(!val);
		getMntmAbrir().setEnabled(!val);
		getMntmSalvar().setEnabled(val);
		getMntmFechar().setEnabled(val);
		getMntmSair().setEnabled(!val);
		getTextArea().setEditable(val);
	}
}
