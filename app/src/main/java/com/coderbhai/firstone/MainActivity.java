package com.coderbhai.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    Button loginBtn,registerBtn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(v -> {

            auth.signInWithEmailAndPassword(
                            email.getText().toString(),
                            password.getText().toString()
                    )
                    .addOnSuccessListener(authResult -> {

                        Toast.makeText(this,
                                "Login Success",
                                Toast.LENGTH_SHORT).show();

                        startActivity(
                                new Intent(
                                        MainActivity.this,
                                        DashboardActivity.class));

                        finish();

                    })
                    .addOnFailureListener(e ->
                            Toast.makeText(this,
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT).show());
        });

        registerBtn.setOnClickListener(v -> {

            Intent i =
                    new Intent(MainActivity.this,
                            registeractivity.class);

            startActivity(i);
        });
    }
}