package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    int progresoRonda, progresoInicial, nivel;
    private DatabaseHelper resSQLite=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        TextView txtProgreso = (TextView) findViewById(R.id.txtProgre);
        resSQLite = new DatabaseHelper(this);
        nivel = getIntent().getIntExtra("nivelSel", 0);
        progresoInicial=getIntent().getIntExtra("progresoInicial", 0);
        progresoRonda=getIntent().getIntExtra("progresoRonda", 0);

        if (progresoInicial<=progresoRonda)
        {
            resSQLite.actualizarNivel(nivel, 0, progresoRonda);
            if ((progresoRonda>7) && (nivel<5)){
                nivel++;
                resSQLite.actualizarNivel(nivel, 0, 0);
            }
        }

        txtProgreso.setText("Aciertos: "+progresoRonda);
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
