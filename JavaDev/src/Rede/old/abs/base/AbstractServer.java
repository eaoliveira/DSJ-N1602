package Rede.old.abs.base;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
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

import Rede.old.abs.util.Maker;
import Rede.old.abs.util.MenuDefs;

@SuppressWarnings("serial")
public abstract class AbstractServer extends JFrame implements ActionListener, Runnable {
  protected JTextArea ta = new JTextArea(10, 30);
  protected ServerSocket server = null;
  protected int porta = -1;
  protected Thread thrd = null;
  private String title = ""; 

  public AbstractServer(String title) {
    this.title = title;
    
    JPanel p1 = new JPanel();
    p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
    p1.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
    ta.setEditable(false);
    JScrollPane sp = new JScrollPane(ta);
    sp.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e){
        ta.setCaretPosition(ta.getText().length());
      }
    });
    p1.add(sp);
    p1.add(Box.createRigidArea(new Dimension(5, 10)));
    setContentPane(p1);
    setIconImage(new ImageIcon("Faces21.gif").getImage());

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(Maker
      .makeMenu(new MenuDefs("Ações", KeyEvent.VK_A),
        new MenuDefs[] {
          new MenuDefs("Iniciar", KeyEvent.VK_I,
            new ImageIcon(Maker.class.getResource("Recursos/Hardware30.gif"))),
          new MenuDefs("Parar", KeyEvent.VK_P, new ImageIcon(
        		  Maker.class.getResource("Recursos/Symbols9.gif"))),
          new MenuDefs(),
          new MenuDefs("Sair", KeyEvent.VK_S, new ImageIcon(
        		  Maker.class.getResource("Recursos/exit0d.gif")))
        }, this));
    setJMenuBar(menuBar);

    setTitle(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public abstract void run();

  public void actionPerformed(ActionEvent e) {
    try {
      if(e.getActionCommand().equals("Iniciar")) {
        TelaConectar tela = new TelaConectar(this);
        
        if(tela.porta != null) {
          porta = Integer.parseInt(tela.porta);
          (thrd = new Thread(this)).start();
          ta.append(title + ": Iniciado na porta " + porta + "\n");
        }
      } else if(e.getActionCommand().equals("Parar")) {
        if(thrd != null)
          thrd.interrupt();
        
        if(server != null)
           server.close();
        
        porta = -1;
        ta.append(title + ": Parado\n");
      } else if(e.getActionCommand().equals("Sair")) {
        if(server != null)
          server.close();
        
        setVisible(false);
        System.exit(0);
      }
    } catch(NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
    } catch(IOException ex) {
      JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
    }
  }

  class TelaConectar extends JDialog {
    String porta = null;
    JTextField tfPorta = new JTextField(4);

    public TelaConectar(Container parente) {
      setTitle("Configurar Char Server");
      setLayout(new BorderLayout());

      JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
      p1.setOpaque(true);
      p1.add(new JLabel("Porta"));
      p1.add(tfPorta);
      add(p1, BorderLayout.CENTER);

      JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
      p2.setOpaque(true);
      JButton btOk = new JButton("Ok");
      
      getRootPane().setDefaultButton(btOk);
      btOk.setMnemonic(KeyEvent.VK_ENTER);
      btOk.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
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
      add(p2, BorderLayout.SOUTH);

      setModal(true);
      pack();
      setLocationRelativeTo(parente);
      setVisible(true);
    }
  }
}
