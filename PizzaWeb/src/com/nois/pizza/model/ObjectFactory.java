package com.nois.pizza.model;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Produtos createProdutos() {
        return new Produtos();
    }

    public Pizza createPizza() {
        return new Pizza();
    }

}
