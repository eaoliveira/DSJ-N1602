package Relatorio;

import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IPDFRenderOption;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.PDFRenderOption;

public class RenderReport {
	public static void main(String[] args) {
		try {
			renderReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "deprecation" })
	static void renderReport() throws EngineException {
		IReportEngine engine = null;
		EngineConfig config = null;

		//org.eclipse.datatools_workspacepath
		
		try {
			String local = RenderReport.class.getResource(".").toURI().toString();
			config = new EngineConfig();
			config.setBIRTHome(local+"/birt_libs");
			config.setLogConfig(local+"/log", java.util.logging.Level.WARNING);
			Platform.startup(config);
			IReportEngineFactory factory = (IReportEngineFactory)Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			engine = factory.createReportEngine(config);

			IReportRunnable run = engine.openReportDesign(RenderReport.class.getResourceAsStream("primeiroRepo.rptdesign"));
			// Create Render Task
			IRunAndRenderTask task = engine.createRunAndRenderTask(run);
			// Set parent classloader report engine
			// task.getAppContext().put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY,
			// RenderTaskExample.class.getClassLoader());

			PDFRenderOption pdfOptions = new PDFRenderOption();
			pdfOptions.setOption(IPDFRenderOption.FIT_TO_PAGE, new Boolean(true));
			// pdfOptions.setOption( IPDFRenderOption.PAGEBREAK_PAGINATION_ONLY, new
			// Boolean(true) );
			pdfOptions.setOutputFormat("pdf");
			pdfOptions.setOutputFileName("/root/Desktop/test2.pdf");

//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/contratos","root","");
//			
//			task.getAppContext().put("OdaJDBCDriverPassInConnection", con);
			task.setRenderOption(pdfOptions);
			task.run();
			task.close();
			engine.destroy();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Platform.shutdown();
		}
	}
}