package com.example.unipharmus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TelaCONTATO extends Fragment {
    private Button enviarrelatorio;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.telacontato, container, false);

        enviarrelatorio = (Button) rootView.findViewById(R.id.btENVIARrelatorio);
        return rootView;
    }
}
