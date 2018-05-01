package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    boolean exit = false;
    ImageView img;
    ImageButton btnSalir, btnRanking, btnAjustes;
    Button btnJugar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inicializarGUI();
        btnAjustes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ajustes.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void inicializarGUI()
    {
        img = (ImageView) findViewById(R.id.imgPrincipal);
        btnSalir = (ImageButton) findViewById(R.id.imgBtnSalir);
        btnRanking = (ImageButton) findViewById(R.id.imgBtnRanking);
        btnAjustes = (ImageButton) findViewById(R.id.imgBtnAjustes);
        btnJugar = (Button)findViewById(R.id.btnJugar);
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, R.string.toastSalir,
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }
}
