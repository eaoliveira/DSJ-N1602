package api.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TesteLeituraGravacao {
	public static void main(String[] args) {
		try {
			BufferedReader fr = new BufferedReader( 
					new FileReader(
						"C:\\users\\" +
									"javaprg\\Desktop\\dados.txt"));
			PrintWriter out = new PrintWriter(
					"C:\\users\\" +
					"javaprg\\Desktop\\SaidaTeste.txt");

			String linha = fr.readLine();
			while(linha  != null) {
				out.println(linha);
				linha = fr.readLine();
			}

			fr.close();
			out.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
}
