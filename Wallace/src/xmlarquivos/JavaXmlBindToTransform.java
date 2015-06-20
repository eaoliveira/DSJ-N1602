package xmlarquivos;

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
      URL xml = Informacoes.class.getResource("Exercicio.xml");
      URL xsl =Informacoes.class.getResource("ExercicioXSL.xsl");

      JAXBContext ctx = JAXBContext.newInstance(Informacoes.class);
      Unmarshaller u = ctx.createUnmarshaller();
      Informacoes Informacoes = (Informacoes)u.unmarshal(xml);
      
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer t = factory.newTransformer(new StreamSource(xsl.openStream()));
      t.transform(new JAXBSource(ctx, Informacoes), new StreamResult(System.out));
    }
    catch(Exception ex) {
      System.out.println("JAXB Binding Exception");
      ex.printStackTrace();
    }
  }
}
