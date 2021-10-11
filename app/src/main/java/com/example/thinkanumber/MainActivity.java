package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView elsoImageView, masodikImageView;
    private Button kockaEgyButton, kockaKettoButton, dobasButton, resetButton;
    private TextView textView;
    private String dobasokSzoveg;
    private Boolean lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        kockaEgyButton.setOnClickListener(view -> {
            kockaKettoButton.setVisibility(View.INVISIBLE);
            lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg = false;
        });
        kockaKettoButton.setOnClickListener(view -> {
            kockaKettoButton.setVisibility(View.VISIBLE);
            lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg = true;
        });
        dobasButton.setOnClickListener(view -> {
            if (lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg) {

            }
        });
    }

    private void init() {
        elsoImageView = findViewById(R.id.elsoImageView);
        masodikImageView = findViewById(R.id.masodikImageView);
        kockaEgyButton = findViewById(R.id.kockaEgyButton);
        kockaKettoButton = findViewById(R.id.kockaKettoButton);
        dobasButton = findViewById(R.id.dobasButton);
        resetButton = findViewById(R.id.resetButton);
        textView = findViewById(R.id.textView);
        dobasokSzoveg = "";
        lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg = true;
    }
}