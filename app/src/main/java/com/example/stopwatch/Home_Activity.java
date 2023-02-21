package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class Home_Activity extends AppCompatActivity {

    private boolean isRunning=false;
    private long pauseoffset = 0;

    ImageView btn_push;
    ImageView btn_stop;
    ImageView btn_start;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_push = findViewById(R.id.btn_push);
        btn_stop = findViewById(R.id.btn_stop);
        btn_start = findViewById(R.id.btn_start);
        chronometer = findViewById(R.id.chronometer);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning){
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset );
                    chronometer.start();
                    isRunning = true;
                }

            }
        });
        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning)
                {
                    chronometer.stop();
                    pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    isRunning = false;
                }
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.stop();
                pauseoffset = 0;
                isRunning = false;
            }
        });
    }
}