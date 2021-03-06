package com.example.jsureda.musiquiz;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;


public class FragBotones extends Fragment {
    private OnFragmentInteractionListener mListener;
    // Pregunta preg=new Pregunta();
    int codigo;
    String correcta;
    TextView enunciado;
    Button resA, resB, resC, resD;
    boolean sonido;
    MediaPlayer mp;
    public FragBotones() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_botones, container, false);
        enunciado = (TextView) rootView.findViewById(R.id.lblPregunta);
        resA = (Button) rootView.findViewById(R.id.btnResA);
        resB = (Button) rootView.findViewById(R.id.btnResB);
        resC = (Button) rootView.findViewById(R.id.btnResC);
        resD = (Button) rootView.findViewById(R.id.btnResD);
        Bundle bundle = this.getArguments();
        if (getArguments() != null) {
            enunciado.setText(this.getArguments().getString("enunciado"));
            resA.setText(bundle.getString("resA"));
            resB.setText(bundle.getString("resB"));
            resC.setText(bundle.getString("resC"));
            resD.setText(bundle.getString("resD"));
            correcta = bundle.getString("resCorr");
            sonido = bundle.getBoolean("sonido");
        }

        resA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                if (resA.getText().toString().equals(correcta)) {
                    resA.setBackgroundColor(Color.GREEN);
                } else {
                    resA.setBackgroundColor(Color.RED);
                }
                mListener.onFragmentInteraction(resA.getText().toString());
            }
        });
        resB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                if (resB.getText().toString().equals(correcta)) {
                    resB.setBackgroundColor(Color.GREEN);
                } else {
                    resB.setBackgroundColor(Color.RED);
                }
                mListener.onFragmentInteraction(resB.getText().toString());
            }
        });
        resC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                if (resC.getText().toString().equals(correcta)) {
                    resC.setBackgroundColor(Color.GREEN);
                } else {
                    resC.setBackgroundColor(Color.RED);
                }
                mListener.onFragmentInteraction(resC.getText().toString());
            }
        });
        resD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sonido) { sonidoBoton(); }
                if (resD.getText().toString().equals(correcta)) {
                    resD.setBackgroundColor(Color.GREEN);
                } else {
                    resD.setBackgroundColor(Color.RED);
                }
                mListener.onFragmentInteraction(resD.getText().toString());
            }
        });

        return rootView;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String resultado);
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


    private void sonidoBoton() {
        mp = new MediaPlayer();
        try {
            AssetFileDescriptor afd = getContext().getAssets().openFd("clickbutton.mp3");
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mp.start();
        if(!mp.isPlaying())
            mp.release();
    }
}