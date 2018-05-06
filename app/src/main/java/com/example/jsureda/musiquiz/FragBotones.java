package com.example.jsureda.musiquiz;

import android.content.Context;
import android.content.Intent;
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
    TextView enunciado;
    Button resA, resB, resC, resD;
    public FragBotones() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_botones, container, false);
        enunciado = (TextView) rootView.findViewById(R.id.lblPregunta);
        resA = (Button) rootView.findViewById(R.id.btnResA);
        resB = (Button) rootView.findViewById(R.id.btnResB);
        resC = (Button) rootView.findViewById(R.id.btnResC);
        resD = (Button) rootView.findViewById(R.id.btnResD);

        resA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Niveles.class);
                startActivity(intent);

            }
        });
        //Inflate the layout for this fragment
/*        Bundle bundle = this.getArguments();
        if (bundle != null) {
            codigo = bundle.getInt("id", 0);
        }*/
        return rootView;
    }


}