package com.example.pasafit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;

public class Dashboard extends AppCompatActivity {

    private TextView textViewHelloMessage;
    private ImageButton btn_dashboard_exercises, btn_dashboard_tracker, btn_dashboard_calc, btn_dashboard_user_profile;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        FirebaseUser currentUser = fAuth.getCurrentUser();

        init();

        if (currentUser == null) {
            Intent intent = new Intent(Dashboard.this, Home.class);
            startActivity(intent);
        }

        userID = currentUser.getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    textViewHelloMessage.setText("Hello, " + documentSnapshot.getString("username") + "!");
                }
            }
        });

        btn_dashboard_tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Tracker.class);
                startActivity(intent);
            }
        });

        btn_dashboard_exercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ExercisesCategories.class);
                startActivity(intent);
            }
        });

        btn_dashboard_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, Fitness_Calculator.class);
                startActivity(intent);
            }
        });

        btn_dashboard_user_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, UserProfile.class);
                startActivity(intent);
            }
        });

    }

    public void init(){
        btn_dashboard_tracker = findViewById(R.id.nav_btn_tracker_dashboard);
        btn_dashboard_exercises = findViewById(R.id.nav_btn_exercise_dashboard);
        btn_dashboard_calc = findViewById(R.id.nav_btn_calculator_dashboard);
        btn_dashboard_user_profile = findViewById(R.id.nav_btn_user_profile_dashboard);

        textViewHelloMessage = findViewById(R.id.textViewHelloMessage);
    }
}