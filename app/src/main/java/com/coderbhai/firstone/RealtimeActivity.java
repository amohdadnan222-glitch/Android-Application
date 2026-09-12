package com.coderbhai.firstone;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RealtimeActivity extends AppCompatActivity {

    EditText name, phone;
    Button saveBtn;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realtime);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        saveBtn = findViewById(R.id.saveBtn);

        databaseReference =
                FirebaseDatabase
                        .getInstance("https://smartutilityhub-ccdf9-default-rtdb.asia-southeast1.firebasedatabase.app/")
                        .getReference("Users");



        saveBtn.setOnClickListener(v -> {

            String userName =
                    name.getText().toString();

            String userPhone =
                    phone.getText().toString();

            String id =
                    databaseReference.push().getKey();

            HashMap<String,String> map =
                    new HashMap<>();

            map.put("name", userName);
            map.put("phone", userPhone);

            databaseReference.child(id)
                    .setValue(map)
                    .addOnSuccessListener(unused -> {

                        Toast.makeText(
                                RealtimeActivity.this,
                                "Data Saved",
                                Toast.LENGTH_SHORT
                        ).show();

                        name.setText("");
                        phone.setText("");

                    })
                    .addOnFailureListener(e ->

                            Toast.makeText(
                                    RealtimeActivity.this,
                                    e.getMessage(),
                                    Toast.LENGTH_SHORT
                            ).show());
        });
    }
}

