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
            masodikImageView.setVisibility(View.GONE);

            lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg = false;
        });
        kockaKettoButton.setOnClickListener(view -> {
            masodikImageView.setVisibility(View.VISIBLE);
            lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg = true;
        });
        dobasButton.setOnClickListener(view -> {
            String sor = "";
            int osszeg = 0;
            int hanyszor = 1;
            if (lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg) {
                hanyszor = 2;
            }
            for (int i = 0; i < hanyszor; i++) {
                if (i == 0) {
                    int randomSzam = (int)(Math.random() * 6) + 1;
                    if (!lathatoEMindAKettoKepAmelyikADobokockatJelenitiMeg) {
                        dobasokSzoveg += randomSzam + "\n";
                    }
                    osszeg += randomSzam;
                    sor += " (" + randomSzam + "+";
                    switch (randomSzam) {
                        case 1:
                            elsoImageView.setImageResource(R.drawable.kocka1);
                            break;
                        case 2:
                            elsoImageView.setImageResource(R.drawable.kocka2);
                            break;
                        case 3:
                            elsoImageView.setImageResource(R.drawable.kocka3);
                            break;
                        case 4:
                            elsoImageView.setImageResource(R.drawable.kocka4);
                            break;
                        case 5:
                            elsoImageView.setImageResource(R.drawable.kocka5);
                            break;
                        case 6:
                            elsoImageView.setImageResource(R.drawable.kocka6);
                            break;
                    }
                } else {
                    int randomSzam = (int)(Math.random() * 6) + 1;
                    sor += randomSzam + ")\n";
                    osszeg += randomSzam;
                    dobasokSzoveg += osszeg + sor;
                    switch (randomSzam) {
                        case 1:
                            masodikImageView.setImageResource(R.drawable.kocka1);
                            break;
                        case 2:
                            masodikImageView.setImageResource(R.drawable.kocka2);
                            break;
                        case 3:
                            masodikImageView.setImageResource(R.drawable.kocka3);
                            break;
                        case 4:
                            masodikImageView.setImageResource(R.drawable.kocka4);
                            break;
                        case 5:
                            masodikImageView.setImageResource(R.drawable.kocka5);
                            break;
                        case 6:
                            masodikImageView.setImageResource(R.drawable.kocka6);
                            break;
                    }
                }
            }
            textView.setText(dobasokSzoveg);
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