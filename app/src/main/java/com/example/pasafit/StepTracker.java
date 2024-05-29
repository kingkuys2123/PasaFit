package com.example.pasafit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StepTracker extends AppCompatActivity {

    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;
    private Button btnBackStepTracker, btnStartStepTracker, btnRestartStepTracker;
    private TextView stepCountView, stepsLabelView, distanceMilesView, durationMinutesView, caloriesBurnedView;

    private int stepCount = 0;
    private boolean isTracking = false;
    private Handler handler = new Handler();
    private Runnable stepCounterRunnable;
    private long startTime;

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

        btnStartStepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isTracking) {
                    isTracking = true;
                    btnStartStepTracker.setText("Pause");
                    btnRestartStepTracker.setVisibility(View.VISIBLE);
                    startTime = System.currentTimeMillis();
                    startStepCounter();
                } else {
                    isTracking = false;
                    btnStartStepTracker.setText("Start");
                    handler.removeCallbacks(stepCounterRunnable);
                }
            }
        });

        btnRestartStepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stepCount = 0;
                startTime = System.currentTimeMillis();
                updateUI();
                if (isTracking) {
                    handler.removeCallbacks(stepCounterRunnable);
                    startStepCounter();
                }
            }
        });
    }

    private void init() {
        btnBackStepTracker = findViewById(R.id.btnBackStepTracker);
        nav_btn_home = findViewById(R.id.nav_btn_home_step_tracker);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_step_tracker);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_step_tracker);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_step_tracker);
        nav_btn_exercises = findViewById(R.id.nav_btn_exercise_step_tracker);

        stepCountView = findViewById(R.id.step_count_step_tracker);
        stepsLabelView = findViewById(R.id.steps_label);
        distanceMilesView = findViewById(R.id.distance_miles_step_tracker);
        durationMinutesView = findViewById(R.id.duration_minutes_step_tracker);
        caloriesBurnedView = findViewById(R.id.calories_burned_step_tracker);

        btnStartStepTracker = findViewById(R.id.btnStartStepTracker);
        btnRestartStepTracker = findViewById(R.id.btnRestartStepTracker);
    }

    private void startStepCounter() {
        stepCounterRunnable = new Runnable() {
            @Override
            public void run() {
                if (isTracking) {
                    stepCount++;
                    updateUI();
                    handler.postDelayed(this, 1000);
                }
            }
        };
        handler.post(stepCounterRunnable);
    }

    private void updateUI() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        long elapsedMinutes = elapsedTime / 60000;

        stepCountView.setText(String.valueOf(stepCount));
        distanceMilesView.setText("Miles: " + String.format("%.2f", stepCount * 0.0005));
        durationMinutesView.setText("Min: " + elapsedMinutes);
        caloriesBurnedView.setText("Kcal: " + (int) (stepCount * 0.04));
    }
}
