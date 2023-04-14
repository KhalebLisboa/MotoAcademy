package com.project.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class ActivityRegister extends AppCompatActivity {

    Button btnRegister;
    TextView txtBack;
    EditText txtBoxEmail;
    EditText txtBoxPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindViews();

        btnRegister.setOnClickListener(view -> {
            if (txtBoxEmail.getText().toString().isEmpty() && txtBoxPassword.getText().toString().isEmpty()){
                Snackbar.make(view, "Preencha os campos vazios", Snackbar.LENGTH_LONG).show();
            } else {
                String email, password;
                email = txtBoxEmail.getText().toString();
                password = txtBoxPassword.getText().toString();
            }
        });

        txtBack.setOnClickListener(view -> {
            Intent actionBackLogin = new Intent(this, MainActivity.class);
            startActivity(actionBackLogin);
            finish();
        });
    }


    void bindViews(){
        btnRegister = findViewById(R.id.btn_register);
        txtBack = findViewById(R.id.txt_create_account);
        txtBoxEmail = findViewById(R.id.edtText_name);
        txtBoxPassword = findViewById(R.id.edtText_password);
    }
}