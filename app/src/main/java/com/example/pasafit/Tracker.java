package com.example.pasafit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tracker extends AppCompatActivity {

    Button btnSleep, btnSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);


        btnSleep = findViewById(R.id.btnSleep);
        btnSteps = findViewById(R.id.btnSteps);

        btnSleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracker.this, SleepTracker.class);
                startActivity(intent);

            }
        });

        btnSteps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //himo pa stepTracker na activity
                Intent intent = new Intent(Tracker.this, StepTracker.class);
                startActivity(intent);


            }
        });
    }
}