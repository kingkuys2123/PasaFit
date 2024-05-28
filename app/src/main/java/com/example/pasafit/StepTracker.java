package com.example.pasafit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class StepTracker extends AppCompatActivity {

    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;
    private Button btnBackStepTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_tracker);

        init();

        btnBackStepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StepTracker.this, Dashboard.class);

                startActivity(intent);
            }
        });

        nav_btn_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StepTracker.this, Tracker.class);

                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StepTracker.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        nav_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StepTracker.this, UserProfile.class);

                startActivity(intent);
            }
        });

        nav_btn_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StepTracker.this, ExercisesCategories.class);

                startActivity(intent);
            }
        });
    }

    private void init(){
        btnBackStepTracker = findViewById(R.id.btnBackStepTracker);

        nav_btn_home = findViewById(R.id.nav_btn_home_step_tracker);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_step_tracker);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_step_tracker);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_step_tracker);
        nav_btn_exercises = findViewById(R.id.nav_btn_exercise_step_tracker);
    }
}