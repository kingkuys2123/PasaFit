package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ExercisesCategories extends AppCompatActivity {

    private ImageButton btn_exercise_list_balance_next, btn_exercise_list_strength_next, btn_exercise_list_endurance_next, btn_exercise_list_flexibility_next, nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile;

    private Button btnBackExerciseCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_categories);

        init();

        btn_exercise_list_endurance_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExercisesCategories.this, ExerciseList.class);

                intent.putExtra("exercise_type_key", "Endurance");

                startActivity(intent);
            }
        });

        btn_exercise_list_flexibility_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExercisesCategories.this, ExerciseList.class);

                intent.putExtra("exercise_type_key", "Flexibility");

                startActivity(intent);

            }
        });

        btn_exercise_list_strength_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExercisesCategories.this, ExerciseList.class);

                intent.putExtra("exercise_type_key", "Strength");

                startActivity(intent);
            }
        });

        btn_exercise_list_balance_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExercisesCategories.this, ExerciseList.class);

                intent.putExtra("exercise_type_key", "Balance");

                startActivity(intent);
            }
        });

        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesCategories.this, Dashboard.class);

                startActivity(intent);
            }
        });

        nav_btn_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesCategories.this, Tracker.class);

                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesCategories.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        nav_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesCategories.this, UserProfile.class);

                startActivity(intent);
            }
        });

        btnBackExerciseCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }

    public void init(){
        btn_exercise_list_balance_next = findViewById(R.id.btn_exercise_list_balance_next);
        btn_exercise_list_strength_next = findViewById(R.id.btn_exercise_list_strength_next);
        btn_exercise_list_endurance_next = findViewById(R.id.btn_exercise_list_endurance_next);
        btn_exercise_list_flexibility_next = findViewById(R.id.btn_exercise_list_flexibility_next);

        nav_btn_home = findViewById(R.id.nav_btn_home_exercise_categories);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_exercise_categories);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_exercise_categories);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_exercise_categories);

        btnBackExerciseCategories = findViewById(R.id.btnBackExerciseCategories);
    }
}