package introducao;

public class Documentacao2 {
  private String texto;

  public Documentacao2(String texto) {
    this.texto = texto;
  }

  public String inverso() {
    String st = "";
    for(int i = 0;i < texto.length();i++)
      st = texto.charAt(i) + st;
    return st;
  }
}