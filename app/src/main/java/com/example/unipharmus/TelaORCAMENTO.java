package com.example.unipharmus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TelaORCAMENTO extends Fragment implements View.OnClickListener {
    private EditText edNome;
    private EditText edNascimento;
    private EditText edFone;
    private EditText edCelular;
    private EditText edEndereco;
    private EditText edCidade;
    private EditText edEmail;
    private EditText edMensagem;
    private Button btEnviar;
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.telaorcamento, container, false);
        edNome = (EditText) rootView.findViewById(R.id.edNome);
        edNascimento = (EditText) rootView.findViewById(R.id.edNascimento);
        edFone = (EditText) rootView.findViewById(R.id.edFone);
        edCelular = (EditText) rootView.findViewById(R.id.edCelular);
        edEndereco = (EditText) rootView.findViewById(R.id.edEndereco);
        edCidade = (EditText) rootView.findViewById(R.id.edCidade);
        edEmail = (EditText) rootView.findViewById(R.id.edEmail);
        edMensagem = (EditText) rootView.findViewById(R.id.edMensagem);
        btEnviar = (Button) rootView.findViewById(R.id.btENVIARrelatorio);
        btEnviar.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(rootView.getContext(), "Nome: " + edNome.getText().toString(), Toast.LENGTH_LONG).show();
    }
}
