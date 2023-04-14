package com.project.lab02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBack = findViewById(R.id.btn_back);

        btnBack.setOnClickListener(view -> {
            Intent actionBack = new Intent(this, MainActivity.class);
            startActivity(actionBack);
            finish();
        });
    }
}
