package xmlarquivos;

import java.io.File;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JavaToXmlBind {
	public static void main(String[] args) {
		try {
			// Configuração da classe para a leitura/gravação de XML
			JAXBContext ctx = JAXBContext.newInstance(Informacoes.class);

			// Lê XML e grama Objetos Java
			Unmarshaller u = ctx.createUnmarshaller();
			Informacoes Informacoes = (Informacoes) u.unmarshal(new File(
					JavaToXmlBind.class.getResource("Exercicio.xml").toURI()));

			// Executa um processamento qualquer com os objetos Java
			for (Contato p : Informacoes.getContato()) {
				System.out.println(
						"Nome: " + p.getNome()
						+ "DDD: "+ p.getTelefone().getDdd()
						+ "Numero: " + p.getTelefone().getNumero()
						+ "Ramal: " + p.getTelefone().getRamal() 
						+ "Departamento: " + p.getNomedepart()
						+ "Empresa: " + p.getNomeempresa());
			}

			// Lê Objeto Java e Grava XML
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(Informacoes, System.out);
		} catch (URISyntaxException ex) {
			System.out.println("Falha ao abrir o XML");
		} catch (JAXBException ex) {
			System.out.println("JAXB Binding Exception");
			ex.printStackTrace();
		}
	}
}
