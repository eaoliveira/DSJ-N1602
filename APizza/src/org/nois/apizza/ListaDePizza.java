package org.nois.apizza;

import java.util.List;

import org.nois.model.ImageLoader;
import org.nois.model.ObjectDao;
import org.nois.model.ObjectFactory;
import org.nois.model.ObjectRest;
import org.nois.model.Pizza;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.nois.apizza.R;

public class ListaDePizza extends ListActivity {
	private ObjectDao<Pizza> dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.listapizza);

		// Cria uma Thread para carregar os dados remotos
		new AsyncTask<Void, Void, List<Pizza>>() {
			private ProgressDialog progressDialog;

			// Apresenta o dialogo de progresso
			protected void onPreExecute() {
				progressDialog = ProgressDialog.show(ListaDePizza.this, "",
						"Carregando...");
			}

			// configura o processamento de background
			protected List<Pizza> doInBackground(Void... params) {
				return ObjectRest.getInstance().getAll();
			}

			// apos a finalizacao da carga dos dados remotos
			// atribui o conteudo da lista para o ListView
			protected void onPostExecute(List<Pizza> lista) {
				// Se tem dados 
				if (lista != null && lista.size() > 0) {
					// Atribui o resultado para o ListView
					dao = ObjectFactory.getInstance(lista);
					// Carrega os dados no DB Local
					updateLocal(lista);
				} else {
					// Caso esteja sem conexao web use a lista padrao
					dao = ObjectFactory.getInstance(getBaseContext());
				}

				setListAdapter(new ItemPizza(dao));
				// remove o dialogo de progresso
				progressDialog.dismiss();
			}
		}.execute();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);

		Intent tela = new Intent(getBaseContext(), APizza.class);

		tela.putExtra("obj", dao.get(id));
		startActivity(tela);
	}

	// Inicia uma Thread para carregar os dados em Banco de dados
	// e as imagens para o diretorio de dados no file system
	private void updateLocal(final List<Pizza> lista) {
		new Thread() {
			// Obtem o DAO para acesso ao Banco de Dados
			ObjectDao<Pizza> localDao = ObjectFactory.getInstance(getBaseContext());

			public void run() {
				// Para cada item da lista
				for (Pizza pizza : lista) {
					// Localiza o retistro no DB
					Pizza dbObj = localDao.get(pizza.getId());

					// Registro Novo
					if (dbObj == null) {
						//Inclui no DB
						localDao.add(pizza);
						// Salva as imagens em arquivo
						ImageLoader.saveImg(pizza.getImagemGrande());
						ImageLoader.saveImg(pizza.getImagemPequena());
					} else if (dbObj.equals(pizza)) {
						// Atualiza o Registro
						localDao.put(pizza);
						// Salva as imagens em arquivo
						ImageLoader.saveImg(pizza.getImagemGrande());
						ImageLoader.saveImg(pizza.getImagemPequena());
					}
				}
			}

		}.start();
	}
}
