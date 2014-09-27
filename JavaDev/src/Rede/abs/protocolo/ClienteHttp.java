package Rede.abs.protocolo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.Charset;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class ClienteHttp extends JFrame {
  private JTextArea ta = new JTextArea(10, 20);
  private JButton btConnect = new JButton("Desconectar");
  private JButton btFechar = new JButton("Fechar");
  private JTextField tfSite = new JTextField(20);
  private JTextField tfPorta = new JTextField(3);
  private JTextField tfComando = new JTextField(20);
  private Connect con = null;

  public ClienteHttp() {
	JPanel layout = new JPanel(new BorderLayout());
	layout.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	setContentPane(layout);
	
    ta.setText("");
    ta.setEditable(false);
    add(new JScrollPane(ta), BorderLayout.CENTER);

    JPanel botoes = new JPanel(new GridLayout(2, 1));
    JPanel p0 = new JPanel(new FlowLayout(5, 5, FlowLayout.LEFT));
    p0.add(new JLabel("Comando"));
    tfComando.setEnabled(false);
    tfComando.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        try {
          if(con.write(tfComando.getText()))
            tfComando.setText("");
          else
            Toolkit.getDefaultToolkit().beep();
        } catch(IOException ex) {
          ta.append("\nErro: " + ex.getMessage() + "\n");
          repaint();
        }
      }
    });
    p0.add(tfComando);
    botoes.add(p0);

    JPanel p1 = new JPanel(new FlowLayout(5, 5, FlowLayout.LEFT));
    p1.add(new JLabel("Site"));
    p1.add(tfSite);
    p1.add(new JLabel("porta"));
    p1.add(tfPorta);
    btConnect.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String site = tfSite.getText();
        String porta = tfPorta.getText();

        if(con != null) 
          desconectar();
        else if(site.equals("") || porta.equals("")) {
          ta.append("Favor informar o Site e a porta\n");
          repaint();
        } else 
          conectar(site, Integer.parseInt(porta));
      }
    });
    p1.add(btConnect);
    btFechar.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setVisible(false);
        System.exit(0);
      }
    });
    p1.add(btFechar);
    botoes.add(p1);
    add(botoes, BorderLayout.SOUTH);

    setTitle("Socket Test");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    getRootPane().setDefaultButton(btConnect);
    setVisible(true);
    tfSite.requestFocus();
    btConnect.setText("Conectar");
  }

  private void desconectar() {
    con.disconnect();
    con = null;
    
    btConnect.setText("Conectar");
    tfSite.setEnabled(true);
    tfPorta.setEnabled(true);
    tfComando.setEnabled(false);
    tfComando.setText("");
    tfPorta.setText("");
    tfSite.setText("");
    tfSite.requestFocus();
  }
  
  private void conectar(String site, int porta) {
    ta.append("Conectando...\n");
    repaint();

    con = new Connect(site, porta, ta);
    new Thread(con).start();
    
    btConnect.setText("Desconectar");
    tfSite.setEnabled(false);
    tfPorta.setEnabled(false);
    tfComando.setEnabled(true);
    tfComando.requestFocus();
  }

  class Connect implements Runnable {
    private String site = "";
    private int porta = 0;
    private JTextArea ta = null;
    private String comando = "";
    private boolean toDisconnect = false;

    public Connect(String site, int porta, JTextArea cp) {
      this.site = site;
      this.porta = porta;
      this.ta = cp;
    }

    private boolean hasCommand() {
      return !comando.equals("");
    }

    public void disconnect() {
      toDisconnect = true;
    }
    
    private boolean cmdDisconnect() {
      return toDisconnect;
    }
    
    public boolean write(String buff) throws IOException {
      if(!hasCommand()) {
        comando = buff;
        return true;
      } else
        return false;
    }

    public void run() {
      try {
        Socket sckt = new Socket(site, porta);
        BufferedReader in = new BufferedReader(new InputStreamReader(sckt.getInputStream()));
       // DataOutputStream out = new DataOutputStream(new BufferedOutputStream(sckt.getOutputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(sckt.getOutputStream()));
        
        ta.setText(sckt.toString() + "\n");

        while(!cmdDisconnect()) {
          while(in.ready()) {
            ta.append(new String(in.readLine().getBytes(Charset.forName("ISO-8859-1"))) + "\n");
            repaint();
          }

          if(hasCommand()) {
            out.println(comando + " HTTP/1.1\n");
            out.flush();
            comando = "";
          }
          
          Thread.sleep(5);
        }
        
        sckt.close();
      } catch(Exception ex) {
        ta.setText("Erro durante a conexão: " + ex.getMessage());
        desconectar();
      }
    }
  }

  public static void main(String[] args) {
    new ClienteHttp();
  }
}
