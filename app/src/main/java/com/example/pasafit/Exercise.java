package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Exercise extends AppCompatActivity {

    Button btnBackExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        init();

        btnBackExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Exercise.this, ExerciseList.class);
                startActivity(intent);
            }
        });

    }

    public void init(){
        btnBackExercise = findViewById(R.id.btnBackExercise);
    }
}