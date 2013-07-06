package projetoWeb.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "nome",
    "descricao",
    "preco"
})
@XmlRootElement(name = "produto")
public class Produto {
    @XmlElement(required = true)
    protected Integer id;
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected Double preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }

   public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String value) {
        this.descricao = value;
    }

   public Double getPreco() {
        return preco;
    }

    public void setPreco(Double value) {
        this.preco = value;
    }

}
