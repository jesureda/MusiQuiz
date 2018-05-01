package com.example.jsureda.musiquiz;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class FragLogo extends Fragment {

    int codigo;
    public FragLogo() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_logo, container, false);
        ImageView imageView=(ImageView) rootView.findViewById(R.id.imgLogo);
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            codigo = bundle.getInt("id", 0);
        }
        imageView.setImageResource(codigo);
        return rootView;
    }


}
