package com.example.matule;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class login extends AppCompatActivity {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}$");

    private EditText emailEditText;
    private EditText passwordEditText;
    private TextInputLayout emailInputLayout;
    private TextInputLayout passwordInputLayout;
    private Button nextButton;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        emailInputLayout = findViewById(R.id.emailInputLayout);
        passwordInputLayout = findViewById(R.id.passwordInputLayout);
        nextButton = findViewById(R.id.nextButton);
        registerTextView = findViewById(R.id.registerTextView);

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                validateEmail();
            }
        });

        nextButton.setOnClickListener(v -> {
            if (validateForm()) {
                Intent intent = new Intent(login.this,MainActivity.class);
                intent.putExtra("email", emailEditText.getText().toString());
                startActivity(intent);
            }
        });

        registerTextView.setOnClickListener(v -> {
            Intent intent = new Intent(login.this, addprofile.class);
            startActivity(intent);
        });
    }

    private boolean validateEmail() {
        String email = emailEditText.getText().toString().trim();

        if (email.isEmpty()) {
            emailInputLayout.setError("Введите email");
            return false;
        } else if (!EMAIL_PATTERN.matcher(email).matches()) {
            emailInputLayout.setError("Некорректный email. Пример: name@domain.ru");
            return false;
        } else {
            emailInputLayout.setError(null);
            return true;
        }
    }

    private boolean validateForm() {
        boolean emailValid = validateEmail();
        boolean passwordValid = validatePassword();
        return emailValid && passwordValid;
    }

    private boolean validatePassword() {
        String password = passwordEditText.getText().toString();

        if (password.isEmpty()) {
            passwordInputLayout.setError("Введите пароль");
            return false;
        } else if (password.length() < 8) {
            passwordInputLayout.setError("Пароль должен содержать минимум 8 символов");
            return false;
        } else {
            passwordInputLayout.setError(null);
            return true;
        }
    }

    public void togglePasswordVisibility(View view) {
        if (passwordEditText.getTransformationMethod() == null) {
            passwordEditText.setTransformationMethod(new PasswordTransformationMethod());
        } else {
            passwordEditText.setTransformationMethod(null);
        }
        passwordEditText.setSelection(passwordEditText.getText().length());
    }
}
