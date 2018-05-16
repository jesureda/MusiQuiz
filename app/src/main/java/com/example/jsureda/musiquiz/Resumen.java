package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        TextView txtProgreso = (TextView) findViewById(R.id.txtProgre);
        txtProgreso.setText("Aciertos: "+getIntent().getIntExtra("prog", 0));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent intent = new Intent(Resumen.this, Principal.class);
                    startActivity(intent);
                    finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
