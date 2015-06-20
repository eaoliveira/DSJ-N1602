package XML;

import java.io.File;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JavaToXmlBind {
	public static void main(String[] args) {
		try {
			
			JAXBContext ctx = JAXBContext.newInstance(Departamento.class);

			
			Unmarshaller u = ctx.createUnmarshaller();
			Departamento departamento = (Departamento) u.unmarshal(new File(
					JavaToXmlBind.class.getResource("funcionario.xml").toURI()));

			
			for (Funcionario p : departamento.getFuncionario()) {
				System.out.println("Nome: " + p.getNome()
						+ "\nTelefone"
						+"\nDDD: "+ p.getTelefone().ddd 
						+"\nNúmero: "+ p.getTelefone().numero 
						+"\nRamal: "+ p.getTelefone().ramal 
						+"\nDepartamento: "+ p.getNomedept()+"\n\n");
			}

			// Lê Objeto Java e Grava XML
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(departamento, System.out);
		} catch (URISyntaxException ex) {
			System.out.println("Falha ao abrir o XML");
		} catch (JAXBException ex) {
			System.out.println("JAXB Binding Exception");
			ex.printStackTrace();
		}
	}
}
