package com.coderbhai.firstone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    EditText num1,num2;
    Button addBtn,subBtn,mulBtn,divBtn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        result = findViewById(R.id.result);

        addBtn.setOnClickListener(v -> {

            double a =
                    Double.parseDouble(num1.getText().toString());

            double b =
                    Double.parseDouble(num2.getText().toString());

            result.setText("Result = " + (a+b));
        });

        subBtn.setOnClickListener(v -> {

            double a =
                    Double.parseDouble(num1.getText().toString());

            double b =
                    Double.parseDouble(num2.getText().toString());

            result.setText("Result = " + (a-b));
        });

        mulBtn.setOnClickListener(v -> {

            double a =
                    Double.parseDouble(num1.getText().toString());

            double b =
                    Double.parseDouble(num2.getText().toString());

            result.setText("Result = " + (a*b));
        });

        divBtn.setOnClickListener(v -> {

            double a =
                    Double.parseDouble(num1.getText().toString());

            double b =
                    Double.parseDouble(num2.getText().toString());

            result.setText("Result = " + (a/b));
        });
    }
}