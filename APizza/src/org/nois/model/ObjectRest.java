package org.nois.model;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.nois.xmlurl.XMLParser;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

// Classe que implementa o acesso a RESFull WebService para a obtencao dos
// dados remotos
public class ObjectRest {
	private static ObjectRest obj;
	// Referencia ao parser XML
	private XMLParser parser;
	// Endereco do WS remoto
	private final String url = "http://10.190.39.250:8080/PizzaWeb/srv/";

	private ObjectRest() {
		// Cria o parser XML
		parser = new XMLParser();
	}

	public static ObjectRest getInstance() {
		if (obj == null) {
			obj = new ObjectRest();
		}

		return obj;
	}

	// Abre a conexao remota via WS para um item
	public InputStream getStream(String res) throws MalformedURLException,
			IOException {
		URL url = new URL("http", "10.190.39.250", 8080, "/PizzaWeb/images/"
				+ res);

		return url.openStream();
	}

	// Retorna a quantidade de registros remotos
	public int count() {
		int count = -1;

		// executa o metodo WS remoto para obter a quantidade de registros
		String xml = parser.getXmlFromUrl(url + "count");

		// Processa o XML de resposta para obter o numero de registros
		if (xml != null) {
			NodeList node = parser.getNodeList(xml, "registro");
			count = Integer.parseInt(parser.getValue((Element) node.item(0),
					"count"));
		}

		return count;
	}

	// Obtem um registro vis WS remoto com base em seu ID
	public Pizza get(long id) {
		Pizza obj = new Pizza();

		// executa o metodo WS remoto para obter o registro
		String xml = parser.getXmlFromUrl(url + String.valueOf(id));

		if (xml != null) {
			// Processa o XML de resposta para obter os dados do Registro
			NodeList node = parser.getNodeList(xml, "pizza");
			Element e = (Element) node.item(0);

			obj.setId(Integer.parseInt(parser.getValue(e, "id")));
			obj.setNome(parser.getValue(e, "nome"));
			obj.setGrupo(parser.getValue(e, "grupo"));
			obj.setDescricao(parser.getValue(e, "descricao"));
			obj.setImagemGrande(parser.getValue(e, "imagemGrande"));
			obj.setImagemPequena(parser.getValue(e, "imagemPequena"));
			obj.setPreco(Double.parseDouble(parser.getValue(e, "preco")));
		}

		return obj;
	}

	// Obtem a lista de todos os registros vis WS remoto
	public List<Pizza> getAll() {
		List<Pizza> lista = new ArrayList<Pizza>();

		// executa o metodo WS remoto para obtencao dos registros
		String xml = parser.getXmlFromUrl(url + "all");

		if (xml != null) {
			// Processa o XML de resposta para obter os dados dos Registros
			NodeList node = parser.getNodeList(xml, "pizza");

			for (int i = 0; i < node.getLength(); i++) {
				Element e = (Element) node.item(i);

				Pizza obj = new Pizza();
				obj.setId(Integer.parseInt(parser.getValue(e, "id")));
				obj.setNome(parser.getValue(e, "nome"));
				obj.setGrupo(parser.getValue(e, "grupo"));
				obj.setDescricao(parser.getValue(e, "descricao"));
				obj.setImagemGrande(parser.getValue(e, "imagemGrande"));
				obj.setImagemPequena(parser.getValue(e, "imagemPequena"));
				obj.setPreco(Double.parseDouble(parser.getValue(e, "preco")));

				lista.add(obj);
			}
		}

		return lista;
	}

}
