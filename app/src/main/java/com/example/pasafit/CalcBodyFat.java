package com.example.pasafit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcBodyFat extends AppCompatActivity {

    private EditText ageInput;
    private EditText heightInput;
    private EditText weightInput;
    private EditText neckInput;
    private EditText waistInput;

    private EditText hipInput;
    private RadioButton maleButton, femaleButton;
    private TextView resultText, txtHip;
    private RadioGroup genderGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_body_fat);

        ageInput = findViewById(R.id.bodyfat_input_age);
        heightInput = findViewById(R.id.bodyfat_input_height);
        weightInput = findViewById(R.id.bodyfat_input_weight);
        neckInput = findViewById(R.id.bodyfat_input_neck);
        waistInput = findViewById(R.id.bodyfat_input_waist);
        hipInput =findViewById(R.id.bodyfat_input_hip);
        txtHip = findViewById(R.id.txt_bodyfat_hip);
        maleButton = findViewById(R.id.bodyfat_gender_male);
        femaleButton = findViewById(R.id.bodyfat_gender_female);
        resultText = findViewById(R.id.bodyfat_result);
        genderGroup = findViewById(R.id.genderGroup);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateBodyFat();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        ageInput.addTextChangedListener(textWatcher);
        heightInput.addTextChangedListener(textWatcher);
        weightInput.addTextChangedListener(textWatcher);
        neckInput.addTextChangedListener(textWatcher);
        waistInput.addTextChangedListener(textWatcher);

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.bodyfat_gender_female) {
                    hipInput.setVisibility(View.VISIBLE);
                    txtHip.setVisibility(View.VISIBLE);
                } else {
                    hipInput.setVisibility(View.GONE);
                    txtHip.setVisibility(View.GONE);
                }
                calculateBodyFat();
            }
        });
    }

    public void calculateBodyFat() {
        if (ageInput.getText().toString().isEmpty() || heightInput.getText().toString().isEmpty() || weightInput.getText().toString().isEmpty() || neckInput.getText().toString().isEmpty() || waistInput.getText().toString().isEmpty()) {
            return;
        }

        double height = Double.parseDouble(heightInput.getText().toString());
        double weight = Double.parseDouble(weightInput.getText().toString());
        double neck = Double.parseDouble(neckInput.getText().toString());
        double waist = Double.parseDouble(waistInput.getText().toString());
        double bodyFat;

        if (maleButton.isChecked()) {
            bodyFat = 495 / (1.0324 - 0.19077 * Math.log10(waist - neck) + 0.15456 * Math.log10(height)) - 450;
        } else {
            double hip = Double.parseDouble(hipInput.getText().toString()); // Assuming you have a hip input for females
            bodyFat = 495 / (1.29579 - 0.35004 * Math.log10(waist + hip - neck) + 0.22100 * Math.log10(height)) - 450;
        }

        resultText.setText(String.format("Your Body Fat Percentage is: %.2f%%", bodyFat));
    }

}