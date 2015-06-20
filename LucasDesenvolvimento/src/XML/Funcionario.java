//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.13 às 04:57:44 PM BRT 
//


package XML;

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
    "nome",
    "telefone",
    "nomedept"
})
@XmlRootElement(name = "funcionario")
public class Funcionario {

    @XmlElement(required = true)
    protected String nome;
    @XmlElement(required = true)
    protected Telefone telefone;
    @XmlElement(required = true)
    protected String nomedept;

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Obtém o valor da propriedade telefone.
     * 
     * @return
     *     possible object is
     *     {@link Telefone }
     *     
     */
    public Telefone getTelefone() {
        return telefone;
    }

    /**
     * Define o valor da propriedade telefone.
     * 
     * @param value
     *     allowed object is
     *     {@link Telefone }
     *     
     */
    public void setTelefone(Telefone value) {
        this.telefone = value;
    }

    /**
     * Obtém o valor da propriedade nomedept.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomedept() {
        return nomedept;
    }

    /**
     * Define o valor da propriedade nomedept.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomedept(String value) {
        this.nomedept = value;
    }

}
