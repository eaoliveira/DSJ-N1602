package api.datas.respostas;

import java.text.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static api.gui.Util.*;

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
 * 
 * Sugestão de Tela:
 * 
 * 
 */

@SuppressWarnings("serial")
public class Viveu_2 extends JFrame implements ActionListener {
  private JFormattedTextField tfData = criaMascara("##/##/####");
  private JButton btCalcula = criaBotao("Calcula", KeyEvent.VK_C, this);
  private JButton btSair = criaBotao("Sair", KeyEvent.VK_S, this);
  private boolean dataOk = false;
  
  public Viveu_2() {
    setTitle("Dias de Vida");

    Calendar agora = Calendar.getInstance();
    tfData.setText(String.format("%1$td/%1$tm/%1$tY", agora.getTime()));
    tfData.setCaretPosition(0);
    tfData.setSelectionEnd(99);
    tfData.addKeyListener(new KeyAdapter() {
      public void  keyPressed(KeyEvent ev) {
        if(!dataOk) {
          dataOk = true;
          tfData.setText("");
        }
      }
    });

    add(criaPainel("Data de Nascimento", tfData), BorderLayout.CENTER);
    add(criaPainel(btCalcula, btSair), BorderLayout.SOUTH);
    
    pack();
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getRootPane().setDefaultButton(btCalcula);
    setResizable(false);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent ev) {
    if(ev.getSource() == btCalcula) {
      // Define o tipo de formato para 
      // validar a data a ser informada
      // pelo usuário
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      sdf.setLenient(false);

      // Fica dentro do loop enquando a data 
      // informada seja inválida
      try {
        // Valida a data
        Date d = sdf.parse(tfData.getText());
        
        // Verifica de o ano informado é menor que 1900
        // e se a data informada é maior que Hoje
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        int ano = cal.get(Calendar.YEAR);
        Calendar hoje = Calendar.getInstance();
        
        if(ano < 1900 || cal.compareTo(hoje) > 0)
          throw new ParseException("Data Inválida!", 0);
        
        // Calcula o nº de dias entre a data informada e
        // hoje
        long dias = (hoje.getTimeInMillis() - 
            d.getTime()) / 1000 / 60 / 60 / 24;
        
        // Mostra o resultado
        JOptionPane.showMessageDialog(null, 
          cal.get(Calendar.YEAR) +
          "\nVocê já viveu " + dias + " dias");

        // Limpa o Campo na Tela
        tfData.setValue(null);
        
        // Mostra mensagem, pois a data é inválida
      } catch(ParseException ex) {
        JOptionPane.showMessageDialog(null, "Data inválida!");
        dataOk = false;
      }

      // Posiciona o Cursor no campo Data
      tfData.requestFocus();
    } else {
      System.exit(0);
    }
  }
  
  public static void main(String[] args) {
    new Viveu_2();
  }
}
