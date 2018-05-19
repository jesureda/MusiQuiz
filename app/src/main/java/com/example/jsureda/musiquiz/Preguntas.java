package com.example.jsureda.musiquiz;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Preguntas extends AppCompatActivity implements FragBotones.OnFragmentInteractionListener {
    TextView txtTiempo;
    ImageButton player;
    FragBotones botones = new FragBotones();
    ArrayList<Pregunta> questions = new ArrayList<>();
    private DatabaseHelper pregSQLite = null;
    int nivel, progresoInicial, contador = 0, progreso = 0;
    MediaPlayer media = null;
    CountDownTimer tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        nivel = getIntent().getIntExtra("nivelSel", 0);
        progresoInicial = getIntent().getIntExtra("progresoInicial", 0);
        pregSQLite = new DatabaseHelper(this);
        questions = pregSQLite.listaPreguntas(10, nivel);
        temporizador();
        openFragment();
        txtTiempo = (TextView) findViewById(R.id.txtTime);
        player = (ImageButton) findViewById(R.id.imageButton);
        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                media.seekTo(0);
                media.start();
            }
        });
    }

    public void onFragmentInteraction(String resultado) {
        if (resultado.equals(questions.get(contador).getCorrecta())) {
            //Toast.makeText(this, "Has acertado hulio", Toast.LENGTH_LONG).show();
            progreso++;
        }
        contador++;
        media.stop();
        tiempo.cancel();
        if (contador < 10) {
            temporizador();
            openFragment();
        } else {
            Intent intent = new Intent(Preguntas.this, Resumen.class);
            intent.putExtra("progresoRonda", progreso);
            intent.putExtra("nivelSel", nivel);
            intent.putExtra("progresoInicial", progresoInicial);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        media.stop();
    }

    private void openFragment() {
        FragBotones botones = new FragBotones();

        Bundle bundle = new Bundle();
        bundle.putString("enunciado", questions.get(contador).getEnunciado());
        bundle.putString("resA", questions.get(contador).getRespuestaA());
        bundle.putString("resB", questions.get(contador).getRespuestaB());
        bundle.putString("resC", questions.get(contador).getRespuestaC());
        bundle.putString("resD", questions.get(contador).getRespuestaD());
        bundle.putString("resCorr", questions.get(contador).getCorrecta());
        botones.setArguments(bundle);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frBotones, botones);
        transaction.commit();
        playSound(this, questions.get(contador).getRefAudio());
    }

    private void temporizador() {
        tiempo = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Tiempo restante: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                txtTiempo.setText("Fuera de tiempo!");
            }
        }.start();
    }

    private void playSound(final Context ctx, String fileName) {
        media = new MediaPlayer();
        try {
            AssetFileDescriptor afd = ctx.getAssets().openFd(fileName);
            media.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            media.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        media.start();
    }
}
