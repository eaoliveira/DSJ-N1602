package faces;

public class FuncModel {
  private Integer id =new Integer(0);
  private String nome = "";
  private String matricula = "";
  private boolean del = false;

  public FuncModel() {
  }
  
  public FuncModel(Integer id, String nome, String matricula) {
    this.id = id;
    this.nome = nome;
    this.matricula = matricula;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
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
