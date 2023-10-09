package com.example.bmicalculator;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText heightInput;
    EditText weightInput;
    Button calculateButton;
    TextView bmiValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        importVies();

        calculateButton.setOnClickListener(onClick -> calculateBmi());
    }

    private void importVies() {
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        calculateButton = findViewById(R.id.calculateButton);
        bmiValue = findViewById(R.id.bmiValue);
    }

    private void calculateBmi() {
        float weight = Float.parseFloat(String.valueOf(weightInput.getText()));
        float height = Float.parseFloat(String.valueOf(heightInput.getText()));
        Double value = weight / pow(height, 2);
        String text = String.valueOf(Math.round(value * 100.0) / 100.0);
        bmiValue.setText("Your BMI is: " + text);
    }
}