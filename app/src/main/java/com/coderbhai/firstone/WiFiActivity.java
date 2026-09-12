package com.coderbhai.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WiFiActivity extends AppCompatActivity {

    Button onBtn, offBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        onBtn = findViewById(R.id.onBtn);
        offBtn = findViewById(R.id.offBtn);

        onBtn.setOnClickListener(v -> {

            Toast.makeText(
                    WiFiActivity.this,
                    "Opening WiFi Settings...",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);

        });

        offBtn.setOnClickListener(v -> {

            Toast.makeText(
                    WiFiActivity.this,
                    "Opening WiFi Settings...",
                    Toast.LENGTH_SHORT
            ).show();

            Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivity(intent);

        });

    }
}