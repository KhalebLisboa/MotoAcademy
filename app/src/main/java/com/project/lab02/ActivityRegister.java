package com.project.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityRegister extends AppCompatActivity {

    Button btnRegister;
    TextView txtBack;
    EditText txtBoxEmail, txtBoxPassword;

    ConstraintLayout cnstLoading;

    String TAG = "Login";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        bindViews();

        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(view -> {
            if (txtBoxEmail.getText().toString().isEmpty() && txtBoxPassword.getText().toString().isEmpty()) {
                Snackbar.make(view, "Preencha os campos vazios", Snackbar.LENGTH_LONG).show();
            } else {
                String email, password;
                email = txtBoxEmail.getText().toString();
                password = txtBoxPassword.getText().toString();
                cnstLoading.setVisibility(View.VISIBLE);
                createAccount(email, password);
            }
        });

        txtBack.setOnClickListener(view -> {
            Intent actionBackLogin = new Intent(this, MainActivity.class);
            startActivity(actionBackLogin);
            finish();
        });
    }


    void bindViews() {
        btnRegister = findViewById(R.id.btn_register);
        txtBack = findViewById(R.id.txt_create_account);
        txtBoxEmail = findViewById(R.id.edtText_name);
        txtBoxPassword = findViewById(R.id.edtText_password);
        cnstLoading = findViewById(R.id.constraint_loading);
    }

    void createAccount(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent actionBackLogin = new Intent(this, MainActivity.class);
                        Toast.makeText(this, "Cadastrado com sucesso! :)", Toast.LENGTH_LONG).show();
                        startActivity(actionBackLogin);
                        finish();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        cnstLoading.setVisibility(View.GONE);
                        Toast.makeText(this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}