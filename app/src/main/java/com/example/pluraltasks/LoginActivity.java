package com.example.pluraltasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button)findViewById(R.id.login_button);
        emailEditText = (EditText) findViewById(R.id.login_email);
        passwordEditText = (EditText)findViewById(R.id.login_password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                LoginUserInput input = new LoginUserInput(email, password);
                handleLogin(input);
            }
        });
    }

    public void handleLogin(LoginUserInput input) {
        boolean isEmailValid = Utilities.isValidEmail(input.email);

        if (isEmailValid) {
            Intent loginIntent = new Intent(this, TaskListActivity.class);
            loginIntent.putExtra("EMAIL", input.email);
            startActivity(loginIntent);
        }
    }
}