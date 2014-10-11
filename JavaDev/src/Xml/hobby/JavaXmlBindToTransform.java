package Xml.hobby;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import Xml.pessoa.Pessoas;

public class JavaXmlBindToTransform {
  public static void main(String[] args) {
    try {
    	  // Definindo os arquivos XML e XSL
      URL xml = JavaXmlBindToTransform.class.getResource("hobby.xml");
      URL xsl = JavaXmlBindToTransform.class.getResource("hobby.xsl");

      // Carregando os dados de XML para objetos Java
      JAXBContext ctx = JAXBContext.newInstance(Pessoas.class);
      Unmarshaller u = ctx.createUnmarshaller();
      Pessoas pessoas = (Pessoas)u.unmarshal(xml);
      
      // Aplicando transformação XSL no XML
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer t = factory.newTransformer(new StreamSource(xsl.openStream()));

      // Cria um arquivo Temporário
      File temp = File.createTempFile("Hobby", ".html");
      // Gera o HTML no arquivo temporário apartir dos Objetos Pessoa
      t.transform(new JAXBSource(ctx, pessoas), new StreamResult(new FileOutputStream(temp)));
      if(Desktop.isDesktopSupported())
    	  	Desktop.getDesktop().browse(temp.toURI());
      else 
    	    System.out.println("O arquivo " + temp.getName() + " não pode ser aberto no Navegador Web");
    }
    catch(Exception ex) {
      System.out.println("JAXB Binding Exception");
      ex.printStackTrace();
    }
  }
}
