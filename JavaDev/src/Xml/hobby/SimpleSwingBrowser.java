package Xml.hobby;
 
import static javafx.concurrent.Worker.State.FAILED;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
 
@SuppressWarnings("serial")
public class SimpleSwingBrowser extends JFrame {
    private final JFXPanel jfxPanel = new JFXPanel();
    private WebEngine engine;
 
    private final JPanel panel = new JPanel(new BorderLayout());
    private final JLabel lblStatus = new JLabel();
 
    private final JButton btnGo = new JButton("Go");
    private final JTextField txtURL = new JTextField();
    private final JProgressBar progressBar = new JProgressBar();
 
    public SimpleSwingBrowser() {
        super();
        initComponents();
    }
 
    public SimpleSwingBrowser(String url) {
    	this();
    	loadURL(url);
    }
    
    private void initComponents() {
        createScene();
 
        ActionListener al = (e) -> loadURL(txtURL.getText());
 
        btnGo.addActionListener(al);
        txtURL.addActionListener(al);
 
        progressBar.setPreferredSize(new Dimension(150, 18));
        progressBar.setStringPainted(true);
 
        JPanel topBar = new JPanel(new BorderLayout(5, 0));
        topBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        topBar.add(txtURL, BorderLayout.CENTER);
        topBar.add(btnGo, BorderLayout.EAST);
 
        JPanel statusBar = new JPanel(new BorderLayout(5, 0));
        statusBar.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 5));
        statusBar.add(lblStatus, BorderLayout.CENTER);
        statusBar.add(progressBar, BorderLayout.EAST);
 
        panel.add(topBar, BorderLayout.NORTH);
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
                        SwingUtilities.invokeLater(() -> SimpleSwingBrowser.this.setTitle(value));
                });
 
                engine.setOnStatusChanged((event) -> {
                        SwingUtilities.invokeLater(() -> lblStatus.setText(event.getData()));
                });
 
                engine.locationProperty().addListener((o, old, value) -> {
                        SwingUtilities.invokeLater(() -> txtURL.setText(value));
                });
 
                engine.getLoadWorker().workDoneProperty().addListener((o, old, value) -> {
                        SwingUtilities.invokeLater(() -> progressBar.setValue(value.intValue()));
                });
 
                engine.getLoadWorker().exceptionProperty().addListener((o, old, value) -> {
                         if (engine.getLoadWorker().getState() == FAILED)
                             SwingUtilities.invokeLater(() ->
                                JOptionPane.showMessageDialog(panel,(value != null)
                                            ? engine.getLocation() + "\n" + value.getMessage()
                                            : engine.getLocation() + "\nUnexpected error.",
                                            "Loading error...",JOptionPane.ERROR_MESSAGE));
                });
 
                jfxPanel.setScene(new Scene(view));
        });
    }
 
    public void loadURL(final String url) {
        Platform.runLater(() -> {
                String tmp = toURL(url);
 
                if (tmp == null) {
                    tmp = toURL("http://" + url);
                }
 
                engine.load(tmp);
        });
    }
 
    private static String toURL(String str) {
        try {
            return new URL(str).toExternalForm();
        } catch (MalformedURLException exception) {
            return null;
        }
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                SimpleSwingBrowser browser = new SimpleSwingBrowser();
                browser.setVisible(true);
                browser.loadURL("http://oracle.com");
        });
    }
}