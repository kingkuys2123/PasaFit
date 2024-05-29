package com.example.pasafit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcBMI extends AppCompatActivity {

    private EditText heightInput;
    private EditText weightInput;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_bmi);

        heightInput = findViewById(R.id.bmi_input_height);
        weightInput = findViewById(R.id.bmi_input_weight);
        resultText = findViewById(R.id.bmi_result);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateBMI();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        heightInput.addTextChangedListener(textWatcher);
        weightInput.addTextChangedListener(textWatcher);
    }

    private void calculateBMI() {
        String heightStr = heightInput.getText().toString();
        String weightStr = weightInput.getText().toString();

        if (!"".equals(heightStr) && !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel;

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "Very severely underweight";
        } else if (Float.compare(bmi, 15f) > 0 && Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "Severely underweight";
        } else if (Float.compare(bmi, 16f) > 0 && Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "Underweight";
        } else if (Float.compare(bmi, 18.5f) > 0 && Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "Normal";
        } else if (Float.compare(bmi, 25f) > 0 && Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "Overweight";
        } else {
            bmiLabel = "Obese";
        }

        bmiLabel = "BMI: " + bmi + "\n" + bmiLabel;
        resultText.setText(bmiLabel);
    }
}