package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ViewExercise extends AppCompatActivity {

    Button btnBackExercise;

    ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        init();

        btnBackExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewExercise.this, ExerciseList.class);
                startActivity(intent);
            }
        });

        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewExercise.this, Dashboard.class);

                startActivity(intent);
            }
        });

        nav_btn_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewExercise.this, Tracker.class);

                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewExercise.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        nav_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewExercise.this, UserProfile.class);

                startActivity(intent);
            }
        });

        nav_btn_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewExercise.this, ExercisesCategories.class);

                startActivity(intent);
            }
        });

    }

    public void init(){
        btnBackExercise = findViewById(R.id.btnBackExerciseUserProfile);

        nav_btn_home = findViewById(R.id.nav_btn_home_view_exercise);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_view_exercise);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_view_exercise);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_view_exercise);
        nav_btn_exercises = findViewById(R.id.nav_btn_exercise_view_exercise);

    }
}