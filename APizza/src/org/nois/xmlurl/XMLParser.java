package org.nois.xmlurl;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import android.util.Log;

// Classe Utilizada para acesso via HTTP a um WebService do tipo RESTFull
public class XMLParser {
	// Obtem um XML de Resposta da URL informada atravez do metodo GET HTTP
	public String getXmlFromUrl(final String url) {
		String xml = null;
		
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet(url);

			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			xml = EntityUtils.toString(httpEntity);

		} catch (Exception ex) {
			Log.e("Error: ", ex.getMessage());
		}

		return xml;
	}
	
	// Obtem um XML de Resposta da URL informada atravez do metodo PUT HTTP
	public String putToUrl(final String url) {
		String xml = null;
		
		try {
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPut httpPut = new HttpPut(url);

			HttpResponse httpResponse = httpClient.execute(httpPut);
			HttpEntity httpEntity = httpResponse.getEntity();
			xml = EntityUtils.toString(httpEntity);

		} catch (Exception ex) {
			Log.e("Error: ", ex.getMessage());
		}

		return xml;
	}

	// Constroi um Document Object Model (DOM) a partir de um XML
	public Document getDomElement(String xml) {
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// Configura o Parser XML
			DocumentBuilder db = dbf.newDocumentBuilder();

			// Indica o XML a ser interpretado
			InputSource is = new InputSource();
			is.setCharacterStream(new StringReader(xml));
			// Processa o XML e controi a arvore DOM
			doc = db.parse(is);

		} catch (Exception ex) {
			Log.e("Error: ", ex.getMessage());
			return null;
		}

		return doc;
	}

	// Obtem o valor de um Elemento XML
	public String getValue(Element item, String str) {
		NodeList n = item.getElementsByTagName(str);
		return this.getElementValue(n.item(0));
	}

	// Obtem o valor de um Elemento XML pesquisando no Node XML
	public final String getElementValue(Node elem) {
		Node child;
		if (elem != null) {
			if (elem.hasChildNodes()) {
				for (child = elem.getFirstChild(); child != null; child = child
						.getNextSibling()) {
					if (child.getNodeType() == Node.TEXT_NODE) {
						return child.getNodeValue();
					}
				}
			}
		}

		return "";
	}

	// Retorna o Node XML a partir no nome do Elemento XML
	public NodeList getNodeList(String xml, String tag) {
		return getDomElement(xml).getElementsByTagName(tag);
	}
}
