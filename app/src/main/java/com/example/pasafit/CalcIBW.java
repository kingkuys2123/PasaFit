package com.example.pasafit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalcIBW extends AppCompatActivity {

    private EditText heightInput;
    private RadioButton maleButton, femaleButton;
    private TextView resultText;
    private RadioGroup genderGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_ibw);

        heightInput = findViewById(R.id.ibw_input_height);
        maleButton = findViewById(R.id.ibw_gender_male);
        femaleButton = findViewById(R.id.ibw_gender_female);
        resultText = findViewById(R.id.ibw_result);
        genderGroup = findViewById(R.id.genderGroup);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                calculateIBW();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        heightInput.addTextChangedListener(textWatcher);

        genderGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                calculateIBW();
            }
        });
    }

    public void calculateIBW() {
        if (heightInput.getText().toString().isEmpty()) {
            return;
        }

        double heightInCm = Double.parseDouble(heightInput.getText().toString());
        double heightOver152Cm = heightInCm - 152.4; // Subtract 152.4 cm (5 feet in cm)

        if (heightOver152Cm < 0) {
            heightOver152Cm = 0; // If the person is less than 152.4 cm tall, consider the height over 152.4 cm as 0
        }

        double ibw;

        if (maleButton.isChecked()) {
            ibw = 50 + 0.9 * heightOver152Cm; // 2.3 kg per inch over 5 feet is approximately 0.9 kg per cm over 152.4 cm
        } else {
            ibw = 45.5 + 0.9 * heightOver152Cm; // 2.3 kg per inch over 5 feet is approximately 0.9 kg per cm over 152.4 cm
        }

        resultText.setText(String.format("Your Ideal Body Weight is: %.2f kg", ibw));
    }
}