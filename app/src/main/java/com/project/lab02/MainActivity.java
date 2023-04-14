package com.project.lab02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextView txtSignIn;
    EditText txtBoxEmail;
    EditText txtBoxPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();

        btnLogin.setOnClickListener(view -> {
            if (txtBoxEmail.getText().toString().isEmpty() && txtBoxPassword.getText().toString().isEmpty()){
                Snackbar.make(view, "Preencha os campos vazios", Snackbar.LENGTH_LONG).show();
            } else {

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
    }
}