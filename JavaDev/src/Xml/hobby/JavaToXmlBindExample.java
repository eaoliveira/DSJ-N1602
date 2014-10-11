package Xml.hobby;

// https://jaxb.dev.java.net
// JAXB - Java-to-XML

import java.io.*;
import java.net.URISyntaxException;

import javax.xml.bind.*;

import Xml.pessoa.Pessoa;
import Xml.pessoa.Pessoas;

public class JavaToXmlBindExample {
   public static void main(String[] args) {
     try {
    	    // Prepara o contexto de processamento de XML com base nas classes anotadas
    	    // em relação ao DTD
        JAXBContext ctx = JAXBContext.newInstance(Pessoas.class);
        Unmarshaller u = ctx.createUnmarshaller();
        
        // Define a url para o arquivo XML a ser processado
        File url = new File(JavaToXmlBindExample.class.getResource("hobby.xml").toURI());
        
        // Processa o arquivo XML para construir objetos Java
        Pessoas pessoas = (Pessoas)u.unmarshal(url);
        
        // Lista os dados carregado apartir do XML
        for(Pessoa p : pessoas.getPessoa())
          System.out.println("Nome: " + p.getNome().getPrenome() +
        		" " + p.getNome().getSobrenome() +
        		"\nIdade: " + p.getIdade() +
        		"\nHobby: " + p.getHobby() + "\n");

        // Processando os dados no objetos Java e gerando XML
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
 //       FileOutputStream fo = new FileOutputStream("/Volumes/Area/Media/pena/Desktop/xmlSaida.xml");
        
        m.marshal(pessoas, System.out);
     } catch (JAXBException ex) {
        System.out.println("JAXB Binding Exception");
        ex.printStackTrace();
     } catch (URISyntaxException e) {
		e.printStackTrace();
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
	}
  }
}
