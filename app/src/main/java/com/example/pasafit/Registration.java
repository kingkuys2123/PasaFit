package com.example.pasafit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    private EditText editTxtEmailRegister, editTxtPasswordRegister, editTextConfirmPasswordRegister, editTxtFirstNameRegister, editTxtLastNameRegister, editTxtUsernameRegister;
    private Button btnRegister;
    private ProgressBar progressBarRegister;
    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        editTxtFirstNameRegister = findViewById(R.id.editTxtFirstNameRegister);
        editTxtLastNameRegister = findViewById(R.id.editTxtLastNameRegister);
        editTxtUsernameRegister = findViewById(R.id.editTxtUsernameRegister);
        editTxtEmailRegister = findViewById(R.id.editTxtEmailRegister);
        editTxtPasswordRegister = findViewById(R.id.editTxtPasswordRegister);
        btnRegister = findViewById(R.id.btnRegister);
        progressBarRegister = findViewById(R.id.progressBarRegister);
        editTextConfirmPasswordRegister = findViewById(R.id.editTextConfirmPasswordRegister);

        /* Ma direct ang users to dashboard kung logged in pa sila

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), Dashboard.class));
            finish();
        }

        */

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });
    }

    private void registerNewUser() {
        progressBarRegister.setVisibility(View.VISIBLE);

        String first_name = editTxtFirstNameRegister.getText().toString();
        String last_name = editTxtLastNameRegister.getText().toString();
        String username = editTxtUsernameRegister.getText().toString();
        String email = editTxtEmailRegister.getText().toString();
        String password = editTxtPasswordRegister.getText().toString();
        String confirm_password = editTextConfirmPasswordRegister.getText().toString();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "Please enter email!!", Toast.LENGTH_LONG).show();
            progressBarRegister.setVisibility(View.GONE);
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(), "Please enter password!!", Toast.LENGTH_LONG).show();
            progressBarRegister.setVisibility(View.GONE);
            return;
        }
        if(TextUtils.isEmpty(confirm_password)){
            Toast.makeText(getApplicationContext(), "Please re-enter password!!", Toast.LENGTH_LONG).show();
            progressBarRegister.setVisibility(View.GONE);
            return;
        }
        if(!confirm_password.equals(password)){
            Toast.makeText(getApplicationContext(), "Passwords does not match!!", Toast.LENGTH_LONG).show();
            progressBarRegister.setVisibility(View.GONE);
            return;
        }

        fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){
                progressBarRegister.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();

                    userID = fAuth.getCurrentUser().getUid();
                    DocumentReference documentReference = fStore.collection("users").document(userID);

                    Map<String, Object> user = new HashMap<>();
                    user.put("first_name", first_name);
                    user.put("last_name", last_name);
                    user.put("username", username);
                    user.put("email", email);

                    documentReference.set(user);

                    Intent intent = new Intent(Registration.this, Login.class);
                    intent.putExtra("registration_successful", "Registration successful!");
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Registration failed!! Please try again later", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
