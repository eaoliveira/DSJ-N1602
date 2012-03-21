package Relatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings({ "rawtypes" })
public class TesteJasperReports {
	public static void main(String[] args) {
		int resp = JOptionPane.showConfirmDialog(null,"Sim para XML, Nao para Jasper", 
				"Selecone o Tipo de Processamento",	JOptionPane.YES_NO_OPTION);

		if (resp == 0) {
			try {
				// Carrega o XML
				InputStream jrxml = TesteJasperReports.class.getResourceAsStream("report1.jrxml");
				JasperDesign design =	JRXmlLoader.load(jrxml);

				// Compila para Objeto
				JasperReport report =	JasperCompileManager.compileReport(design);

				// Conecta ao Banco de Dados
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/contratos", "root", "");

				// Opcionalmente passa parametros para o Relatorio
				Map parameters = new HashMap();
				/* parameters.put("ReportTitle", "PDF JasperReport"); */

				// Gera o relatorio
				@SuppressWarnings("unchecked")
				JasperPrint print = JasperFillManager.fillReport(report, parameters,conn);

				// Grava o PDF
				OutputStream output = new FileOutputStream(new File("/root/Desktop/Report1.pdf"));
				JasperExportManager.exportReportToPdfStream(print, output);
			} catch (FileNotFoundException ex) {
				ex.printStackTrace();
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (JRException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				// Carrega o Relatorio compilado
				InputStream jasper = RenderReport.class.getResourceAsStream("report1.jasper");

				JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasper);

				// Conecta ao Banco de Dados
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost/contratos", "root", "");

				// Opcionalmente passa parametros para o Relatorio
				Map parameters2 = new HashMap();
				/* parameters2.put("ReportTitle", "Basic JasperReport"); */

				// Gera o relatorio
				@SuppressWarnings("unchecked")
				JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,	parameters2, conn2);

				// Apresenta o Relatorio em um visualizador, que oferece opcao para
				// salvar ou imprimir
				JasperViewer.viewReport(jasperPrint);

			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (JRException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
