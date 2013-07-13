package com.nois.pizza.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@NamedQueries({
	@NamedQuery(name="allPizza", query="Select p from Pizza as p"),
	@NamedQuery(name="count", query="Select count(p) from Pizza as p")
})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "nome",
    "grupo",
    "descricao",
    "imagemGrande",
    "imagemPequena",
    "preco"
})
@XmlRootElement(name = "pizza")
public class Pizza {
	@Id
    @XmlElement(required = true)
    protected Integer id;
    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected String grupo;
    @XmlElement(required = true)
    protected String descricao;
    @XmlElement(required = true)
    protected String imagemGrande;
    @XmlElement(required = true)
    protected String imagemPequena;
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

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String value) {
        this.grupo = value;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String value) {
        this.descricao = value;
    }

    public String getImagemGrande() {
        return imagemGrande;
    }

    public void setImagemGrande(String value) {
        this.imagemGrande = value;
    }

    public String getImagemPequena() {
        return imagemPequena;
    }

    public void setImagemPequena(String value) {
        this.imagemPequena = value;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double value) {
        this.preco = value;
    }

}
