package com.example.pasafit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class Login extends AppCompatActivity {

    private TextInputEditText editTxtEmailUsernameLogin, editTxtPasswordLogin;

    private TextView textViewSignIn;
    private Button btnLogin;
    private ProgressBar progressBarLogin;

    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        editTxtEmailUsernameLogin = findViewById(R.id.editTxtEmailUsernameLogin);
        editTxtPasswordLogin = findViewById(R.id.editTxtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        progressBarLogin = findViewById(R.id.progressBarLogin);
        textViewSignIn = findViewById(R.id.textViewSignIn);

        /* Ma direct ang users to dashboard kung logged in pa sila

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            finish();
        }

        */

        String message = getIntent().getStringExtra("registration_successful");
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Registration.class));
                finish();
            }
        });

    }

    private void loginUser() {
        progressBarLogin.setVisibility(View.VISIBLE);

        String emailOrUsername = editTxtEmailUsernameLogin.getText().toString();
        String password = editTxtPasswordLogin.getText().toString();

        if (TextUtils.isEmpty(emailOrUsername)) {
            Toast.makeText(getApplicationContext(), "Please enter email or username!!", Toast.LENGTH_LONG).show();
            progressBarLogin.setVisibility(View.GONE);
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
            progressBarLogin.setVisibility(View.GONE);
            return;
        }

        if (emailOrUsername.contains("@")) {
            signInWithEmail(emailOrUsername, password);
        }
        else {
            fetchEmailFromUsername(emailOrUsername, password);
        }
    }

    private void signInWithEmail(String email, String password) {
        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBarLogin.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Login.this, Dashboard.class));
                }
                else {
                    Toast.makeText(getApplicationContext(), "Login failed!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void fetchEmailFromUsername(String username, String password) {
        fStore.collection("users").whereEqualTo("username", username).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful() && !task.getResult().isEmpty()) {
                    DocumentSnapshot document = task.getResult().getDocuments().get(0);
                    String email = document.getString("email");
                    signInWithEmail(email, password);
                }
                else {
                    progressBarLogin.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Username not found!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
