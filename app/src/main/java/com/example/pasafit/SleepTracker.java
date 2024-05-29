package com.example.pasafit;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SleepTracker extends AppCompatActivity {

    private Button btnBackSleepTracker, btnStart, btnRestart;
    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_profile, nav_btn_exercises;
    private TextView textViewStartTime, textViewEndTime, textViewDuration, textViewQuality;

    private Handler handler = new Handler();
    private long startTime, endTime;
    private boolean tracking = false;

    private Runnable updateDuration = new Runnable() {
        @Override
        public void run() {
            if (tracking) {
                long currentTime = System.currentTimeMillis();
                long duration = currentTime - startTime;
                textViewDuration.setText("Hrs/Mins/Secs: " + formatDuration(duration));
                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracker);

        init();

        btnBackSleepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!tracking) {
                    startTracking();
                } else {
                    stopTracking();
                }
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTracker();
            }
        });

        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, Dashboard.class);
                startActivity(intent);
            }
        });

        nav_btn_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, Tracker.class);
                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, Fitness_Calculator.class);
                startActivity(intent);
            }
        });

        nav_btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, UserProfile.class);
                startActivity(intent);
            }
        });

        nav_btn_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepTracker.this, ExercisesCategories.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        btnBackSleepTracker = findViewById(R.id.btnBackSleepTracker);
        btnStart = findViewById(R.id.btnStartSleepTracker);
        btnRestart = findViewById(R.id.btnRestartSleepTracker);

        nav_btn_home = findViewById(R.id.nav_btn_home_sleep_tracker);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_sleep_tracker);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_sleep_tracker);
        nav_btn_profile = findViewById(R.id.nav_btn_profile_sleep_tracker);
        nav_btn_exercises = findViewById(R.id.nav_btn_exercise_sleep_tracker);

        textViewStartTime = findViewById(R.id.textViewStartTimeSleepTracker);
        textViewEndTime = findViewById(R.id.textViewEndTimeSleepTracker);
        textViewDuration = findViewById(R.id.textViewDurationSleepTracker);
        textViewQuality = findViewById(R.id.textViewQualitySleepTracker);
    }

    private void startTracking() {
        startTime = System.currentTimeMillis();
        tracking = true;
        btnStart.setText("Stop");
        btnRestart.setVisibility(View.VISIBLE);
        textViewStartTime.setText("Start Date/Time: " + getDateTimeString(startTime));
        handler.post(updateDuration);
    }

    private void stopTracking() {
        endTime = System.currentTimeMillis();
        tracking = false;
        btnStart.setText("Start");
        textViewEndTime.setText("End Date/Time: " + getDateTimeString(endTime));
        handler.removeCallbacks(updateDuration);
        updateDuration.run();

        // Show dialog to ask for sleep quality
        showSleepQualityDialog();
    }

    private void showSleepQualityDialog() {
        final String[] qualityOptions = {"Very Good", "Good", "Normal", "Bad", "Very Bad"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Rate Your Sleep Quality");
        builder.setItems(qualityOptions, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                textViewQuality.setText("Quality: " + qualityOptions[which]);
            }
        });
        builder.show();
    }

    private void resetTracker() {
        tracking = false;
        btnStart.setText("Start");
        btnRestart.setVisibility(View.GONE);
        textViewStartTime.setText("Start Date/Time: --:--");
        textViewEndTime.setText("End Date/Time: --:--");
        textViewDuration.setText("Hrs/Mins/Secs: 00:00:00");
        textViewQuality.setText("Quality: Unrated");
    }

    private String getDateTimeString(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm a", Locale.getDefault());
        return sdf.format(new Date(millis));
    }

    private String formatDuration(long millis) {
        long seconds = millis / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        seconds = seconds % 60;
        minutes = minutes % 60;
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
    }
}
