package api.datas;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import static api.gui.Util.*;

@SuppressWarnings("serial")
public class Viveu_2_1 extends JFrame {
  /**
   * Crie um programa que mostre na tela os dias
   * que uma pessoa viveu. Para isso, o programa
   * deve receber a data de nascimento da pessoa.
   * Para calcular a diferença de datas é recomendado
   * transformar as datas em milissegundos. A partir
   * do valor resultante em milissegundos poderemos
   * converter para dias com a férmula:
   * 
   * milissegundos / 1000 / 60 / 60 / 24 = número de dias
   */

  private JFormattedTextField tfData = 
    new JFormattedTextField(
    		createFormatter("##/##/####"));

  public Viveu_2_1() {
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
          // Define o tipo de formato para 
          // validar a data a ser informada
          // pelo usuário
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          sdf.setLenient(false);

          // Valida a data
          Date d = sdf.parse(tfData.getText());
          
          // Calcula o nº de dias entre a data informada e
          // hoje
          long dias = (Calendar.getInstance().getTimeInMillis() - 
              d.getTime()) / 1000 / 60 / 60 / 24;
          
          // Mostra o resultado
          JOptionPane.showMessageDialog(null, "Você já viveu " + dias + " dias", 
            "R E S U L T A D O", JOptionPane.INFORMATION_MESSAGE);
          tfData.setText(null);
        } catch(ParseException ex) {
          JOptionPane.showMessageDialog(null, "Data inválida", "E R R O",
            JOptionPane.ERROR_MESSAGE);
          tfData.setText(null);
        }
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
  
  public static MaskFormatter createFormatter(String s) {
/*
Character   Description
  #         Qualquer número valido, usa Character.isDigit.
  '           Permite a utilização de qualquer caractere de formatação que está nesta lista
  U         Qualquer charactere (Character.isLetter). Todas as letras minúsculas  são mapeadas para Maiúculas.
  L         Qualquer charactere (Character.isLetter). Todas as letras Maiúculas  são mapeadas para minúsculas.
  A         Qualquer charactere ou numero (Character.isLetter ou Character.isDigit)
  ?         Qualquer charactere (Character.isLetter).
  *         Qualquer coisa.
  H         Qualquer charactere hexadecimal (0-9, a-f or A-F).
*/
    MaskFormatter formatter = null;

    try {
      formatter = new MaskFormatter(s);
    } catch (ParseException exc) {
      System.err.println("formatter is bad: " + exc.getMessage());
      System.exit(-1);
    }
    return formatter;
  }

  public static void main(String[] args) {
    new Viveu_2_1();
  }

}


