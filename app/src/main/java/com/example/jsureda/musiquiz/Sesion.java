package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Sesion extends AppCompatActivity {
    ImageView img;
    EditText txtUsuario, txtClave;
    Button btnEntrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        inicializarGUI();
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Principal.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void inicializarGUI()
    {
        img = (ImageView) findViewById(R.id.imgSesion);
        txtUsuario = (EditText) findViewById(R.id.txtUserSesion);
        txtClave = (EditText) findViewById(R.id.txtClaveSesion);
        btnEntrar = (Button) findViewById(R.id.btnEntrarSesion);
    }

}
