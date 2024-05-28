package com.example.pasafit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Tracker extends AppCompatActivity {

    Button btnTrackerStepTracker, btnTrackerSleepTracker;
    ImageButton btnBackTrackers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        init();

        btnTrackerStepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracker.this, StepTracker.class);
                startActivity(intent);
            }
        });

        btnTrackerSleepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracker.this, SleepTracker.class);
                startActivity(intent);
            }
        });

        btnBackTrackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    private void init(){
        btnTrackerStepTracker = findViewById(R.id.btnTrackerStepTracker);
        btnTrackerSleepTracker = findViewById(R.id.btnTrackerStepTracker);
    }
}