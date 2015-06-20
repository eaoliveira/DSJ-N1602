package Xml;

import java.io.InputStream;
import java.net.URL;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class FileTransform  { 
    public static void main(String[] args) throws Exception  { 
    	// Cria as referencias para o XML e XSLT
		URL source = ClassLoader.getSystemResource("Xml/hobby/hobby.xml");
		InputStream style = ClassLoader.getSystemResourceAsStream("Xml/hobby/hobby2.xsl");
       
		//  Obtem o mecanismo de criação de transformadores XML
        TransformerFactory factory = TransformerFactory.newInstance();
 
        // Cria o transformador passando o XSLT a ser utilizado
        Transformer t = factory.newTransformer(new StreamSource(style));

        // Converte o XML em HTML com a utilização do XSLT configurado no
        // passo anterior
        // Obs.: utilizar toString() e não openStream() por problemas na localização
        // do DTD referenciado pelo XML
        t.transform(new StreamSource(source.toString()), new StreamResult(System.out)); 
    } 
} 