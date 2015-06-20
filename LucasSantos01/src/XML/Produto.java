//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.20 às 03:50:03 PM BRT 
//


package XML;

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

    public Produto() {
    
	}
    
    public Produto(int id) {
    	this.id=id;
	}
    
    public Produto(Integer id, String nome, String descricao,String preco ) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

    
    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
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

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao="
				+ descricao + ", preco=" + preco + "]";
	}

}
