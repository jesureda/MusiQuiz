package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
    private SharedPreferences prefs;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragLogo logo = new FragLogo();
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
                if (!txtUsuario.equals("")){
                    prefs = PreferenceManager
                            .getDefaultSharedPreferences(Sesion.this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putBoolean("UserLoggedIn", true);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), Principal.class);
                    startActivity(intent);
                    finish();
                };
            }
        });
    }
    private void inicializarGUI()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("id", R.drawable.musiquiz);
        logo.setArguments(bundle);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frLogo, logo);
        fragmentTransaction.commit();
        txtUsuario = (EditText) findViewById(R.id.txtUserSesion);
        txtClave = (EditText) findViewById(R.id.txtClaveSesion);
        btnEntrar = (Button) findViewById(R.id.btnEntrarSesion);
        txtClave.setEnabled(false);
    }

}
