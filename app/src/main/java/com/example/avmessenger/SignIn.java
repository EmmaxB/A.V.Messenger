package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profileImageView;
    private EditText usernameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        profileImageView = findViewById(R.id.profileImageView);  // Profile picture
        usernameEditText = findViewById(R.id.username);  // Username input
        emailEditText = findViewById(R.id.email);  // Email input
        passwordEditText = findViewById(R.id.password);  // Password input
        confirmPasswordEditText = findViewById(R.id.confirmPassword);  // Confirm password input
        signUpButton = findViewById(R.id.signUpButton);  // Sign up button

        // Sign up button click listener
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(ProfileActivity.this, "Please enter your username", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(ProfileActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(ProfileActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(ProfileActivity.this, "Please confirm your password", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(ProfileActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Simulate sign up logic (no backend)
                    Toast.makeText(ProfileActivity.this, "Sign Up Successful!", Toast.LENGTH_SHORT).show();
                    // Navigate to another activity (e.g., MainActivity)
                    Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
