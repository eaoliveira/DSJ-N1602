//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.20 às 03:46:01 PM BRT 
//


package xml;

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

    
    
    public Produto() {
		super();
	}

	public Produto(int chave) {
		id = chave;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "id: " + id + " nome: " + descricao + " preco: "+ preco;   
				
	
	}
    

}
