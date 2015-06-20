//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.13 às 05:05:54 PM BRT 
//


package Xml;

import java.util.ArrayList;
import java.util.List;
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
    "pessoa"
})
@XmlRootElement(name = "contatos")
public class Contatos {

    @XmlElement(required = true)
    protected List<Pessoa> pessoa;

    /**
     * Gets the value of the pessoa property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pessoa property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPessoa().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Pessoa }
     * 
     * 
     */
    public List<Pessoa> getPessoa() {
        if (pessoa == null) {
            pessoa = new ArrayList<Pessoa>();
        }
        return this.pessoa;
    }

}
