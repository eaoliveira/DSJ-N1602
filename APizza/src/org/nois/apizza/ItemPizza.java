package org.nois.apizza;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.nois.model.ImageLoader;
import org.nois.model.ObjectDao;
import org.nois.model.Pizza;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nois.apizza.R;

public class ItemPizza extends BaseAdapter {
	private ObjectDao<Pizza> dao;
	private Map<Integer, Integer> ids;

	public ItemPizza(ObjectDao<Pizza> dao) {
		this.dao = dao;

		inicializaIds();
	}

	@Override
	public void notifyDataSetChanged() {
		inicializaIds();
		super.notifyDataSetChanged();
	}

	@SuppressLint("UseSparseArrays")
	private void inicializaIds() {
		ids = new HashMap<Integer, Integer>();
		Iterator<Pizza> t = dao.getAll().iterator();
		for (int i = 0; t.hasNext(); i++) {
			int id = (int) t.next().getId();
			ids.put(i, id);
		}
	}

	@Override
	public int getCount() {
		return dao.count();
	}

	@Override
	public Object getItem(int id) {
		return dao.get(id);
	}

	@Override
	public long getItemId(int pos) {
		return ids.get(pos);
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		RelativeLayout detalhe;

		if (view == null) {
			detalhe = new RelativeLayout(parent.getContext());
			LayoutInflater layout = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			layout.inflate(R.layout.itempizza, detalhe, true);
		} else {
			detalhe = (RelativeLayout) view;
		}

		DecimalFormat df = new DecimalFormat("#,##0.00");

		final Pizza obj = (Pizza) getItem(ids.get(position));
		TextView tvNome = (TextView) detalhe.findViewById(R.id.tvNome);
		tvNome.setText(obj.getNome());
		TextView tvIngredientes = (TextView) detalhe.findViewById(R.id.tvIngredientes);
		tvIngredientes.setText(obj.getDescricao());
		TextView tvPreco = (TextView) detalhe.findViewById(R.id.tvPreco);
		tvPreco.setText("R$ " + df.format(obj.getPreco()));

		final ImageView img = (ImageView) detalhe.findViewById(R.id.imgPeq);
		// Configura a Thread para a carga da imagem
		new ImageLoader() {
			protected void onPostExecute(Bitmap bmp) {
				if (bmp != null)
					img.setImageBitmap(bmp);
			}
		}.execute(obj.getImagemPequena());

		return detalhe;

	}
}
