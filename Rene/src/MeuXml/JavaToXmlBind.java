package MeuXml;

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
			JAXBContext ctx = JAXBContext.newInstance(Cadastro.class);

			// Lê XML e grama Objetos Java
			Unmarshaller u = ctx.createUnmarshaller();
			Cadastro cadastro = (Cadastro) u.unmarshal(new File(
					JavaToXmlBind.class.getResource("CadastroClientes.xml").toURI()));

			// Executa um processamento qualquer com os objetos Java
			for (Cliente c : cadastro.getCliente()) {
				System.out.println("Nome: " + c.getNome() + "\nDDD"
						+ c.getDdd() + "\nTelefone: "
						+ c.getTelefone() + "\nDepartamento: " + c.getDepartamento() + "\nEmpresa " + c.getEmpresa() + "\n");
			}

			// Lê Objeto Java e Grava XML
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		} catch (URISyntaxException ex) {
			System.out.println("Falha ao abrir o XML");
		} catch (JAXBException ex) {
			System.out.println("JAXB Binding Exception");
			ex.printStackTrace();
		}
	}
}
