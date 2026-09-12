package com.coderbhai.firstone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class registeractivity extends AppCompatActivity {

    EditText email,password;
    Button createBtn;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();

        email = findViewById(R.id.regEmail);
        password = findViewById(R.id.regPassword);
        createBtn = findViewById(R.id.createBtn);

        createBtn.setOnClickListener(v -> {

            auth.createUserWithEmailAndPassword(
                            email.getText().toString(),
                            password.getText().toString()
                    )
                    .addOnSuccessListener(authResult ->
                            Toast.makeText(this,
                                    "Registration Successful",
                                    Toast.LENGTH_SHORT).show())
                    .addOnFailureListener(e ->
                            Toast.makeText(this,
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT).show());
        });
    }
}