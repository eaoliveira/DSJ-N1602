package Xml.hobby;

import static javafx.concurrent.Worker.State.FAILED;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

@SuppressWarnings("serial")
public class FrameTransform extends JFrame implements ActionListener {
	private final JFXPanel jfxPanel = new JFXPanel();
	private WebEngine engine;

	private final JPanel panel = new JPanel(new BorderLayout());
	private final JLabel lblStatus = new JLabel();

	private final JProgressBar progressBar = new JProgressBar();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnXML = new JMenu("XML");
	private final JMenuItem mntmAbrir = new JMenuItem("Abrir");
	private final JSeparator separator = new JSeparator();
	private final JMenuItem mntmSair = new JMenuItem("Sair");
	private final JMenuItem mntmConfiguraEstilo = new JMenuItem("Configura Estilo");
	private String estilo;

	public FrameTransform() {
		super();

		setJMenuBar(menuBar);

		menuBar.add(mnXML);
		mntmAbrir.addActionListener(this);

		mnXML.add(mntmAbrir);
		mntmConfiguraEstilo.addActionListener(this);

		mnXML.add(mntmConfiguraEstilo);

		mnXML.add(separator);
		mntmSair.addActionListener(this);

		mnXML.add(mntmSair);
		initComponents();
	}

	private void initComponents() {
		createScene();

		progressBar.setPreferredSize(new Dimension(150, 18));
		progressBar.setStringPainted(true);

		JPanel statusBar = new JPanel(new BorderLayout(5, 0));
		statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
		statusBar.add(lblStatus, BorderLayout.CENTER);
		statusBar.add(progressBar, BorderLayout.EAST);

		panel.add(jfxPanel, BorderLayout.CENTER);
		panel.add(statusBar, BorderLayout.SOUTH);

		getContentPane().add(panel);

		setPreferredSize(new Dimension(1024, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	private void createScene() {
		Platform.runLater(() -> {
			WebView view = new WebView();
			engine = view.getEngine();

			engine.titleProperty().addListener((o, old, value) -> {
				SwingUtilities.invokeLater(() -> FrameTransform.this.setTitle(value));
			});

			engine.setOnStatusChanged((event) -> {
				SwingUtilities.invokeLater(() -> lblStatus.setText(event.getData()));
			});

			engine.getLoadWorker().workDoneProperty().addListener((o, old, value) -> {
				SwingUtilities.invokeLater(() -> progressBar.setValue(value.intValue()));
			});

			engine.getLoadWorker().exceptionProperty().addListener((o, old, value) -> {
				if (engine.getLoadWorker().getState() == FAILED)
					SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(panel,
							(value != null) ? engine.getLocation() + "\n" + value.getMessage()
									: engine.getLocation() + "\nUnexpected error.",
							"Loading error...", JOptionPane.ERROR_MESSAGE));
			});

			jfxPanel.setScene(new Scene(view));
		});
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
					Pessoas pessoas = (Pessoas) u.unmarshal(new File(arquivo));

					if (estilo == null) {
						configuraEstilo();
					} else {
						// Declara um Buffer para receber o HTML gerado
						ByteArrayOutputStream out = new ByteArrayOutputStream();

						// Lê Objeto Java e gera XML e aplica o estilo para transformar em HTML
						TransformerFactory factory = TransformerFactory.newInstance();
						Transformer t = factory.newTransformer(new StreamSource(new File(estilo)));
						t.transform(new JAXBSource(ctx, pessoas), new StreamResult(out));
						
						// Carrega o HTML
						Platform.runLater(() -> engine.loadContent(out.toString(), "text/html"));
					}
				}
			} catch (JAXBException ex) {
				JOptionPane.showMessageDialog(this, "XML Incompatível ou falha la leitura do arquivo XML");
			} catch (TransformerConfigurationException ex) {
				JOptionPane.showMessageDialog(this, "Problemas na configuração do Estilo");
			} catch (TransformerException ex) {
				JOptionPane.showMessageDialog(this, "Problemas na aplicação do Estilo");
			}
		} else if(menu.equals(mntmConfiguraEstilo)) {
			configuraEstilo();
		} else {
			System.exit(0);
		}
	}

	private void configuraEstilo() {
		// Solicita o nome do arquivo de estilo
		estilo = selectFile("Selecione o Estilo a ser aplicado no XML", "*.xsl", FileDialog.LOAD);
	}

	private String selectFile(String title, String ext, int mode) {
		FileDialog fd = new FileDialog((JDialog) null, title, mode);
		fd.setFile(ext);
		fd.setVisible(true);
		String arquivo = fd.getDirectory() + fd.getFile();
		return arquivo;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			FrameTransform browser = new FrameTransform();
			browser.setLocationRelativeTo(null);
			browser.setVisible(true);
		});
	}
}