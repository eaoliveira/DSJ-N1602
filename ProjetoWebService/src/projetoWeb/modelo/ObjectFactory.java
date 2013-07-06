package projetoWeb.modelo;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }

    public Produto createProduto() {
        return new Produto();
    }

    public Collection createCollection() {
        return new Collection();
    }
}
