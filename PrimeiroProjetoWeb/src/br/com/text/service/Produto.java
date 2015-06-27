//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.20 às 03:38:13 PM BRT 
//

package br.com.text.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "nome", "descricao", "preco" })
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

	public Produto(int chave) {
		this.id = chave;
	}

	public Produto() {
		id = NOVO_REGISTRO;
		System.out.println("produto");
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
	 * Obtém o valor da propriedade nome.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o valor da propriedade nome.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNome(String value) {
		this.nome = value;
	}

	/**
	 * Obtém o valor da propriedade descricao.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Define o valor da propriedade descricao.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDescricao(String value) {
		this.descricao = value;
	}

	/**
	 * Obtém o valor da propriedade preco.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPreco() {
		return preco;
	}

	/**
	 * Define o valor da propriedade preco.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setPreco(String value) {
		this.preco = value;
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
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
