//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2014.10.14 às 04:54:54 PM BRT 
//


package xml;

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
    "id",
    "idade",
    "primeiroNome"
})
@XmlRootElement(name = "nome")
public class Nome {

    @XmlElement(required = true, type=Integer.class)
    protected Integer id;
    @XmlElement(required = true, type=Integer.class)
    protected int idade;
    @XmlElement(required = true)
    protected String primeiroNome;

    /**
     * Obtém o valor da propriedade id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade idade.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define o valor da propriedade idade.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdade(int value) {
        this.idade = value;
    }

    /**
     * Obtém o valor da propriedade primeiroNome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimeiroNome() {
        return primeiroNome;
    }

    /**
     * Define o valor da propriedade primeiroNome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimeiroNome(String value) {
        this.primeiroNome = value;
    }

}
