package com.example.pasafit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Tracker extends AppCompatActivity {

    private Button btnTrackerStepTracker, btnTrackerSleepTracker, btnBackTrackers;
    private ImageButton nav_btn_home, nav_btn_calculator, nav_btn_exercise, nav_btn_profile;

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



        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracker.this, Dashboard.class);

                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracker.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        nav_btn_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracker.this, ExercisesCategories.class);

                startActivity(intent);
            }
        });

        nav_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tracker.this, UserProfile.class);
                startActivity(intent);
            }
        });

    }

    private void init(){
        btnBackTrackers = findViewById(R.id.btnBackTrackers);
        btnTrackerStepTracker = findViewById(R.id.btnTrackerStepTracker);
        btnTrackerSleepTracker = findViewById(R.id.btnTrackerSleepTracker);

        nav_btn_home = findViewById(R.id.nav_btn_home_tracker);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_tracker);
        nav_btn_exercise = findViewById(R.id.nav_btn_exercise_tracker);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_tracker);
    }
}