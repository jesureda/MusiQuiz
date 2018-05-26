package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Sesion extends AppCompatActivity {
    private SharedPreferences prefs;
    EditText txtUsuario;
    Button btnEntrar;
    ProgressBar barra;
    int carga;
    int time=2000;
    int timePassed=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        inicializarGUI();
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUsuario.length()>3){
                    prefs = PreferenceManager
                            .getDefaultSharedPreferences(Sesion.this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("UserLoggedIn", true);
                    editor.commit();
                    barra.setVisibility(View.VISIBLE);
                    barra.setProgress(carga);

                    new CountDownTimer(time, 200) {

                        public void onTick(long millisUntilFinished) {
                        timePassed=time-(int)millisUntilFinished;
                            carga = (timePassed/ 20);
                            barra.setProgress(carga);
                        }
                        public void onFinish() {
                            Intent intent = new Intent(getApplicationContext(), Principal.class);
                            startActivity(intent);
                            finish();
                        }
                    }.start();
                }
                else {
                    Toast.makeText(Sesion.this, "Introduce un usuario de al menos 4 caracteres", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void inicializarGUI()
    {
        barra = (ProgressBar) findViewById(R.id.progLog);
        txtUsuario = (EditText) findViewById(R.id.txtUserSesion);
        btnEntrar = (Button) findViewById(R.id.btnEntrarSesion);
        barra.setVisibility(View.INVISIBLE);
    }
}
