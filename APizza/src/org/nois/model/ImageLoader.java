package org.nois.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
// Classe especial que implementa Thread para acesso a RESTFull WS 
// para obtemcao das imagens
public abstract class ImageLoader extends AsyncTask<String, Void, Bitmap> {
	protected Bitmap doInBackground(String... img) {
		Bitmap bmp = null;
		try {
			// Abre a conexao de rede para o WS e acessa a imagem remota
			InputStream in = ObjectRest.getInstance().getStream(img[0]);
			// converte os dados transmitidos em imagem
			bmp = BitmapFactory.decodeStream(in);
		} catch (Exception ex) {  // Caso exista falha de conexao 
			try {
				// Abre a conexao para o diretorio de dados onde as imagens sao armazenadas
				File local = new File(Environment.getDataDirectory(),"data/com.nois.apizza/images");
				InputStream in = new FileInputStream(new File(local, img[0]));
				// Le o arquivo e converte em imagem
				bmp = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return bmp;
	}

	// Rotina que definira o destino da imagem carregada
	protected abstract void onPostExecute(Bitmap bmp);

	// Rotina utilizada para salvar uma imagem em arquivo local
	public static void saveImg(String name) {
		Log.e("saveImage", name);
		try {
			// Configura o diretorio de destino das imagens
			File local = new File(Environment.getDataDirectory(),"data/com.nois.apizza/images");
			// Cria o diretorio caso nao exista
			local.mkdir();
			
			// Abre as conexoes para leitura remota e escrita local
			InputStream in = ObjectRest.getInstance().getStream(name);
			OutputStream out = new FileOutputStream(new File(local, name));
			// Le blocos de 2048 de dados remoto e grava localmente
			try {
				byte[] buff = new byte[2048];
				int count = 0;
				while ((count = in.read(buff, 0, buff.length)) >= 0) {
					out.write(buff, 0, count);
				}
			} finally {
				in.close();
				out.close();
			}
		} catch (Exception ex) {
			Log.e("saveImage", ex.getMessage());
			ex.printStackTrace();
		}
	}
}