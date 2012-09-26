package api.fileio;

import java.awt.FileDialog;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;

public class TestePrintWriter {
	public static void main(String[] args) {
		try {
			FileDialog fd = new FileDialog((JDialog)null, 
					"      Salvar",	FileDialog.LOAD);
			
			fd.setVisible(true);
			
			if(fd.getFile() !=  null) {
   			String nome = fd.getDirectory()+
						fd.getFile();
			  FileWriter out = new FileWriter(
					nome, true);
			
  			out.write("Bla BLa BLA\n");
	  		out.write("Bla BLa BLA\n");
		  	out.write("Bla BLa BLA\n");
			  out.write("Bla BLa BLA\n");
			  out.close();
			}
			System.exit(0);

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
