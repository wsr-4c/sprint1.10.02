package com.example.matule;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

public class PasswordEdit extends AppCompatActivity {
    private Button nextButton;
    private EditText PasswordEdit;
    private EditText PasswordCheck;
    private TextInputLayout Password;
    private TextInputLayout passwordInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_password_edit);
        View nextButton = findViewById(R.id.nextButton);
        PasswordEdit = findViewById(R.id.PasswordEdit);
        nextButton.setOnClickListener(v -> {
            if (validateForm()) {
                Intent intent = new Intent(PasswordEdit.this,Profile.class);
                startActivity(intent);
            }
        });
    }
    private boolean validatePassword() {
        String password2 = PasswordEdit.getText().toString();
        String password3 = PasswordCheck.getText().toString();

        if (password2.isEmpty()) {
            Password.setError("Введите пароль");
            passwordInputLayout.setError("Введите пароль");
            return false;
        } else if (!password2.equals(password3)) {
            Password.setError("Пароли должны быть одинаковыми");
            passwordInputLayout.setError("Пароли должны быть одинаковыми");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }

    private boolean validateForm() {
        return validatePassword();
    }
}