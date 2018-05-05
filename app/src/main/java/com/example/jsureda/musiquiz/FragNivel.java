package com.example.jsureda.musiquiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FragNivel extends Fragment {

    int codigo;
    ImageView imgCandado; ImageButton btnNivel;
    public FragNivel() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_logo, container, false);
        imgCandado=(ImageView) rootView.findViewById(R.id.imgCandado);
        btnNivel=(ImageButton) rootView.findViewById(R.id.btnNivel);
        // Inflate the layout for this fragment
/*        Bundle bundle = this.getArguments();
        if (bundle != null) {
            codigo = bundle.getInt("id", 0);
        }
        imageView.setImageResource(codigo);*/
        return rootView;
    }
}
