package api.regex.resposta;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.regex.*;
import javax.swing.*;

import static api.gui.Util.*;

@SuppressWarnings("serial")
public class ScanTest extends JFrame implements ActionListener {
     // CEP: "99999-999"
    String cep = "[0-9]{5}-[0-9]{3}";

    // FONE: "[[99 ][(99) ]][9]999-9999"
    String fone ="(\\d{2} )?(\\(\\d{1,2}\\) )?\\d{3,4}-\\d{4}";
    
    // RG: "[99]9.999.999[-X]"
    String rg = "[0-9]{1,3}(\\.[0-9]{3}){2}(-[0-9A-Z])?";

    // CPF: "[99]9.999.999-99"
    String cpf = "[0-9]{1,3}(\\.[0-9]{3}){2}-[0-9]{2}";

    // CNPJ: "[99]9.999.999/9999-90"
    String cnpj = "[0-9]{1,3}(\\.[0-9]{3}){2}/[0-9]{4}-[0-9]{2}";

    // E-mail: "[xx.]xx@xxxxx.xxxxx"
    String email = "([\\w-]{3,}\\.)?[\\w-]{3,}@[\\w-]{3,}(\\.\\w{3,}){1,3}";

    // URL: "xxxx.xxxxx.xxxxx"
    String site = "(\\w+\\.){2,}\\w+";

    private JTextField tfCep = new JTextField(9);
    private JTextField tfFone = new JTextField(18);
    private JTextField tfRg = new JTextField(13);
    private JTextField tfCpf = new JTextField(14);
    private JTextField tfCnpj = new JTextField(19);
    private JTextField tfEmail = new JTextField(25);
    private JTextField tfSite = new JTextField(25);
    private JButton btValida = criaBotao("Valida", KeyEvent.VK_V, this);
    private JButton btSair = criaBotao("Sair", KeyEvent.VK_S, this);
    
    public ScanTest() {
      setTitle("Validador");
      
      JPanel painelCentral = new JPanel();
      painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.PAGE_AXIS));
      painelCentral.add(criaPainel("CEP", tfCep));
      painelCentral.add(criaPainel("Fone", tfFone));
      painelCentral.add(criaPainel("RG", tfRg));
      painelCentral.add(criaPainel("CPF", tfCpf));
      painelCentral.add(criaPainel("CNPJ", tfCnpj));
      painelCentral.add(criaPainel("E-Mail", tfEmail));
      painelCentral.add(criaPainel("Site", tfSite));
      add(painelCentral, BorderLayout.CENTER);
      add(criaPainel(btValida, btSair), BorderLayout.SOUTH);
      
      pack();
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      getRootPane().setDefaultButton(btValida);
      setResizable(false);
      setVisible(true);
    }

    public void actionPerformed(ActionEvent ev) {
      if(ev.getSource() == btValida) {
        try {
          StringBuffer sb = new StringBuffer();
          sb.append("CEP: " + setValue(tfCep.getText(), "CEP inválido!", cep));
          sb.append("\nFONE: " + setValue(tfFone.getText(), "Fone inválido!", fone));
          sb.append("\nRG: " + setValue(tfRg.getText(), "RG inválido!", rg));
          sb.append("\nCPF: " + setValue(tfCpf.getText(), "CPF inválido!", cpf));
          sb.append("\nCNPJ: " + setValue(tfCnpj.getText(), "CNPJ inválido!", cnpj));
          sb.append("\nE-mail: " + setValue(tfEmail.getText(), "E-Mail inválido!", email));
          sb.append("\nURL: " + setValue(tfSite.getText(), "Site inválido!", site));
          JOptionPane.showMessageDialog(null, sb.toString());
        } catch(ParseException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
        }
      } else {
        System.exit(0);
      }
    }

    public String setValue(String val, String msg, String ptrn) 
       throws ParseException {
      // Remove os espaços em branco ao
      // final da string buff
      String str = val.trim();

      // Achou o padrão em (str) 
      if(!Pattern.matches(ptrn, str))
        // Não acho um único padrão em (buff) -> ERRO
        throw new ParseException(msg, 0);
    
      // Achou! -> OK
      return str;
    }

    public static void main(String[] args) {
      new ScanTest();
    }
  }
