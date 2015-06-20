package Xml.Exercicio.hobby;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class FileTransformOpen {
	public static void main(String[] args) throws Exception {
		// Cria as referencias para o XML e XSLT
		URL source = ClassLoader.getSystemResource("Xml/hobby/hobby.xml");
		InputStream style = ClassLoader
				.getSystemResourceAsStream("Xml/hobby/hobby2.xsl");

		// Obtem o mecanismo de criação de transformadores XML
		TransformerFactory factory = TransformerFactory.newInstance();

		// Cria o transformador passando o XSLT a ser utilizado
		Transformer t = factory.newTransformer(new StreamSource(style));

		File temp = File.createTempFile("hobby", ".html");

		// Converte o XML em HTML com a utilização do XSLT configurado no
		// passo anterior
		// Obs.: utilizar toString() e não openStream() por problemas na
		// localização
		// do DTD referenciado pelo XML
		t.transform(new StreamSource(source.toString()), new StreamResult(temp));

		Desktop desk = Desktop.getDesktop();
		if (Desktop.isDesktopSupported()) {
			desk.open(temp);
		} else {
			try (BufferedReader in = new BufferedReader(new FileReader(temp))) {
				for (String linha = in.readLine(); linha != null; linha = in
						.readLine()) {
					System.out.println(linha);
				}
			} catch (IOException e) {
				System.out
						.println("Erro: falha na leitura do arquivo de saida");
			}
		}
	}
}