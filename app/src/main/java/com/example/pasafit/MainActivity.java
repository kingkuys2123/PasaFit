package com.example.pasafit;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button btnMainGetStarted;
    private TextView textViewOnboardWelcomeHeader;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        fAuth = FirebaseAuth.getInstance();

        /* Ma direct ang users to dashboard kung logged in pa sila

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            finish();
        }

        */

        btnMainGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Home.class);

                startActivity(intent);
            }
        });

    }

    public void init(){
        btnMainGetStarted = findViewById(R.id.btnMainGetStarted);
        textViewOnboardWelcomeHeader = findViewById(R.id.textViewOnboardWelcomeHeader);

        String welcomeText = textViewOnboardWelcomeHeader.getText().toString();

        SpannableString spannableString = new SpannableString(welcomeText);
        String target = "PASAFIT";
        int startWelcomeText = welcomeText.indexOf(target);
        int endWelcomeText = startWelcomeText + target.length();
        int sea_green = ContextCompat.getColor(this, R.color.sea_green);

        spannableString.setSpan(new ForegroundColorSpan(sea_green), startWelcomeText, endWelcomeText, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        textViewOnboardWelcomeHeader.setText(spannableString);
    }

}