package faces;


public class FoneModel {
  private Integer id =new Integer(0);
  private String ddd = "";
  private String numero = "";
  private boolean del = false;

  public FoneModel() {
  }
  
  public FoneModel(Integer id, String ddd, String numero) {
    this.id = id;
    this.ddd = ddd;
    this.numero = numero;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDdd() {
    return ddd;
  }

  public void setDdd(String ddd) {
    this.ddd = ddd;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public boolean isDel() {
    return del;
  }
  
  public boolean getDel() {
    return del;
  }

  public void setDel(boolean del) {
    this.del = del;
  }

}
