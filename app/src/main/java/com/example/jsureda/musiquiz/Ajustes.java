package com.example.jsureda.musiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

public class Ajustes extends PreferenceActivity {

    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
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
        fab=(FloatingActionButton)findViewById(R.id.fabAjuste);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Ajustes.this, Principal.class);
        startActivity(intent);
        finish();
    }
}
