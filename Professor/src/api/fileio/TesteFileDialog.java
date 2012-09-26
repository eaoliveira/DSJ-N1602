package api.fileio;

import java.awt.FileDialog;

import javax.swing.JDialog;

public class TesteFileDialog {
	public static void main(String[] args) {
		FileDialog fd = new FileDialog((JDialog) null, 
				"Abrir", FileDialog.LOAD);
		fd.setFile("*.alg");
		fd.setVisible(true);
		System.out.println(fd.getDirectory() + fd.getFile());
		System.exit(0);
	}
}
