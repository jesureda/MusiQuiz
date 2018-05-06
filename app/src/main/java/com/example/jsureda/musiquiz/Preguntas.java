package com.example.jsureda.musiquiz;

import android.os.CountDownTimer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Preguntas extends AppCompatActivity {
    TextView txtTiempo;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragBotones botones = new FragBotones();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        txtTiempo = (TextView)findViewById(R.id.txtTime);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frBotones, botones);
        fragmentTransaction.commit();
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                txtTiempo.setText("Tiempo restante: " + millisUntilFinished / 1000);
                //here you can have your logic to set text to edittext
            }
            public void onFinish() {
                txtTiempo.setText("Fuera de tiempo!");
            }
        }.start();
    }
}
