package api.datas.respostas;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

public class VerificaData_4 {
  public static void main(String[] args) {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    sdf.setLenient(false);

    try {
      String st = JOptionPane.showInputDialog(null,
        "Informe uma data");
      JOptionPane.showMessageDialog(null, sdf.parse(st));
    } catch(ParseException e) {
      JOptionPane.showMessageDialog(null, "Data inválida!");
    }
  }
}
