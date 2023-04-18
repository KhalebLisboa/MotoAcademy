package com.project.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextView txtSignIn;
    EditText txtBoxEmail;
    EditText txtBoxPassword;
    private FirebaseAuth mAuth;
    ConstraintLayout cnstLoading;
    String TAG = "Login";

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent actionHome = new Intent(this, HomeActivity.class);
            startActivity(actionHome);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        mAuth = FirebaseAuth.getInstance();

        btnLogin.setOnClickListener(view -> {
            if (txtBoxEmail.getText().toString().isEmpty() && txtBoxPassword.getText().toString().isEmpty()){
                Snackbar.make(view, "Preencha os campos vazios", Snackbar.LENGTH_LONG).show();
            } else {
                String email, password;
                email = txtBoxEmail.getText().toString();
                password = txtBoxPassword.getText().toString();
                cnstLoading.setVisibility(View.VISIBLE);
                logIn(email, password);
            }
        });

        txtSignIn.setOnClickListener(view -> {
            Intent actionGoToRegister = new Intent(this, ActivityRegister.class);
            startActivity(actionGoToRegister);
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.config:
                Intent secondActivity = new Intent(this, SecondActivity.class);
                startActivity(secondActivity);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void onClickGeneric(View view){
        Log.e("Info", "Apertou o botão");
        Snackbar.make(view, "Realizar ação", Snackbar.LENGTH_LONG).show();
    }

    void bindViews(){
        btnLogin = findViewById(R.id.btn_login);
        txtSignIn = findViewById(R.id.txt_create_account);
        txtBoxEmail = findViewById(R.id.edtText_name);
        txtBoxPassword = findViewById(R.id.edtText_password);
        cnstLoading = findViewById(R.id.constraint_loading);

    }

    void logIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Log.d(TAG, "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent actionHome = new Intent(this, HomeActivity.class);
                        Toast.makeText(this, "Login realizado :)", Toast.LENGTH_LONG).show();
                        startActivity(actionHome);
                        finish();
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                        Toast.makeText(this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }
}