package abstractDemo2.gui;

import java.io.*;
import java.util.Properties;
import java.awt.event.*;
import javax.swing.*;

public class ActionListenerLaf implements ActionListener {
  private JFrame frame = null;

  public ActionListenerLaf(JFrame f) {
    this.frame = f;
  }

  public void actionPerformed(ActionEvent e) {
    String cmd = e.getActionCommand();
    if(cmd.equals("def") || cmd.equals("ski") || cmd.equals("nap")
      || cmd.equals("sub")) {
      try {
        File f = new File("bin/abstractDemo2/resources/figuras.properties");
        Properties prop = new Properties();
        prop.load(new FileInputStream(f));
        prop.setProperty("laf", cmd + "Laf");
        prop.store(new FileOutputStream(f), "LaF configuration");
        
        /*
        RandomAccessFile file = new RandomAccessFile(
          "abstractDemo2/resources/figuras.properties", "rw");

        String line = null;
        long ptr = file.getFilePointer();

        while((line = file.readLine()) != null) {
          if(line.startsWith("laf=")) {
            file.seek(ptr);
            file.writeBytes("laf=" + cmd + "Laf\n");
            break;
          }
          ptr = file.getFilePointer();
        }

        file.close();
        */
        JOptionPane
          .showMessageDialog(
            frame,
            "Para que as configurações sejam ativadas\nserá necessário reiniciar o programa",
            "A T E N Ç Ã O", JOptionPane.INFORMATION_MESSAGE);
      }
      catch(IOException ex) {
        JOptionPane.showMessageDialog(frame,
          "Problemas na configuração do Look & Feel\n" + ex.getMessage(),
          "E R R O", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}
