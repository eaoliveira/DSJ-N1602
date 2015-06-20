//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.13 às 04:45:13 PM BRT 
//


package Xml.Exercicio.hobby;

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
    "prenome",
    "sobrenome"
})
@XmlRootElement(name = "nome")
public class Nome {

    @XmlElement(required = true)
    protected String prenome;
    @XmlElement(required = true)
    protected String sobrenome;

    /**
     * Obtém o valor da propriedade prenome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenome() {
        return prenome;
    }

    /**
     * Define o valor da propriedade prenome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenome(String value) {
        this.prenome = value;
    }

    /**
     * Obtém o valor da propriedade sobrenome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Define o valor da propriedade sobrenome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSobrenome(String value) {
        this.sobrenome = value;
    }

}
