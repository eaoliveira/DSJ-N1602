package servlets.beans4;

public class Mensagem {
  private String titulo = "";
  private String texto = "";
  private String url = "";
  
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public String getTexto() {
    return texto;
  }
  public void setTexto(String texto) {
    this.texto = texto;
  }
  public String getTitulo() {
    return titulo;
  }
  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }
}
