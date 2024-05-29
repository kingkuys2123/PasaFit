package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseList extends AppCompatActivity {

    private TextView textViewExerciseListHeader;
    private TextView exerciseListTitle1, exerciseListTitle2, exerciseListTitle3, exerciseListTitle4, exerciseListTitle5;

    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;
    private ImageView exerciseListImage1, exerciseListImage2, exerciseListImage3, exerciseListImage4, exerciseListImage5;

    private Button btnBackExerciseList, btnExerciseListNext1, btnExerciseListNext2, btnExerciseListNext3, btnExerciseListNext4, btnExerciseListNext5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        init();

        Intent intent = getIntent();

        String exercise_type = intent.getStringExtra("exercise_type_key");

        textViewExerciseListHeader.setText(exercise_type + " Exercises");

        if ("Balance".equals(exercise_type)) {
            exerciseListTitle1.setText("Bird Dog");
            exerciseListTitle2.setText("Lying Leg Raise");
            exerciseListTitle3.setText("Single Leg Balance");
            exerciseListTitle4.setText("Toe Taps");
            exerciseListTitle5.setText("Tree Pose");

            exerciseListImage1.setImageResource(R.drawable.balance_bird_dog);
            exerciseListImage2.setImageResource(R.drawable.balance_lying_leg_raise);
            exerciseListImage3.setImageResource(R.drawable.balance_single_leg_balance);
            exerciseListImage4.setImageResource(R.drawable.balance_toe_taps);
            exerciseListImage5.setImageResource(R.drawable.balance_tree_pose);
        }
        else if("Endurance".equals(exercise_type)){
            exerciseListTitle1.setText("Crunch");
            exerciseListTitle2.setText("Lunge");
            exerciseListTitle3.setText("Plank");
            exerciseListTitle4.setText("Push-up");
            exerciseListTitle5.setText("Squat");

            exerciseListImage1.setImageResource(R.drawable.endurance_crunch);
            exerciseListImage2.setImageResource(R.drawable.endurance_lunge);
            exerciseListImage3.setImageResource(R.drawable.endurance_plank);
            exerciseListImage4.setImageResource(R.drawable.endurance_push_up);
            exerciseListImage5.setImageResource(R.drawable.endurance_squat);

        }
        else if("Flexibility".equals(exercise_type)){
            exerciseListTitle1.setText("Cat Cow");
            exerciseListTitle2.setText("Groin Sretch");
            exerciseListTitle3.setText("Hip Flexor Stretch");
            exerciseListTitle4.setText("Side Lunge Stretch");
            exerciseListTitle5.setText("Standing Biceps Stretch");

            exerciseListImage1.setImageResource(R.drawable.flexibility_cat_cow);
            exerciseListImage2.setImageResource(R.drawable.flexibility_groin_stretch);
            exerciseListImage3.setImageResource(R.drawable.flexibility_hip_flexor_stretch);
            exerciseListImage4.setImageResource(R.drawable.flexibility_side_lunge_stretch);
            exerciseListImage5.setImageResource(R.drawable.flexibility_standing_bicep_stretch);
        }
        else if("Strength".equals(exercise_type)){
            exerciseListTitle1.setText("Bicep Curl");
            exerciseListTitle2.setText("Calf Raises");
            exerciseListTitle3.setText("Dumbell Floor Press");
            exerciseListTitle4.setText("Overhead Triceps Extension");
            exerciseListTitle5.setText("Wall Push-up");

            exerciseListImage1.setImageResource(R.drawable.strength_bicep_curl);
            exerciseListImage2.setImageResource(R.drawable.strength_calf_raises);
            exerciseListImage3.setImageResource(R.drawable.strength_dumbell_floor_press);
            exerciseListImage4.setImageResource(R.drawable.strength_overhead_triceps_extension);
            exerciseListImage5.setImageResource(R.drawable.strength_wall_push_up);

        }

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

        btnExerciseListNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Balance".equals(exercise_type)) {
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "bird_dog");

                    startActivity(intent);
                }
                else if("Endurance".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "crunch");

                    startActivity(intent);
                }
                else if("Flexibility".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "cat_cow");

                    startActivity(intent);
                }
                else if("Strength".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "bicep_curl");

                    startActivity(intent);
                }
            }
        });

        btnExerciseListNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Balance".equals(exercise_type)) {
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "lying_leg_raise");

                    startActivity(intent);
                }
                else if("Endurance".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "lunge");

                    startActivity(intent);
                }
                else if("Flexibility".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "groin_stretch");

                    startActivity(intent);
                }
                else if("Strength".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "calf_raises");

                    startActivity(intent);
                }
            }
        });

        btnExerciseListNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Balance".equals(exercise_type)) {
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "single_leg_balance");

                    startActivity(intent);
                }
                else if("Endurance".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "plank");

                    startActivity(intent);
                }
                else if("Flexibility".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "hip_flexor_stretch");

                    startActivity(intent);
                }
                else if("Strength".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "dumbell_floor_press");

                    startActivity(intent);
                }
            }
        });

        btnExerciseListNext4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Balance".equals(exercise_type)) {
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "toe_taps");

                    startActivity(intent);
                }
                else if("Endurance".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "push_up");

                    startActivity(intent);
                }
                else if("Flexibility".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "side_lunge_stretch");

                    startActivity(intent);
                }
                else if("Strength".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "overhead_triceps_extension");

                    startActivity(intent);
                }
            }
        });

        btnExerciseListNext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("Balance".equals(exercise_type)) {
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "tree_pose");

                    startActivity(intent);
                }
                else if("Endurance".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "squat");

                    startActivity(intent);
                }
                else if("Flexibility".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "standing_biceps_stretch");

                    startActivity(intent);
                }
                else if("Strength".equals(exercise_type)){
                    Intent intent = new Intent(ExerciseList.this, ViewExercise.class);

                    intent.putExtra("exercise_title", "wall_push_up");

                    startActivity(intent);
                }
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

        exerciseListTitle1 = findViewById(R.id.exerciseListTitle1);
        exerciseListTitle2 = findViewById(R.id.exerciseListTitle2);
        exerciseListTitle3 = findViewById(R.id.exerciseListTitle3);
        exerciseListTitle4 = findViewById(R.id.exerciseListTitle4);
        exerciseListTitle5 = findViewById(R.id.exerciseListTitle5);

        exerciseListImage1 = findViewById(R.id.exerciseListImage1);
        exerciseListImage2 = findViewById(R.id.exerciseListImage2);
        exerciseListImage3 = findViewById(R.id.exerciseListImage3);
        exerciseListImage4 = findViewById(R.id.exerciseListImage4);
        exerciseListImage5 = findViewById(R.id.exerciseListImage5);

        btnExerciseListNext1 = findViewById(R.id.btnExerciseListNext1);
        btnExerciseListNext2 = findViewById(R.id.btnExerciseListNext2);
        btnExerciseListNext3 = findViewById(R.id.btnExerciseListNext3);
        btnExerciseListNext4 = findViewById(R.id.btnExerciseListNext4);
        btnExerciseListNext5 = findViewById(R.id.btnExerciseListNext5);
    }
}