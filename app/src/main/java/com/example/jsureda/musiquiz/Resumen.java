package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;
    int progresoRonda, progresoInicial, nivel;
    private DatabaseHelper resSQLite=null;
    TextView txtAcierto,txtFallo,txtResult;
    boolean tema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tema = getIntent().getBooleanExtra("tema", true);
        if (tema) {
            setTheme(R.style.AppTheme);
        } else {setTheme(R.style.AppTheme2);}
        setContentView(R.layout.activity_resumen);
        txtAcierto = (TextView) findViewById(R.id.txtAcierto);
        txtFallo = (TextView) findViewById(R.id.txtFallo);
        txtResult = (TextView) findViewById(R.id.txtResultado);
        resSQLite = new DatabaseHelper(this);
        nivel = getIntent().getIntExtra("nivelSel", 0);
        progresoInicial=getIntent().getIntExtra("progresoInicial", 0);
        progresoRonda=getIntent().getIntExtra("progresoRonda", 0);

        if (progresoInicial<=progresoRonda)
        {
            resSQLite.actualizarNivel(nivel, 0, progresoRonda);
            if ((progresoRonda>7) && (nivel<4)){
                nivel++;
                resSQLite.actualizarNivel(nivel, 0, 0);
                txtResult.setText(R.string.labelSuperado);
            }
            else{
                txtResult.setText(R.string.labelNoSuperado);
            }
        }

        txtAcierto.setText(progresoRonda+" "+getString(R.string.labelAciertos));
        txtFallo.setText((10-progresoRonda)+" "+getString(R.string.labelFallos));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    Intent intent = new Intent(Resumen.this, ListaNiveles.class);
                    intent.putExtra("tema", tema);
                    startActivity(intent);
                    finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
