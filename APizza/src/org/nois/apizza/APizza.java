package org.nois.apizza;

import java.text.DecimalFormat;

import org.nois.model.ImageLoader;
import org.nois.model.Pizza;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nois.apizza.R;

public class APizza extends Activity implements OnClickListener {
	private ImageView imgGrande;
	private TextView tvNome;
	private TextView tvDescricao;
	private TextView tvPreco;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.apizza);

		imgGrande = (ImageView) findViewById(R.id.imgGrande);
		tvNome = (TextView) findViewById(R.id.tvNome);
		tvDescricao = (TextView) findViewById(R.id.tvIngredientes);
		tvPreco = (TextView) findViewById(R.id.tvPreco);
		Button btcomprar = (Button) findViewById(R.id.btComprar);
		btcomprar.setOnClickListener(this);
	}

	@Override
	protected void onResume() {
		Intent intent = getIntent();

		if (intent != null) {
			Bundle dados = intent.getExtras();

			if (dados != null) {
				DecimalFormat df = new DecimalFormat("#,##0.00");

				Pizza obj = (Pizza) dados.get("obj");
				tvNome.setText(obj.getNome());
				tvDescricao.setText(obj.getDescricao());
				tvPreco.setText("R$ " + df.format(obj.getPreco()));
				// configura a Thread para a Carga da Imagem
				new ImageLoader() {
					protected void onPostExecute(Bitmap bmp) {
						if (bmp != null)
							imgGrande.setImageBitmap(bmp);
					}
				}.execute(obj.getImagemGrande());
			}
		}

		super.onResume();
	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.btComprar) {
			Toast.makeText(this, "Adicionado na Cesta", Toast.LENGTH_LONG).show();
		}
	}

}
