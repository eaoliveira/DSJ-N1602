//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.20 às 11:13:11 AM BRT 
//


package Pack;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "descricao",
    "preco",
    "nome"
})
@XmlRootElement(name = "produto")
public class Nome {

    @XmlElement(required = true)
    protected int id;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected double preco;
    @XmlElement(required = true)
    protected String nome;

    public final static int NOVO_REGISTRO = 0;
    
    public Nome() {
    	id = NOVO_REGISTRO;
    }
   
    public Nome(int id) {
    	this.id = id;
    }
    

	public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String value) {
        this.descricao = value;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double value) {
        this.preco = value;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Nome other = (Nome) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id: " + id + " Descricao: " + descricao + " preco: "
				+ preco + "nome: " + nome ;
	}
	
}
