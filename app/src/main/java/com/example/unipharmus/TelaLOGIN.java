package com.example.unipharmus;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaLOGIN extends Activity {
    private Button entrar, sair;
    private EditText usuario, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telalogin);

        entrar = (Button) findViewById(R.id.btENTRAR);
        sair = (Button) findViewById(R.id.btSAIR);
        usuario = (EditText) findViewById(R.id.campoUSUARIO);
        senha = (EditText) findViewById(R.id.campoSENHA);

        entrar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
              if (usuario.getText().toString().equals("admin") && senha.getText().toString().equals("123")) {
                  new AsyncTask<Void, Void, Void>() {
                      private ProgressDialog pd;

                      @Override
                      protected void onPreExecute() {
                          pd = new ProgressDialog(TelaLOGIN.this);
                          pd.setTitle("Aguarde");
                          pd.setMessage("Carregando a interface ...");
                          pd.setIndeterminate(false);
                          pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                          pd.setMax(1000);
                          pd.show();
                      }

                      @Override
                      protected Void doInBackground(Void... voids) {
                          try {
                              for (int i = 0;!isCancelled() && i < 1000; i++) {
                                  Thread.sleep(1000);
                                  pd.setProgress(i*1000);
                              }
                          } catch (InterruptedException ex) {
                              ex.printStackTrace();
                              pd.setProgress(0);
                          }
                          return null;
                      }

                      @Override
                      protected void onPostExecute(Void aVoid) {
                          usuario.setText("");
                          senha.setTag("");
                          pd.dismiss();
                      }

                      @Override
                      protected void onCancelled() {
                          Toast.makeText(TelaLOGIN.this, "Um erro inesperado ocorreu. Contate o suporte.",
                                  Toast.LENGTH_LONG).show();
                          pd.dismiss();
                      }
                  }.execute();
//                  final ProgressDialog pd = ProgressDialog.show(TelaLOGIN.this,
//                          "Aguarde", "Carregando interface ...", true);
//                  pd.setCancelable(true);
//                  new Thread(new Runnable() {
//                      @Override
//                      public void run() {
//                          try {
//                              Thread.sleep(10000);
//                          } catch (Exception e) {
//                              Toast.makeText(TelaLOGIN.this, "Um erro inesperado ocorreu. Contate o suporte.",
//                                      Toast.LENGTH_LONG).show();
//                          }
//                          pd.dismiss();
//                      }
//                  }).start();
                  Intent irHOME = new Intent(TelaLOGIN.this, MainActivity.class);
                  startActivity(irHOME);
              } else {
                  Toast.makeText(TelaLOGIN.this, "Usuario/senha incorretos. Verifique-os.", Toast.LENGTH_LONG).show();
              }
            }
            }
        );

        sair.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            return false;
        return false;
    }
}
