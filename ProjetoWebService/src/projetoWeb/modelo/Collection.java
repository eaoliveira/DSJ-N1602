package projetoWeb.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "produto"
})
@XmlRootElement(name = "collection")
public class Collection {
    protected List<Produto> produto;

    public List<Produto> getProduto() {
        if (produto == null) {
            produto = new ArrayList<Produto>();
        }
        return this.produto;
    }
}
