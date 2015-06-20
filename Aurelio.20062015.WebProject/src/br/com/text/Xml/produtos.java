package br.com.text.Xml;

import javax.xml.bind.annotation.XmlElement;

public class produtos {

	@XmlElement(required = true)
    protected int id;
    @XmlElement(required = true)
    protected String produto;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected float preco;
	
    public void Produto(int id,String produto,String descricao,float preco) {
		
		this.id = id;
		this.produto = produto;
		this.descricao = descricao;
		this.preco = preco ; 
		
    }
    
    public final static int NOVO_REGISTRO = 0;
		
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
    @Override
	public String toString() {
		return "id: " + id + "Produto:"+ produto + "Descrição:" + descricao + "Preço: "+ preco ;
	}
	

}
