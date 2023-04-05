package com.project.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextView txtSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btn_login);
        txtSignIn = findViewById(R.id.txt_create_account);

        btnLogin.setOnClickListener(this::onClickGeneric);
        txtSignIn.setOnClickListener(this::onClickGeneric);
    }

    void onClickGeneric(View view){
        Snackbar.make(view, "Realizar ação", Snackbar.LENGTH_LONG).show();
    }
}