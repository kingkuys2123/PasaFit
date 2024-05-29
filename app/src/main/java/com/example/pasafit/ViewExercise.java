package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewExercise extends AppCompatActivity {

    private Button btnBackViewExercise;
    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;
    private ImageView imageViewExercise;
    private TextView textViewHeadViewExercise, textViewDescriptionLowerExercise, textViewInstructionLowerExercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        init();

        Intent intent = getIntent();

        String exercise_title = intent.getStringExtra("exercise_title");

        if ("bird_dog".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.balance_bird_dog);
            textViewHeadViewExercise.setText("Bird Dog");
            textViewDescriptionLowerExercise.setText("The Bird Dog exercise is a core-strengthening move that enhances stability, balance, and coordination by engaging multiple muscle groups simultaneously.");
            textViewInstructionLowerExercise.setText("Start on your hands and knees, with your wrists under your shoulders and knees under your hips. Extend your right arm forward and left leg back, keeping your body in a straight line. Hold for a few seconds, then return to the starting position. Repeat on the opposite side. Perform 10-15 repetitions on each side.");
        }
        else if ("crunch".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.endurance_crunch);
            textViewHeadViewExercise.setText("Crunch");
            textViewDescriptionLowerExercise.setText("Crunches target the abdominal muscles and help in building core strength.");
            textViewInstructionLowerExercise.setText("Lie on your back with your knees bent and feet flat on the floor. Place your hands behind your head, elbows out. Lift your upper body towards your knees, engaging your abs. Lower back down without touching the ground. Perform 15-20 repetitions.");
        }
        else if ("cat_cow".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.flexibility_cat_cow);
            textViewHeadViewExercise.setText("Cat-Cow");
            textViewDescriptionLowerExercise.setText("The Cat-Cow stretch increases flexibility and relieves tension in the spine.");
            textViewInstructionLowerExercise.setText("Start on your hands and knees. Inhale, arch your back, and lift your head and tailbone towards the ceiling (Cow). Exhale, round your back, and tuck your chin to your chest (Cat). Repeat for 10-15 cycles.");
        }
        else if ("bicep_curl".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.strength_bicep_curl);
            textViewHeadViewExercise.setText("Bicep Curl");
            textViewDescriptionLowerExercise.setText("Bicep curls strengthen the upper arms and improve muscle definition.");
            textViewInstructionLowerExercise.setText("Stand with a dumbbell in each hand, arms at your sides. Keeping your elbows close to your body, curl the weights up to shoulder height. Lower back down slowly. Perform 12-15 repetitions.");
        }
        else if ("lying_leg_raise".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.balance_lying_leg_raise);
            textViewHeadViewExercise.setText("Lying Leg Raise");
            textViewDescriptionLowerExercise.setText("Lying leg raises target the lower abdominal muscles, improving core strength.");
            textViewInstructionLowerExercise.setText("Lie on your back with your legs straight. Place your hands under your lower back for support. Lift your legs towards the ceiling, keeping them straight. Lower them back down slowly without touching the floor. Perform 10-15 repetitions.");
        }
        else if ("lunge".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.endurance_lunge);
            textViewHeadViewExercise.setText("Lunge");
            textViewDescriptionLowerExercise.setText("Lunges strengthen the legs and improve overall lower body endurance.");
            textViewInstructionLowerExercise.setText("Stand with your feet together. Step forward with one leg, lowering your hips until both knees are bent at a 90-degree angle. Return to the starting position and repeat with the other leg. Perform 10-15 repetitions on each side.");
        }
        else if ("groin_stretch".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.flexibility_groin_stretch);
            textViewHeadViewExercise.setText("Groin Stretch");
            textViewDescriptionLowerExercise.setText("The groin stretch increases flexibility and reduces the risk of injury.");
            textViewInstructionLowerExercise.setText("Sit with your feet together, knees bent and pointing out to the sides. Hold your feet with your hands and gently press your knees towards the floor. Hold the stretch for 20-30 seconds.");
        }
        else if ("calf_raises".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.strength_calf_raises);
            textViewHeadViewExercise.setText("Calf Raises");
            textViewDescriptionLowerExercise.setText("Calf raises strengthen the lower legs and improve stability.");
            textViewInstructionLowerExercise.setText("Stand with your feet hip-width apart. Slowly raise your heels off the ground, standing on your toes. Lower back down with control. Perform 15-20 repetitions.");
        }
        else if ("single_leg_balance".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.balance_single_leg_balance);
            textViewHeadViewExercise.setText("Single Leg Balance");
            textViewDescriptionLowerExercise.setText("This exercise enhances balance and stability by engaging core and leg muscles.");
            textViewInstructionLowerExercise.setText("Stand on one leg with the other leg bent at the knee. Hold this position for 20-30 seconds, then switch legs. Repeat 2-3 times on each side.");
        }
        else if ("plank".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.endurance_plank);
            textViewHeadViewExercise.setText("Plank");
            textViewDescriptionLowerExercise.setText("The plank is a core exercise that strengthens the entire body, focusing on the abs and back.");
            textViewInstructionLowerExercise.setText("Start in a push-up position but with your weight on your forearms instead of your hands. Keep your body in a straight line from head to heels. Hold for 30-60 seconds.");
        }
        else if ("hip_flexor_stretch".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.flexibility_hip_flexor_stretch);
            textViewHeadViewExercise.setText("Hip Flexor Stretch");
            textViewDescriptionLowerExercise.setText("This stretch improves flexibility in the hip area and reduces lower back pain.");
            textViewInstructionLowerExercise.setText("Kneel on one knee, with the other foot in front, creating a 90-degree angle. Push your hips forward gently. Hold the stretch for 20-30 seconds, then switch sides.");
        }
        else if ("dumbell_floor_press".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.strength_dumbell_floor_press);
            textViewHeadViewExercise.setText("Dumbbell Floor Press");
            textViewDescriptionLowerExercise.setText("This exercise targets the chest and triceps, improving upper body strength.");
            textViewInstructionLowerExercise.setText("Lie on your back with a dumbbell in each hand, elbows on the floor. Press the weights up until your arms are fully extended. Lower them back down with control. Perform 10-12 repetitions.");
        }
        else if ("toe_taps".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.balance_toe_taps);
            textViewHeadViewExercise.setText("Toe Taps");
            textViewDescriptionLowerExercise.setText("Toe taps are a low-impact exercise that enhances coordination and leg strength.");
            textViewInstructionLowerExercise.setText("Stand in front of a step or low platform. Tap one foot on the platform, then switch feet quickly. Continue alternating for 30-60 seconds.");
        }
        else if ("push_up".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.endurance_push_up);
            textViewHeadViewExercise.setText("Push Up");
            textViewDescriptionLowerExercise.setText("Push-ups are a fundamental exercise that builds strength in the chest, shoulders, and triceps.");
            textViewInstructionLowerExercise.setText("Start in a plank position with your hands under your shoulders. Lower your body until your chest nearly touches the floor. Push back up to the starting position. Perform 10-15 repetitions.");
        }
        else if ("side_lunge_stretch".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.flexibility_side_lunge_stretch);
            textViewHeadViewExercise.setText("Side Lunge Stretch");
            textViewDescriptionLowerExercise.setText("This stretch increases flexibility and mobility in the hips and legs.");
            textViewInstructionLowerExercise.setText("Stand with your feet wide apart. Shift your weight to one side, bending your knee and keeping the other leg straight. Hold the stretch for 20-30 seconds, then switch sides.");
        }
        else if ("overhead_triceps_extension".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.strength_overhead_triceps_extension);
            textViewHeadViewExercise.setText("Overhead Triceps Extension");
            textViewDescriptionLowerExercise.setText("This exercise targets the triceps, enhancing upper arm strength.");
            textViewInstructionLowerExercise.setText("Stand with your feet shoulder-width apart. Hold a dumbbell with both hands and lift it overhead. Lower the weight behind your head by bending your elbows. Extend your arms back up. Perform 12-15 repetitions.");
        }
        else if ("tree_pose".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.balance_tree_pose);
            textViewHeadViewExercise.setText("Tree Pose");
            textViewDescriptionLowerExercise.setText("Tree Pose improves balance and stability while strengthening the legs.");
            textViewInstructionLowerExercise.setText("Stand on one leg, with the other foot placed on the inner thigh or calf (avoid the knee). Bring your hands together in front of your chest. Hold for 20-30 seconds, then switch legs.");
        }
        else if ("squat".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.endurance_squat);
            textViewHeadViewExercise.setText("Squat");
            textViewDescriptionLowerExercise.setText("Squats are a full-body exercise that primarily targets the legs and glutes.");
            textViewInstructionLowerExercise.setText("Stand with your feet shoulder-width apart. Lower your body by bending your knees and hips, keeping your back straight. Return to the starting position. Perform 15-20 repetitions.");
        }
        else if ("standing_biceps_stretch".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.flexibility_standing_bicep_stretch);
            textViewHeadViewExercise.setText("Standing Biceps Stretch");
            textViewDescriptionLowerExercise.setText("This stretch targets the biceps and shoulders, improving flexibility.");
            textViewInstructionLowerExercise.setText("Stand with your feet shoulder-width apart. Extend one arm out to the side, thumb pointing down. Gently press your hand down with the opposite hand. Hold for 20-30 seconds, then switch sides.");
        }
        else if ("wall_push_up".equals(exercise_title)) {
            imageViewExercise.setImageResource(R.drawable.strength_wall_push_up);
            textViewHeadViewExercise.setText("Wall Push Up");
            textViewDescriptionLowerExercise.setText("Wall push-ups are a beginner-friendly exercise that strengthens the chest and arms.");
            textViewInstructionLowerExercise.setText("Stand facing a wall, arms extended and hands on the wall. Bend your elbows and lean towards the wall, then push back to the starting position. Perform 15-20 repetitions.");
        }

        btnBackViewExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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

    private void init(){
        btnBackViewExercise = findViewById(R.id.btnBackViewExercise);

        nav_btn_home = findViewById(R.id.nav_btn_home_view_exercise);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_view_exercise);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_view_exercise);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_view_exercise);
        nav_btn_exercises = findViewById(R.id.nav_btn_exercise_view_exercise);

        imageViewExercise = findViewById(R.id.imageViewExercise);

        textViewDescriptionLowerExercise = findViewById(R.id.textViewDescriptionLowerExercise);
        textViewInstructionLowerExercise = findViewById(R.id.textViewInstructionLowerExercise);

        textViewHeadViewExercise = findViewById(R.id.textViewHeadViewExercise);

    }
}