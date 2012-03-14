package api.datas;

import static api.gui.Util.criaPainel;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Viveu2_3 extends JFrame {
  /**
   * Crie um programa que mostre na tela os dias
   * que uma pessoa viveu. Para isso, o programa
   * deve receber a data de nascimento da pessoa.
   * Para calcular a diferença de datas é recomendado
   * transformar as datas em milissegundos. A partir
   * do valor resultante em milissegundos poderemos
   * converter para dias com a fórmula:
   * 
   * milissegundos / 1000 / 60 / 60 / 24 = número de dias
   */

  private JFormattedTextField tfData =  
    new JFormattedTextField(
    		DateFormat.getDateInstance(DateFormat.SHORT));

  public Viveu2_3() {
    super("Quanto você viveu!");
    JPanel temp = new JPanel(new GridLayout(1, 1));
    tfData.setColumns(10);
    temp.add(criaPainel("Data de Nascimento", tfData));
    add(temp, "Center");

    temp = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
    JButton btCalcula = new JButton("Calcula");
    btCalcula.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          // Valida a data
        	Date d = (Date)tfData.getValue();
          
          // Calcula o nº de dias entre a data informada e
          // hoje
          long dias = (Calendar.getInstance().getTimeInMillis() - 
              d.getTime()) / 1000 / 60 / 60 / 24;
          
          // Mostra o resultado
          JOptionPane.showMessageDialog(null, "Você jé viveu " + dias + " dias", 
            "R E S U L T A D O", JOptionPane.INFORMATION_MESSAGE);
        } catch(Exception ex) {
          JOptionPane.showMessageDialog(null, "Data inválida", "E R R O",
            JOptionPane.ERROR_MESSAGE);
        }
        tfData.setValue(null);
        tfData.requestFocus();
      }
    });
    temp.add(btCalcula);
    JButton btSair = new JButton("Sair");
    btSair.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    temp.add(btSair);
    add(temp, "South");

    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    getRootPane().setDefaultButton(btCalcula);
    setVisible(true);
  }
  
  public static void main(String[] args) {
    new Viveu2_3();
  }
}


