package Xml;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JOptionPane;
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
			// Cria as referencias para o XML e XSLT
			// Se utilizar getSystemResourceAsStream terá problemas com a
			// localização do DTD referenciado pelo XML
			URL xml = ClassLoader.getSystemResource("Xml/contatos.xml");
			InputStream xsl = ClassLoader.getSystemResourceAsStream("Xml/contatos.xsl");

			// Inicializa o mecanismo de conversão XML->Objeto->XML
			// passando a referência da Classe mapeada com anotações JAXB
			JAXBContext ctx = JAXBContext.newInstance(Contatos.class);
			// Obtem o mecanismo de conversão XML->Objeto
			Unmarshaller u = ctx.createUnmarshaller();

			// Lê o XML e cria uma coleção de Objetos
			Contatos f = (Contatos) u.unmarshal(xml);

			// ...
			JOptionPane.showMessageDialog(null, f);

			// Obtem o mecanismo de criação de transformadores XML
			TransformerFactory factory = TransformerFactory.newInstance();
			// Cria o transformador passando o XSLT a ser utilizado
			Transformer t = factory.newTransformer(new StreamSource(xsl));
			// Converte a coleção de Objetos mapeados com JAXB em HTML
			// com a utilização do XSLT configurado no passo anterior
			FileOutputStream out = new FileOutputStream("/Volumes/Area/Media/pena/Desktop/contatos.html");

			t.transform(new JAXBSource(ctx, f), new StreamResult(out));

			Runtime run = Runtime.getRuntime();
			run.exec("/Applications/Firefox.app/Contents/MacOS/firefox" +
					" file:///Volumes/Area/Media/pena/Desktop/contatos.html");
		} catch (Exception ex) {
			System.out.println("JAXB Binding Exception");
			ex.printStackTrace();
		}
	}
}
