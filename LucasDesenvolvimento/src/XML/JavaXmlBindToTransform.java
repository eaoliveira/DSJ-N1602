package XML;

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
      URL xml = Funcionario.class.getResource("funcionario.xml");
      URL xsl =Funcionario.class.getResource("funcionario.xsl");

      JAXBContext ctx = JAXBContext.newInstance(Funcionario.class);
      Unmarshaller u = ctx.createUnmarshaller();
      Funcionario funcionario = (Funcionario)u.unmarshal(xml);
      
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer t = factory.newTransformer(new StreamSource(xsl.openStream()));
      t.transform(new JAXBSource(ctx, funcionario), new StreamResult(System.out));
    }
    catch(Exception ex) {
      System.out.println("JAXB Binding Exception");
      ex.printStackTrace();
    }
  }
}
