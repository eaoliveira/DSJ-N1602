package Xml.Exercicio.hobby;

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
			JAXBContext ctx = JAXBContext.newInstance(Pessoas.class);

			// Lê XML e grama Objetos Java
			Unmarshaller u = ctx.createUnmarshaller();
			Pessoas pessoas = (Pessoas) u.unmarshal(new File(
					JavaToXmlBind.class.getResource("hobby.xml").toURI()));

			// Executa um processamento qualquer com os objetos Java
			for (Pessoa p : pessoas.getPessoa()) {
				System.out.println("Nome: " + p.getNome().getPrenome() + " "
						+ p.getNome().getSobrenome() + "\nIdade: "
						+ p.getIdade() + "\nHobby: " + p.getHobby() + "\n");
			}

			// Lê Objeto Java e Grava XML
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(pessoas, System.out);
		} catch (URISyntaxException ex) {
			System.out.println("Falha ao abrir o XML");
		} catch (JAXBException ex) {
			System.out.println("JAXB Binding Exception");
			ex.printStackTrace();
		}
	}
}
