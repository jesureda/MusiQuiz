package com.example.jsureda.musiquiz;

import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Preguntas extends AppCompatActivity implements FragBotones.OnFragmentInteractionListener {
    TextView txtTiempo; EditText player;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragBotones botones = new FragBotones();
    ArrayList <Pregunta> questions =new ArrayList<>();
    private DatabaseHelper pregSQLite=null;
    int nivel, progresoInicial, contador=0,progreso=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        nivel = getIntent().getIntExtra("nivel",1);
        progresoInicial = getIntent().getIntExtra("progresoInicial",0);
        pregSQLite = new DatabaseHelper(this);
        nivel=1;
        questions=pregSQLite.listaPreguntas(10,nivel);

        Bundle bundle=new Bundle();
        bundle.putString("enunciado",questions.get(contador).getEnunciado());
        bundle.putString("resA",questions.get(contador).getRespuestaA());
        bundle.putString("resB",questions.get(contador).getRespuestaB());
        bundle.putString("resC",questions.get(contador).getRespuestaC());
        bundle.putString("resD",questions.get(contador).getRespuestaD());
        botones.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frBotones, botones);
        fragmentTransaction.commit();

        txtTiempo = (TextView)findViewById(R.id.txtTime);
        player =(EditText) findViewById(R.id.imageButton) ;
        player.setText(questions.get(contador).getCorrecta());

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Tiempo restante: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }
            public void onFinish() {
                txtTiempo.setText("Fuera de tiempo!");
            }
        }.start();

        String mp3File = "raw/survivor_eyeofthetiger.mp3";
        AssetManager assetMan = getAssets();
        MediaPlayer media = new MediaPlayer();
        FileInputStream mp3Stream = null;
        try {
            mp3Stream = assetMan.openFd(mp3File).createInputStream();
            media.setDataSource(mp3Stream.getFD());
            media.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        media.start();
    }

    public void onFragmentInteraction(String resultado) {
        if(resultado.equals(questions.get(contador).getCorrecta())) {
            Toast.makeText(this,"Has acertado hulio",Toast.LENGTH_LONG).show();
            progreso++;
            contador++;
        }
        else{
            Toast.makeText(this,"Un mojón pa ti",Toast.LENGTH_LONG).show();
            contador++;
        }
    }
}
