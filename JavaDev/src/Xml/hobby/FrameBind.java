package Xml.hobby;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

@SuppressWarnings("serial")
public class FrameBind extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnXml;
	private JMenuItem mntmAbrir;
	private JSeparator separator;
	private JMenuItem mntmSair;
	private JTabbedPane tabbedPane;
	private JPanel panelTabela;
	private JPanel panelXML;
	private JScrollPane scrollPane1;
	private JTable table;
	private JScrollPane scrollPane2;
	private JTextArea textArea;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameBind frame = new FrameBind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrameBind() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnXml = new JMenu("XML");
		menuBar.add(mnXml);

		mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(this);
		mnXml.add(mntmAbrir);

		separator = new JSeparator();
		mnXml.add(separator);

		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(this);
		mnXml.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		panelTabela = new JPanel();
		tabbedPane.addTab("Tabela", null, panelTabela, null);
		panelTabela.setLayout(new BorderLayout(0, 0));

		scrollPane1 = new JScrollPane();
		panelTabela.add(scrollPane1, BorderLayout.CENTER);

		table = new JTable();
		scrollPane1.setViewportView(table);

		panelXML = new JPanel();
		tabbedPane.addTab("XML", null, panelXML, null);
		panelXML.setLayout(new BorderLayout(0, 0));

		scrollPane2 = new JScrollPane();
		panelXML.add(scrollPane2, BorderLayout.CENTER);

		textArea = new JTextArea();
		scrollPane2.setViewportView(textArea);
	}

	public void actionPerformed(ActionEvent ev) {
		Object menu = ev.getSource();

		if (menu.equals(mntmAbrir)) {
			try {
				// Solicita o nome do arquivo
				String arquivo = selectFile("Abrir", "*.xml", FileDialog.LOAD);

				if (arquivo != null) {
					// Configuração da classe para a leitura/gravação de XML
					JAXBContext ctx = JAXBContext.newInstance(Pessoas.class);

					// Lê XML e grama Objetos Java
					Unmarshaller u = ctx.createUnmarshaller();
					Pessoas pessoas = (Pessoas)u.unmarshal(new File(arquivo));

					// Carrega os dados na Tabela
					table.setModel(new HobbyModel(pessoas));
					
					// Declara um Buffer para receber o XML gerado
					ByteArrayOutputStream out = new ByteArrayOutputStream();

					// Lê Objeto Java e Grava XML
					Marshaller m = ctx.createMarshaller();
					m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					m.marshal(pessoas, out);

					// Carrega o XML no TextArea
					textArea.setText(out.toString());
				}
			} catch (JAXBException ex) {
				JOptionPane.showMessageDialog(this, "XML Incompatível ou falha la leitura do arquivo XML");
			}
		} else {
			System.exit(0);
		}
	}

	private String selectFile(String title, String ext, int mode) {
		FileDialog fd = new FileDialog((JDialog) null, title, mode);
		fd.setFile(ext);
		fd.setVisible(true);
		String arquivo = fd.getDirectory() + fd.getFile();
		return arquivo;
	}

	class HobbyModel extends AbstractTableModel {
		private String[] col = { "Nome", "Idade", "Hobby" };
		private Pessoas dados;
		
		public HobbyModel(Pessoas dados) {
			this.dados = dados;
		}
		
		@Override
		public int getRowCount() {
			return dados.getPessoa().size();
		}

		@Override
		public int getColumnCount() {
			return col.length;
		}

		@Override
		public String getColumnName(int num) {
			return col[num];
		}

		@Override
		public Object getValueAt(int lin, int col) {
			Pessoa obj = dados.getPessoa().get(lin);
			Object valor = null;
			
			if(col == 0) 
				valor = obj.getNome().getPrenome() + " " + obj.getNome().getSobrenome();
			else if(col == 1)
				valor = obj.getIdade();
			else if(col == 2)
				valor = obj.getHobby();

			return valor;
		}		
	}
}
