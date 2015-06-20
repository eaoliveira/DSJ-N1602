package Xml;

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class JavaXmlBindToTransform {
  public static void main(String[] args) {
    try {
      URL xml = Cadastroteste.class.getResource("cadastrotesteparaXls.xml");
      URL xsl = Cadastroteste.class.getResource("cadastroteste.xsl");

      JAXBContext ctx = JAXBContext.newInstance(Cadastroteste.class);
      Unmarshaller u = ctx.createUnmarshaller();
      Cadastroteste pessoas = (Cadastroteste)u.unmarshal(xml);
      
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer t = factory.newTransformer(new StreamSource(xsl.openStream()));
      t.transform(new JAXBSource(ctx, pessoas), new StreamResult(System.out));//gera uma pagina html a partir de um arquivo xml
    }
    catch(Exception ex) {
      System.out.println("JAXB Binding Exception");
      ex.printStackTrace();
    }
  }
}
