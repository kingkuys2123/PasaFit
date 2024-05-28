package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ExerciseList extends AppCompatActivity {

    private TextView textViewExerciseListHeader;

    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;

    private Button btnBackExerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        init();

        Intent intent = getIntent();

        String exercise_type = intent.getStringExtra("exercise_type_key");

        textViewExerciseListHeader.setText(exercise_type + " Exercises");

        btnBackExerciseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseList.this, Dashboard.class);

                startActivity(intent);
            }
        });

        nav_btn_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseList.this, Tracker.class);

                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseList.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        nav_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseList.this, UserProfile.class);

                startActivity(intent);
            }
        });

        nav_btn_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExerciseList.this, ExercisesCategories.class);

                startActivity(intent);
            }
        });

    }

    public void init(){
        textViewExerciseListHeader = findViewById(R.id.textViewExerciseListHeader);
        btnBackExerciseList = findViewById(R.id.btnBackExerciseList);

        nav_btn_home = findViewById(R.id.nav_btn_home_exercise_list);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_exercise_list);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_exercise_list);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_exercise_list);
        nav_btn_exercises = findViewById(R.id.nav_btn_exercises_exercise_list);
    }
}