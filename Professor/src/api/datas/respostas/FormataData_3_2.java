package api.datas.respostas;

/**
 * Crie um programa que receba uma data
 * (no formato MM/DD/AA) na linha de comando 
 * e separe essa data em dia, m�s e ano,
 * conforme abaixo:
 * 
 * Dia: 21
 * M�s: 8
 * Ano: 2006
 */

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;

import javax.swing.*;
import javax.swing.text.*;
import static api.gui.Util.*;

@SuppressWarnings("serial")
public class FormataData_3_2 extends JFrame implements ActionListener {
  private JFormattedTextField tfData = new JFormattedTextField(
    createFormatter("##/##/####"));
  private JButton btFormata = null;

  public FormataData_3_2() {
    super("Formata Data");
    JPanel temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
    temp.add(new JLabel("Informe uma data"));
    add(temp, "North");
    tfData.setColumns(8);
    add(criaPainel("Data", tfData), "Center");

    add(criaPainel(
    		(btFormata = 
    			criaBotao("Formata", KeyEvent.VK_F, this)),
      	criaBotao("Sair", KeyEvent.VK_S, this)
  			), "South");

    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    getRootPane().setDefaultButton(btFormata);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if(e.getActionCommand().equals("Formata")) {
      try {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        Date d = sdf.parse(tfData.getText());

        JOptionPane.showMessageDialog(null, String.format(
          "Dia: %1$td\nMês: %1$tm\nAno: %1$tY", d));

        tfData.setValue(null);
        tfData.requestFocus();
      } catch(ParseException ex) {
        JOptionPane.showMessageDialog(null, "Data inválida!");
        tfData.requestFocus();
      }
    } else {
      System.exit(0);
    }
  }

  public MaskFormatter createFormatter(String s) {
    /*
    Character   Description
      #         Any valid number, uses Character.isDigit.
      '         Escape character, used to escape any of the special formatting characters.
      U         Any character (Character.isLetter). All lowercase letters are mapped to upper case.
      L         Any character (Character.isLetter). All upper case letters are mapped to lower case.
      A         Any character or number (Character.isLetter or Character.isDigit)
      ?         Any character (Character.isLetter).
      *         Anything.
      H         Any hex character (0-9, a-f or A-F).
    */
    MaskFormatter formatter = null;

    try {
      formatter = new MaskFormatter(s);
    } catch(ParseException exc) {
      System.err.println("formatter is bad: " + exc.getMessage());
      System.exit(-1);
    }
    return formatter;
  }

  public static void main(String[] args) {
    new FormataData_3_2();
  }

}
