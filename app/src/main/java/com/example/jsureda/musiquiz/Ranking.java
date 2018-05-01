package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ranking extends AppCompatActivity {
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        inicicializarGUI();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Principal.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void inicicializarGUI()
    {
        fab=(FloatingActionButton)findViewById(R.id.fabRanking);
    }
}
