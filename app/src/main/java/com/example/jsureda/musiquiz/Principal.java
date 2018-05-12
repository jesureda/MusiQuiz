package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    boolean exit = false;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FragLogo logo = new FragLogo();
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
            }
        });
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ranking.class);
                startActivity(intent);
            }
        });
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaNiveles.class);
                startActivity(intent);
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
        btnSalir = (ImageButton) findViewById(R.id.imgBtnSalir);
        btnRanking = (ImageButton) findViewById(R.id.imgBtnRanking);
        btnAjustes = (ImageButton) findViewById(R.id.imgBtnAjustes);
        btnJugar = (Button)findViewById(R.id.btnJugar);
    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
            System.exit(0);
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
