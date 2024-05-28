package com.example.pasafit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    private Button btnHomeLogin, btnHomeRegister;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
        fAuth = FirebaseAuth.getInstance();

        // If logged in pa ang user, ma redirect ang user to the dashboard
        if (fAuth.getCurrentUser() != null) {
            Intent intent = new Intent(Home.this, Dashboard.class);

            startActivity(intent);
            finish();
        }

        btnHomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Login.class);

                startActivity(intent);
                finish();
            }
        });

        btnHomeRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Registration.class);

                startActivity(intent);
                finish();
            }
        });

    }

    public void init(){
        btnHomeLogin = findViewById(R.id.btnHomeLogin);
        btnHomeRegister = findViewById(R.id.btnHomeRegister);
    }
}