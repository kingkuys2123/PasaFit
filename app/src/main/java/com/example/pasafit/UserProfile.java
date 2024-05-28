package com.example.pasafit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class UserProfile extends AppCompatActivity {

    private FirebaseAuth fAuth;
    private FirebaseFirestore fStore;
    private String userID;
    private ImageButton nav_btn_home, nav_btn_trackers, nav_btn_calculator, nav_btn_exercise, imageButtonEditPersonalInformation;
    private Button btnBackExerciseUserProfile;

    TextView profileTextViewFirstName, profileTextViewLastName, profileTextViewUsername, profileTextViewEmail, textViewChangeEmailUserProfile, textViewChangePasswordUserProfile, textViewDeleteAccountUserProfile, textViewLogOutUserProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        FirebaseUser currentUser = fAuth.getCurrentUser();

        init();

        userID = currentUser.getUid();

        DocumentReference documentReference = fStore.collection("users").document(userID);

        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot != null && documentSnapshot.exists()) {
                    profileTextViewFirstName.setText(documentSnapshot.getString("first_name"));
                    profileTextViewLastName.setText(documentSnapshot.getString("last_name"));
                    profileTextViewUsername.setText(documentSnapshot.getString("username"));
                    profileTextViewEmail.setText(documentSnapshot.getString("email"));
                }
            }
        });

        btnBackExerciseUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, ExerciseList.class);
                startActivity(intent);
            }
        });

        nav_btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, Dashboard.class);

                startActivity(intent);
            }
        });

        nav_btn_trackers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, Tracker.class);

                startActivity(intent);
            }
        });

        nav_btn_calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, Fitness_Calculator.class);

                startActivity(intent);
            }
        });

        nav_btn_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, UserProfile.class);

                startActivity(intent);
            }
        });

        textViewLogOutUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fAuth.signOut();
                Intent intent = new Intent(UserProfile.this, Home.class);
                startActivity(intent);
                finish();
            }
        });

        textViewDeleteAccountUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(UserProfile.this)
                        .setTitle("Delete Account")
                        .setMessage("Are you sure you want to delete your account? This action cannot be undone.")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                deleteAccount();
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        textViewChangePasswordUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfile.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_change_password, null);
                builder.setView(view);

                EditText editTextCurrentPassword = view.findViewById(R.id.editTextCurrentPassword);
                EditText editTextNewPassword = view.findViewById(R.id.editTextNewPassword);
                EditText editTextConfirmNewPassword = view.findViewById(R.id.editTextConfirmNewPassword);

                builder.setPositiveButton("Change Password", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String currentPassword = editTextCurrentPassword.getText().toString().trim();
                        String newPassword = editTextNewPassword.getText().toString().trim();
                        String confirmNewPassword = editTextConfirmNewPassword.getText().toString().trim();

                        if (newPassword.equals(confirmNewPassword)) {
                            changePassword(currentPassword, newPassword);
                        }
                        else {
                            Toast.makeText(UserProfile.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        textViewChangeEmailUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfile.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_change_email, null);
                builder.setView(view);

                EditText editTextPasswordEmail = view.findViewById(R.id.editTextPasswordEmail);
                EditText editTextNewEmail = view.findViewById(R.id.editTextNewEmail);

                builder.setPositiveButton("Change Email", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String password = editTextPasswordEmail.getText().toString().trim();
                        String newEmail = editTextNewEmail.getText().toString().trim();

                        if (!password.isEmpty() && !newEmail.isEmpty()) {
                            changeEmail(password, newEmail);
                        } else {
                            Toast.makeText(UserProfile.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        imageButtonEditPersonalInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserProfile.this);
                View view = getLayoutInflater().inflate(R.layout.dialog_edit_personal_information, null);
                builder.setView(view);

                EditText editTextUpdateFirstName = view.findViewById(R.id.editTextUpdateFirstName);
                EditText editTextUpdateLastName = view.findViewById(R.id.editTextUpdateLastName);

                editTextUpdateFirstName.setText(profileTextViewFirstName.getText().toString());
                editTextUpdateLastName.setText(profileTextViewLastName.getText().toString());

                builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newFirstName = editTextUpdateFirstName.getText().toString().trim();
                        String newLastName = editTextUpdateLastName.getText().toString().trim();

                        if (!newFirstName.isEmpty() && !newLastName.isEmpty()) {
                            updatePersonalInformation(newFirstName, newLastName);
                        } else {
                            Toast.makeText(UserProfile.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    private void init(){
        btnBackExerciseUserProfile = findViewById(R.id.btnBackExerciseUserProfile);

        nav_btn_home = findViewById(R.id.nav_btn_home_user_profile);
        nav_btn_trackers = findViewById(R.id.nav_btn_trackers_user_profile);
        nav_btn_calculator = findViewById(R.id.nav_btn_calculator_user_profile);
        nav_btn_exercise = findViewById(R.id.nav_btn_exercise_user_profile);

        profileTextViewFirstName = findViewById(R.id.profileTextViewFirstName);
        profileTextViewLastName = findViewById(R.id.profileTextViewLastName);
        profileTextViewEmail = findViewById(R.id.profileTextViewEmail);
        profileTextViewUsername = findViewById(R.id.profileTextViewUsername);

        textViewChangeEmailUserProfile = findViewById(R.id.textViewChangeEmailUserProfile);
        textViewChangePasswordUserProfile = findViewById(R.id.textViewChangePasswordUserProfile);
        textViewDeleteAccountUserProfile = findViewById(R.id.textViewDeleteAccountUserProfile);
        textViewLogOutUserProfile = findViewById(R.id.textViewLogOutUserProfile);

        imageButtonEditPersonalInformation = findViewById(R.id.imageButtonEditPersonalInformation);

    }

    private void deleteAccount() {
        fStore.collection("users").document(userID).delete().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = fAuth.getCurrentUser();
                if (user != null) {
                    user.delete().addOnCompleteListener(task1 -> {
                        if (task1.isSuccessful()) {
                            Intent intent = new Intent(UserProfile.this, Home.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                        }
                    });
                }
            }
            else {
            }
        });
    }

    private void changePassword(String currentPassword, String newPassword) {
        FirebaseUser user = fAuth.getCurrentUser();
        if (user != null && user.getEmail() != null) {
            AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), currentPassword);

            user.reauthenticate(credential).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    user.updatePassword(newPassword).addOnCompleteListener(task1 -> {
                        if (task1.isSuccessful()) {
                            Toast.makeText(UserProfile.this, "Password updated successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(UserProfile.this, "Password update failed", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(UserProfile.this, "Current assword is incorrect", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void changeEmail(String password, String newEmail) {
        FirebaseUser user = fAuth.getCurrentUser();
        if (user != null && user.getEmail() != null) {
            AuthCredential credential = EmailAuthProvider.getCredential(user.getEmail(), password);

            user.reauthenticate(credential).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    user.verifyBeforeUpdateEmail(newEmail).addOnCompleteListener(task1 -> {
                        if (task1.isSuccessful()) {
                            DocumentReference documentReference = fStore.collection("users").document(userID);
                            documentReference.update("email", newEmail).addOnCompleteListener(task2 -> {
                                if (task2.isSuccessful()) {
                                    Toast.makeText(UserProfile.this, "Email updated successfully", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(UserProfile.this, "Failed to update email", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                        else {
                            Toast.makeText(UserProfile.this, "Failed to update email", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(UserProfile.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void updatePersonalInformation(String firstName, String lastName) {
        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.update("first_name", firstName, "last_name", lastName).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(UserProfile.this, "Personal info updated successfully", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(UserProfile.this, "Failed to update personal info", Toast.LENGTH_SHORT).show();
            }
        });
    }
}