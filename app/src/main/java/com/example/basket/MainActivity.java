package com.example.basket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView marcadorA, marcadorB;
    PuntuacionViewModel puntuacionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        puntuacionViewModel = ViewModelProviders.of(MainActivity.this).get(PuntuacionViewModel.class);

        marcadorA = findViewById(R.id.marcadorA);
        marcadorB = findViewById(R.id.marcadorB);

        findViewById(R.id.A1).setOnClickListener(this);
        findViewById(R.id.A2).setOnClickListener(this);
        findViewById(R.id.A3).setOnClickListener(this);
        findViewById(R.id.B1).setOnClickListener(this);
        findViewById(R.id.B2).setOnClickListener(this);
        findViewById(R.id.B3).setOnClickListener(this);
        findViewById(R.id.reset).setOnClickListener(this);

        update();
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.A1 : puntuacionViewModel.puntosA += 1; break;
            case R.id.A2 : puntuacionViewModel.puntosA += 2; break;
            case R.id.A3 : puntuacionViewModel.puntosA += 3; break;
            case R.id.B1 : puntuacionViewModel.puntosB += 1; break;
            case R.id.B2 : puntuacionViewModel.puntosB += 2; break;
            case R.id.B3 : puntuacionViewModel.puntosB += 3; break;
            case R.id.reset : puntuacionViewModel.puntosA = 0; puntuacionViewModel.puntosB = 0; break;
        }
        update();
    }

    void update(){
        marcadorA.setText(String.valueOf(puntuacionViewModel.puntosA));
        marcadorB.setText(String.valueOf(puntuacionViewModel.puntosB));
    }

}
