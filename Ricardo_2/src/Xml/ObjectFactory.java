//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2015.06.13 às 05:05:54 PM BRT 
//


package Xml;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Xml package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Xml
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Telefone }
     * 
     */
    public Telefone createTelefone() {
        return new Telefone();
    }

    /**
     * Create an instance of {@link Pessoa }
     * 
     */
    public Pessoa createPessoa() {
        return new Pessoa();
    }

    /**
     * Create an instance of {@link Contatos }
     * 
     */
    public Contatos createContatos() {
        return new Contatos();
    }

}
