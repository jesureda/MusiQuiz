package com.example.jsureda.musiquiz;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;

public class Preguntas extends AppCompatActivity
        implements FragBotones.OnFragmentInteractionListener {
    TextView txtTiempo;
    ImageButton player;
    ArrayList<Pregunta> questions = new ArrayList<>();
    private DatabaseHelper pregSQLite = null;
    int nivel, progresoInicial, contador = 0, progreso = 0;
    MediaPlayer media = null;
    CountDownTimer tiempo;
    boolean sonido,tema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tema = getIntent().getBooleanExtra("tema", true);
        if (tema) {
            setTheme(R.style.AppTheme);
        } else {setTheme(R.style.AppTheme2);}
        setContentView(R.layout.activity_preguntas);
        sonido = getIntent().getBooleanExtra("sonido", true);
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
            progreso++;
        }
        contador++;
        media.stop();
        media.release();
        tiempo.cancel();
        if (contador < 10) {
            temporizador();
            openFragment();
        } else {
            Intent intent = new Intent(Preguntas.this, Resumen.class);
            intent.putExtra("progresoRonda", progreso);
            intent.putExtra("nivelSel", nivel);
            intent.putExtra("progresoInicial", progresoInicial);
            intent.putExtra("tema", tema);
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
        bundle.putBoolean("sonido",sonido);
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
        tiempo = new CountDownTimer(20000, 1000) {
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText(getString(R.string.labelTiempo)+ millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                txtTiempo.setText(R.string.labelFueraTiempo);
                if (txtTiempo.getText().equals(getString(R.string.labelFueraTiempo)))
                {
                    contador++;
                    media.stop();
                    media.release();
                    tiempo.cancel();
                    if (contador < 10) {
                        temporizador();
                        openFragment();
                    } else {
                        Intent intent = new Intent(Preguntas.this, Resumen.class);
                        intent.putExtra("progresoRonda", progreso);
                        intent.putExtra("nivelSel", nivel);
                        intent.putExtra("progresoInicial", progresoInicial);
                        intent.putExtra("tema", tema);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        }.start();
    }

    private void playSound(final Context ctx, String fileName) {
        media = new MediaPlayer();
        try {
            if (fileName.contains("mp3")) {
                AssetFileDescriptor afd = ctx.getAssets().openFd(fileName);
                media.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                afd.close();
            } else {
                media.setDataSource(ctx, Uri.parse(fileName));
            }
            media.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        media.start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Preguntas.this, ListaNiveles.class);
        startActivity(intent);
        finish();
    }
}
