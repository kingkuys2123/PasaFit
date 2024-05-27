package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.firestore.auth.User;

public class ExercisesCategories extends AppCompatActivity {

    ImageButton btn_exercise_list_balance_next, btn_exercise_list_strength_next, btn_exercise_list_endurance_next, btn_exercise_list_flexibility_next, btn_exercise_category_home, btn_exercise_category_trackers, btn_exercise_category_calculator, btn_exercise_category_profile;

    Button btnBackExerciseCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_categories);

        initBtns();

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

        btn_exercise_category_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesCategories.this, Dashboard.class);

                startActivity(intent);
            }
        });

        btn_exercise_category_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesCategories.this, Tracker.class);

                startActivity(intent);
            }
        });

        btn_exercise_category_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExercisesCategories.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        btn_exercise_category_profile.setOnClickListener(new View.OnClickListener() {
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

    public void initBtns(){
        btn_exercise_list_balance_next = findViewById(R.id.btn_exercise_list_balance_next);
        btn_exercise_list_strength_next = findViewById(R.id.btn_exercise_list_strength_next);
        btn_exercise_list_endurance_next = findViewById(R.id.btn_exercise_list_endurance_next);
        btn_exercise_list_flexibility_next = findViewById(R.id.btn_exercise_list_flexibility_next);

        btn_exercise_category_home = findViewById(R.id.btn_exercise_category_home);
        btn_exercise_category_trackers = findViewById(R.id.btn_exercise_category_trackers);
        btn_exercise_category_calculator = findViewById(R.id.btn_exercise_category_calculator);
        btn_exercise_category_profile = findViewById(R.id.btn_exercise_category_profile);

        btnBackExerciseCategories = findViewById(R.id.btnBackExerciseCategories);
    }
}