package com.project.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseUser currentUser;
    TextView txtUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();

        txtUser = findViewById(R.id.txt_home);
        if (currentUser != null){
            txtUser.setText(currentUser.getEmail());
        }

    }
}