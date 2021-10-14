package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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


            //TODO: kepValtakozas();


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
                    kepBeallitas(randomSzam, elsoImageView);
                } else {
                    int randomSzam = (int)(Math.random() * 6) + 1;
                    sor += randomSzam + ")\n";
                    osszeg += randomSzam;
                    dobasokSzoveg += osszeg + sor;
                    kepBeallitas(randomSzam, masodikImageView);
                }
            }
            Toast.makeText(MainActivity.this, osszeg + "", Toast.LENGTH_SHORT).show();
            textView.setText(dobasokSzoveg);
        });

        resetButton.setOnClickListener(view -> {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
            alertBuilder.setTitle("Reset");
            alertBuilder.setMessage("Biztos, hogy törölni szeretné az eddigi dobásokat?");
            alertBuilder.setMessage("Szeretne új játékot játszani?");
            alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    closeContextMenu();
                }
            });
            alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ujJatek();
                    closeContextMenu();
                }
            });
            alertBuilder.create().show();
        });
    }

    private void ujJatek() {
        dobasokSzoveg = "";
        textView.setText("");
        elsoImageView.setImageResource(R.drawable.kocka1);
        masodikImageView.setImageResource(R.drawable.kocka1);
        masodikImageView.setVisibility(View.VISIBLE);
    }

    public void kepValtakozas() {
        int[] imageArray = {
                R.drawable.kocka1,
                R.drawable.kocka2,
                R.drawable.kocka3,
                R.drawable.kocka4,
                R.drawable.kocka5,
                R.drawable.kocka6,
        };
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = (int)Math.random() * 6 + 1;

            public void run() {
                elsoImageView.setImageResource(imageArray[i]);
                masodikImageView.setImageResource(imageArray[i]);
                i++;
                if (i > imageArray.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 200);
            }
        };
        handler.postDelayed(runnable, 200);
    }

    private void kepBeallitas(int randomSzam, ImageView imegeView) {

        switch (randomSzam) {
            case 1:
                imegeView.setImageResource(R.drawable.kocka1);
                break;
            case 2:
                imegeView.setImageResource(R.drawable.kocka2);
                break;
            case 3:
                imegeView.setImageResource(R.drawable.kocka3);
                break;
            case 4:
                imegeView.setImageResource(R.drawable.kocka4);
                break;
            case 5:
                imegeView.setImageResource(R.drawable.kocka5);
                break;
            case 6:
                imegeView.setImageResource(R.drawable.kocka6);
                break;
        }
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