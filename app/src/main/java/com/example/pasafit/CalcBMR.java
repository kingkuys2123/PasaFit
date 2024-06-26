package com.example.pasafit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcBMR extends AppCompatActivity {

    private EditText ageInput;
    private EditText heightInput;
    private EditText weightInput;
    private RadioButton maleButton, femaleButton;
    private TextView resultText;
    private RadioGroup gender_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_bmr);

        ageInput = findViewById(R.id.bmr_input_age);
        heightInput = findViewById(R.id.bmr_input_height);
        weightInput = findViewById(R.id.bmr_input_weight);
        maleButton = findViewById(R.id.bmr_gender_male);
        femaleButton = findViewById(R.id.bmr_gender_female);
        resultText = findViewById(R.id.bmr_result);

        gender_group = findViewById(R.id.genderGroup);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateBMR();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        ageInput.addTextChangedListener(textWatcher);
        heightInput.addTextChangedListener(textWatcher);
        weightInput.addTextChangedListener(textWatcher);

        gender_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calculateBMR();
            }
        });
    }

    public void calculateBMR() {
        if (ageInput.getText().toString().isEmpty() || heightInput.getText().toString().isEmpty() || weightInput.getText().toString().isEmpty()) {
            return;
        }

        int age = Integer.parseInt(ageInput.getText().toString());
        double height = Double.parseDouble(heightInput.getText().toString());
        double weight = Double.parseDouble(weightInput.getText().toString());

        // Validate height and weight
        if (height < 50 || height > 300) {
            heightInput.setError("Invalid height. Please enter a value between 50 and 300.");
            return;
        }

        if (weight < 10 || weight > 500) {
            weightInput.setError("Invalid weight. Please enter a value between 10 and 500.");
            return;
        }

        double bmr;

        if (maleButton.isChecked()) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else{
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        resultText.setText(String.format("Your BMR is: %.2f calories per day", bmr));
    }
}