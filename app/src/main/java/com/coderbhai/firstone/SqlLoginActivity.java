package com.coderbhai.firstone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SqlLoginActivity extends AppCompatActivity {

    EditText email,password;
    Button loginBtn,registerBtn;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_login);

        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);

        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);

        db = new DatabaseHelper(this);

        loginBtn.setOnClickListener(v -> {

            String userEmail = email.getText().toString().trim();
            String userPassword = password.getText().toString().trim();

            if(db.checkUser(userEmail,userPassword)){

                Toast.makeText(this,
                        "Login Successful",
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(
                        SqlLoginActivity.this,
                        DashboardActivity.class);

                startActivity(intent);

                finish();

            }else{

                Toast.makeText(this,
                        "Invalid Email or Password",
                        Toast.LENGTH_SHORT).show();

            }

        });

        registerBtn.setOnClickListener(v -> {

            Intent intent = new Intent(
                    SqlLoginActivity.this,
                    SqlRegisterActivity.class);

            startActivity(intent);

        });

    }
}