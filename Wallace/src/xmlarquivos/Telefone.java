//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementa��o de Refer�ncia (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modifica��es neste arquivo ser�o perdidas ap�s a recompila��o do esquema de origem. 
// Gerado em: 2015.06.13 �s 05:11:23 PM BRT 
//


package xmlarquivos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "telefone")
public class Telefone {

    @XmlAttribute(name = "ddd", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ddd;
    @XmlAttribute(name = "numero", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String numero;
    @XmlAttribute(name = "ramal")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ramal;

    /**
     * Obt�m o valor da propriedade ddd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * Define o valor da propriedade ddd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDdd(String value) {
        this.ddd = value;
    }

    /**
     * Obt�m o valor da propriedade numero.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Define o valor da propriedade numero.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumero(String value) {
        this.numero = value;
    }

    /**
     * Obt�m o valor da propriedade ramal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRamal() {
        return ramal;
    }

    /**
     * Define o valor da propriedade ramal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRamal(String value) {
        this.ramal = value;
    }

}
