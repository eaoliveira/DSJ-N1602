
package br.com.text.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
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
    protected int id;
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected String preco;
    
    public final static int NOVO_REGISTRO = 0;
    
    
    public Produto(){
    	id = NOVO_REGISTRO;
    }

    public Produto(int chave) {
		this.id = chave;
	}

	public int getId() {
        return id;
    }

    public void setId(int value) {
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

       public String getPreco() {
        return preco;
    }

    public void setPreco(String value) {
        this.preco = value;
    }

}
