package com.example.jsureda.musiquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;


public class FragBotones extends Fragment {
    private OnFragmentInteractionListener mListener;
   // Pregunta preg=new Pregunta();
    int codigo;
    TextView enunciado;
    String txtA,txtB,txtC,txtD;
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
        Bundle bundle = this.getArguments();
        if(getArguments() != null) {
            enunciado.setText(this.getArguments().getString("enunciado"));
            resA.setText(bundle.getString("resA"));
            resB.setText(bundle.getString("resB"));
            resC.setText(bundle.getString("resC"));
            resD.setText(bundle.getString("resD"));
        }

        resA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(resA.getText().toString());
                //Intent intent = new Intent(getActivity(), ListaNiveles.class);
                //startActivity(intent);

            }
        });
        resB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(resB.getText().toString());

            }
        });
        resC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(resC.getText().toString());

            }
        });
        resD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onFragmentInteraction(resD.getText().toString());

            }
        });
        //Inflate the layout for this fragment
/*        Bundle bundle = this.getArguments();
        if (bundle != null) {
            codigo = bundle.getInt("id", 0);
        }*/
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentFindListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String resultado);
    }
}