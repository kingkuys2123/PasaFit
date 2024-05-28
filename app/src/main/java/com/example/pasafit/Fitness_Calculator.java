package com.example.pasafit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fitness_Calculator extends AppCompatActivity {

    ImageButton btnBMI, btnBMR, btnIBW, btnBodyFat;
    TextView txtBMI, txtBMR, txtIBW, txtBodyFat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fitness_calculator);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBMI = findViewById(R.id.btn_calc_bmi);
        btnBMR = findViewById(R.id.btn_calc_bmr);
        btnIBW = findViewById(R.id.btn_calc_weight);
        btnBodyFat = findViewById(R.id.btn_calc_bodyfat);

        txtBMI = findViewById(R.id.txt_calc_bmi);
        txtBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Fitness_Calculator.this);
                builder.setTitle("Basal Metabolic Rate");
                builder.setMessage("BMR (Basal Metabolic Rate) is the minimum number of calories your body burns at rest to maintain vital functions like breathing and digestion.");

                // Positive button (Optional): Close the dialog
                builder.setPositiveButton("OK, I GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform BMR calculation here (if needed)
                        dialog.dismiss();
                    }
                });

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        txtBMR = findViewById(R.id.txt_calc_bmr);
        txtBMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Build the AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(Fitness_Calculator.this);
                builder.setTitle("Body Mass Index");
                builder.setMessage("BMI (Body Mass Index) is an estimate of body fat based on height and weight.");

                // Positive button (Optional): Close the dialog
                builder.setPositiveButton("OK, I GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform BMR calculation here (if needed)
                        dialog.dismiss();
                    }
                });

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txtIBW = findViewById(R.id.txt_calc_weight);
        txtIBW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Fitness_Calculator.this);
                builder.setTitle("Ideal Body Weight");
                builder.setMessage("Ideal Body Weight (IBW) is a rough estimate of weight based on height. It may not consider factors like muscle mass or body composition.");

                // Positive button (Optional): Close the dialog
                builder.setPositiveButton("OK, I GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform BMR calculation here (if needed)
                        dialog.dismiss();
                    }
                });

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        txtBodyFat = findViewById(R.id.txt_calc_bodyfat);
        txtBodyFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Fitness_Calculator.this);
                builder.setTitle("Body Fat");
                builder.setMessage("Body fat is the percentage of your body weight made up of fat tissue.");

                // Positive button (Optional): Close the dialog
                builder.setPositiveButton("OK, I GOT IT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Perform BMR calculation here (if needed)
                        dialog.dismiss();
                    }
                });

                // Create and show the dialog
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fitness_Calculator.this, CalcBMI.class);

                startActivity(intent);
            }
        });

        btnBMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fitness_Calculator.this, CalcBMR.class);
                startActivity(intent);
            }
        });

        btnIBW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fitness_Calculator.this, CalcIBW.class);
                startActivity(intent);
            }
        });

        btnBodyFat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fitness_Calculator.this, CalcBodyFat.class);
                startActivity(intent);
            }
        });
    }
}