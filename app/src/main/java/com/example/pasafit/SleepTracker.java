package com.example.pasafit;

import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SleepTracker extends AppCompatActivity {

    Button btnStart, btnStop;
    TextView timerText;
    private int maxTime = 30000; // Maximum time in milliseconds (e.g., 30 seconds)
    private int currentTime = 0;
    private Handler handler = new Handler();
    private boolean isRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracker);

        btnStart = findViewById(R.id.btnStart);
        timerText = findViewById(R.id.txtTimer);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountUpTimer();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopCountUpTimer();
            }
        });
    }

    private void startCountUpTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                currentTime++;
                timerText.setText(String.valueOf(currentTime));
                if (currentTime < maxTime) {
                    handler.postDelayed(this, 1000); // Repeat every second
                }
            }
        });
    }
    private void stopCountUpTimer() {
        if (isRunning) {
            handler.removeCallbacks(null);
            isRunning = false;
        }
    }
}