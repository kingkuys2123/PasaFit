package com.example.pasafit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SleepTracker extends AppCompatActivity {

    private Button btnBackSleepTracker;
    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracker);

        init();

        btnBackSleepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, Dashboard.class);

                startActivity(intent);
            }
        });

        nav_btn_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, Tracker.class);

                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        nav_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, UserProfile.class);

                startActivity(intent);
            }
        });

        nav_btn_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, ExercisesCategories.class);

                startActivity(intent);
            }
        });
    }

    private void init(){
        btnBackSleepTracker = findViewById(R.id.btnBackSleepTracker);

        nav_btn_home = findViewById(R.id.nav_btn_home_sleep_tracker);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_sleep_tracker);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_sleep_tracker);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_sleep_tracker);
        nav_btn_exercises = findViewById(R.id.nav_btn_exercise_sleep_tracker);

    }
}