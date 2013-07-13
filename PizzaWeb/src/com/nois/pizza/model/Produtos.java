package com.nois.pizza.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pizza"
})
@XmlRootElement(name = "produtos")
public class Produtos {

    protected List<Pizza> pizza;

    public List<Pizza> getPizza() {
        if (pizza == null) {
            pizza = new ArrayList<Pizza>();
        }
        return this.pizza;
    }

}
