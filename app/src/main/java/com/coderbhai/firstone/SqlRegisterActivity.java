package com.coderbhai.firstone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SqlRegisterActivity extends AppCompatActivity {

    EditText email,password;
    Button register;

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_register);

        email=findViewById(R.id.sqlEmail);
        password=findViewById(R.id.sqlPassword);
        register=findViewById(R.id.sqlRegisterBtn);

        db=new DatabaseHelper(this);

        register.setOnClickListener(v->{

            boolean success=db.insertUser(
                    email.getText().toString(),
                    password.getText().toString());

            if(success){

                Toast.makeText(this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT).show();

                finish();

            }else{

                Toast.makeText(this,
                        "Registration Failed",
                        Toast.LENGTH_SHORT).show();

            }

        });

    }
}