//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2016.02.13 às 11:33:59 AM BRST 
//

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
@XmlType(name = "", propOrder = { "id", "idade", "primeiroNome" })
@XmlRootElement(name = "nome")
public class Nome {
	@XmlElement(required = true)
	protected int id;
	@XmlElement(required = true)
	protected int idade;
	@XmlElement(required = true)
	protected String primeiroNome;
	
	public static final int NOVO_REGISTRO = 0;
	
	public Nome() {
		super();
	}
	
	public Nome(int id) {
		super();
		this.id = id;
	}

	/**
	 * Obtém o valor da propriedade id.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public int getId() {
		return id;
	}

	/**
	 * Define o valor da propriedade id.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setId(int value) {
		this.id = value;
	}

	/**
	 * Obtém o valor da propriedade idade.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * Define o valor da propriedade idade.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setIdade(int value) {
		this.idade = value;
	}

	/**
	 * Obtém o valor da propriedade primeiroNome.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPrimeiroNome() {
		return primeiroNome;
	}

	/**
	 * Define o valor da propriedade primeiroNome.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPrimeiroNome(String value) {
		this.primeiroNome = value;
	}

	@Override
	public int hashCode() {
		final int prime = 3982731;
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
		return "Nome [id=" + id + ", idade=" + idade + ", primeiroNome=" + primeiroNome + "]";
	}

	
}
