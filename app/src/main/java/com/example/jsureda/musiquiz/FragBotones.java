package com.example.jsureda.musiquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class FragBotones extends Fragment {

    int codigo;
    public FragBotones() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_logo, container, false);
        TextView enunciado = (TextView) rootView.findViewById(R.id.lblPregunta);
        Button resA = (Button) rootView.findViewById(R.id.btnResA);
        Button resB = (Button) rootView.findViewById(R.id.btnResB);
        Button resC = (Button) rootView.findViewById(R.id.btnResC);
        Button resD = (Button) rootView.findViewById(R.id.btnResD);


        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            codigo = bundle.getInt("id", 0);
        }
        return rootView;
    }


}