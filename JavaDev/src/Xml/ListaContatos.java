package Xml;

import java.io.FileOutputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ListaContatos {
	public static void main(String[] args) {
		try {
			// Inicializa o mecanismo de conversão XML->Objeto->XML
			// passando a referência da Classe mapeada com anotações JAXB
			JAXBContext ctx = JAXBContext.newInstance(Contatos.class);
			// Obtem o mecanismo de conversão XML->Objeto
			Unmarshaller um = ctx.createUnmarshaller();
			// Cria a referencia para o XML
			URL xml = ClassLoader.getSystemResource("Xml/contatos.xml");
			
			// Lê o XML e cria uma coleção de Objetos
			Contatos lista = (Contatos) um.unmarshal(xml);

			// Percorre a coleção e lista os dados dos Objetos
			System.out.println(lista);
			
			// Obtem o mecanismo de conversão Objeto->XML
			Marshaller m = ctx.createMarshaller();
			// Configura a formatação do XML de saída
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			// Converte os Objetos contidos na coleção em XML com base nas 
			// Anotações JAXB
			
			FileOutputStream out = new FileOutputStream("/Volumes/Area/Media/pena/Desktop/contatos.xml");
			m.marshal(lista, out);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
