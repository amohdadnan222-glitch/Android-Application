package com.coderbhai.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    Button calculatorBtn, quizBtn, realtimeBtn, sqliteBtn, wifiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        calculatorBtn = findViewById(R.id.calculatorBtn);
        quizBtn = findViewById(R.id.quizBtn);
        realtimeBtn = findViewById(R.id.realtimeBtn);
        sqliteBtn = findViewById(R.id.sqliteBtn);
        wifiBtn = findViewById(R.id.wifiBtn);

        wifiBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    DashboardActivity.this,
                    WiFiActivity.class);

            startActivity(intent);

        });

        calculatorBtn.setOnClickListener(v ->
                startActivity(new Intent(this, CalculatorActivity.class)));

        quizBtn.setOnClickListener(v ->
                startActivity(new Intent(this, QuizActivity.class)));

        realtimeBtn.setOnClickListener(v ->
                startActivity(new Intent(this, RealtimeActivity.class)));

        sqliteBtn.setOnClickListener(v -> {

            Intent intent =
                    new Intent(DashboardActivity.this, SqlLoginActivity.class);

            startActivity(intent);

        });

        }
}