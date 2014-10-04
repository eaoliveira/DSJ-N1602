package Rede.abs.base;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Rede.abs.util.Maker;
import Rede.abs.util.MenuDefs;

@SuppressWarnings("serial")
public abstract class AbstractClient extends JFrame implements ActionListener, Runnable {
  protected JTextArea ta = new JTextArea(10, 30);
  private JButton btEnviar = new JButton("Enviar");
  private JPanel pInferior = new JPanel(new BorderLayout(5, 5));
  protected Socket sckt = null;
  protected Thread thrd = null;
  protected String title = "";
  boolean conectado = false;

  public AbstractClient(String title) {
    this.title = title;

    setLayout(new BorderLayout());
    JPanel p1 = new JPanel(new GridLayout(1,1));
    p1.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    ta.setEditable(false);
    JScrollPane sp = new JScrollPane(ta);
    sp.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e){
        ta.setCaretPosition(ta.getText().length());
      }
    });
    p1.add(sp);
    add(p1, BorderLayout.CENTER);

    JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
    p2.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
    btEnviar.setEnabled(false);
    btEnviar.addActionListener(this);
    getRootPane().setDefaultButton(btEnviar);
    p2.add(btEnviar);
    pInferior.add(p2, BorderLayout.SOUTH);
    add(pInferior, BorderLayout.SOUTH);

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(Maker
      .makeMenu(new MenuDefs("Ações", KeyEvent.VK_A),
        new MenuDefs[] {
          new MenuDefs("Conectar", KeyEvent.VK_C, new ImageIcon(
        		  Maker.class.getResource("Recursos/Hardware30.gif"))),
          new MenuDefs("Desconectar", KeyEvent.VK_D, new ImageIcon(
        		  Maker.class.getResource("Recursos/Symbols9.gif"))), new MenuDefs(),
          new MenuDefs("Sair", KeyEvent.VK_S, new ImageIcon(
        		  Maker.class.getResource("Recursos/exit0d.gif")))
        }, this));
    setJMenuBar(menuBar);

    setIconImage(new ImageIcon("Faces21.gif").getImage());
    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  protected void add(JPanel p) {
    pInferior.add(p, BorderLayout.CENTER);
  }
  
  public abstract void run();

  protected abstract void inicializaSocket(String servidor, int porta)
      throws UnknownHostException, IOException;

  protected abstract void gravaDados() throws IOException;

  public void actionPerformed(ActionEvent e) {
    try {
      if(e.getSource() == btEnviar) {
        gravaDados();
      } else if(e.getActionCommand().equals("Conectar") && !conectado) {
        TelaConectar tela = new TelaConectar(this);
        
        if(tela.servidor != null) {
          inicializaSocket(tela.servidor, Integer.parseInt(tela.porta));
          (thrd = new Thread(this)).start();
          setTitle(title + ": " + tela.servidor + ":" + tela.porta);
          btEnviar.setEnabled(true);
          conectado = true;
        }
      } else if(e.getActionCommand().equals("Desconectar") && conectado) {
        thrd.interrupt();
        sckt.close();
        setTitle(title);
        btEnviar.setEnabled(false);
        ta.append(title + ": Desconectado\n");
        conectado = false;
      } else if(e.getActionCommand().equals("Sair")) {
        if(sckt != null) sckt.close();

        setVisible(false);
        System.exit(0);
      }
    } catch(IOException ex) {
      JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
    }
  }

  class TelaConectar extends JDialog {
    String servidor = null;
    String porta = null;
    JTextField tfServidor = new JTextField(20);
    JTextField tfPorta = new JTextField(4);

    public TelaConectar(Container parente) {
      setTitle("Conectar");
      setLayout(new BorderLayout());
      Container painel = getContentPane();

      JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
      p1.add(new JLabel("Servidor"));
      p1.add(tfServidor);
      p1.add(new JLabel("Porta"));
      p1.add(tfPorta);
      painel.add(p1, BorderLayout.CENTER);

      JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
      JButton btOk = new JButton("Ok");
      getRootPane().setDefaultButton(btOk);
      btOk.setMnemonic(KeyEvent.VK_ENTER);
      btOk.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          servidor = tfServidor.getText();
          porta = tfPorta.getText();
          setVisible(false);
        }
      });
      p2.add(btOk);
      JButton btCancela = new JButton("Cancela");
      btCancela.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
          setVisible(false);
        }
      });
      p2.add(btCancela);
      painel.add(p2, BorderLayout.SOUTH);

      setModal(true);
      pack();
      setLocationRelativeTo(parente);
      setVisible(true);
      tfServidor.requestFocus();
    }
  }
}
