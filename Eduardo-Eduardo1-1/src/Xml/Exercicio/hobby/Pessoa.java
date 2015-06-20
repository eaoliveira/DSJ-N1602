//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.13 às 04:45:13 PM BRT 
//


package Xml.Exercicio.hobby;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nome",
    "profissao",
    "hobby"
})
@XmlRootElement(name = "pessoa")
public class Pessoa {

    @XmlAttribute(name = "idade", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String idade;
    @XmlElement(required = true)
    protected Nome nome;
    protected List<Profissao> profissao;
    @XmlElement(required = true)
    protected String hobby;

    /**
     * Obtém o valor da propriedade idade.
     * 
     * @return
     *     possible object is
     *     {@link int }
     *     
     */
    public String getIdade() {
        return idade;
    }

    /**
     * Define o valor da propriedade idade.
     * 
     * @param value
     *     allowed object is
     *     {@link int }
     *     
     */
    public void setIdade(String value) {
        this.idade = value;
    }

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link Nome }
     *     
     */
    public Nome getNome() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     * 
     * @param value
     *     allowed object is
     *     {@link Nome }
     *     
     */
    public void setNome(Nome value) {
        this.nome = value;
    }

    /**
     * Gets the value of the profissao property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profissao property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfissao().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Profissao }
     * 
     * 
     */
    public List<Profissao> getProfissao() {
        if (profissao == null) {
            profissao = new ArrayList<Profissao>();
        }
        return this.profissao;
    }

    /**
     * Obtém o valor da propriedade hobby.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Define o valor da propriedade hobby.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHobby(String value) {
        this.hobby = value;
    }

}
