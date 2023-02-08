package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView quiz;
    TextView choose;
    Button gk,verbal,nonVerbal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quiz=findViewById(R.id.quiz);
        choose=findViewById(R.id.choose);
       gk= findViewById(R.id.gk);
        verbal=findViewById(R.id.verbal);
        nonVerbal=findViewById(R.id.nonVerbal);

        gk.setOnClickListener(view -> {
            Intent it=new Intent(MainActivity.this,secondActivity.class);
            startActivity(it);

        });

        verbal.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,thirdActivity.class);
            startActivity(intent);
        });

        nonVerbal.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,fourthActivity.class);
            startActivity(intent);
        });
    }
}