package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExerciseList extends AppCompatActivity {

    TextView textViewExerciseListHeader;

    Button btnBackExerciseList;

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

    }

    public void init(){
        textViewExerciseListHeader = findViewById(R.id.textViewExerciseListHeader);
        btnBackExerciseList = findViewById(R.id.btnBackExerciseList);
    }
}