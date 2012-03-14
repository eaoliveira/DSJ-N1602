package api.datas;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

import static api.gui.Util.*;

/**
 * Crie um programa que receba uma data
 * (no formato MM/DD/AA) 
 * e separe essa data em dia, mês e ano,
 * conforme abaixo:
 * 
 * Dia: 21
 * Mês: 8
 * Ano: 2006

 * Sugestão de Tela:
 * 
 * +---+-----------------------------+---+---+
 * | - |  Formata Datas              | - | X |
 * +---+-----------------------------+---+---+
 * |                        +----------+     |
 * |     Informe uma Data   | DD/MM/YY |     |
 * |                        +----------+     |
 * |                                         |
 * |     +-----------+        +--------+     |
 * |     |  Formata  |        |  Sair  |     |
 * |     +-----------+        +--------+     |
 * +-----------------------------------------+
 * 
 */

@SuppressWarnings("serial")
public class FormataData_3 extends JFrame implements ActionListener {
  private JTextField tfData = criaMascara("##/##/##");
  private JButton btFormata = criaBotao("Formata", KeyEvent.VK_F, this); 
  private JButton btSair = criaBotao("Sair", KeyEvent.VK_S, this); 
  
  public FormataData_3() {
    setTitle("Formata Datas");

    add(criaPainel("Informe uma Data", tfData), 
    		BorderLayout.CENTER);
    add(criaPainel(btFormata, btSair), 
    		BorderLayout.SOUTH);
    
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getRootPane().setDefaultButton(btFormata);
    setResizable(false);
    setVisible(true);
  }
  
  public void actionPerformed(ActionEvent ev) {
    if(ev.getSource() == btFormata) {
      // Define o tipo de formato para 
      // validar a data a ser informada
      // pelo usuário
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
      sdf.setLenient(false);

      // Fica dentro do loop enquando a data 
      // informada seja inválida
      try {
        // Valida a data
        Date d = sdf.parse(tfData.getText());
        
        // Formata e mostra a data
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        
        JOptionPane.showMessageDialog(null, 
          "Dia: " + cal.get(Calendar.DAY_OF_MONTH) + "\n" +
          "Mês: " + (cal.get(Calendar.MONTH) + 1) + "\n" +
          "Ano: " + cal.get(Calendar.YEAR));
        
        // Limpa o campo Data
        tfData.setText("");
        
        // Mostra mensagem, pois a data é inválida
      } catch(ParseException ex) {
        JOptionPane.showMessageDialog(null, "Data inválida!");
      }
      
      // Posiciona o cursor no campo Data
      tfData.requestFocus();
    } else {
      System.exit(0);
    }
  }
  
  public static void main(String[] args) {
    new FormataData_3();
  }
}
