package com.example.matule;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class addprofile extends AppCompatActivity {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,}$");
    private Button nextButton;

    private TextInputLayout FirstName;
    private TextInputLayout MiddleName;
    private TextInputLayout LastName;
    private TextInputLayout BirthDate;
    private TextInputLayout six;
    private TextInputLayout email;

    private EditText emailEdit;
    private EditText sixEdit;
    private EditText BirthDateEdit;
    private EditText LastNameEdit;
    private EditText MiddleNameEdit;
    private EditText FirstNameEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_addprofile);

        emailEdit = findViewById(R.id.emailEdit);
        sixEdit = findViewById(R.id.sixEdit);
        BirthDateEdit = findViewById(R.id.BirthDateEdit);
        LastNameEdit = findViewById(R.id.LastNameEdit);
        MiddleNameEdit = findViewById(R.id.MiddleNameEdit);
        FirstNameEdit = findViewById(R.id.FirstNameEdit);
        FirstNameEdit = findViewById(R.id.FirstNameEdit);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {
            if (validateForm()) {
                Intent intent = new Intent(addprofile.this,PasswordEdit.class);
                startActivity(intent);
            }
        });
    }
    private boolean validateEmail() {
        String email2 = emailEdit.getText().toString().trim();

        if (email2.isEmpty()) {
            email.setError("Введите email");
            return false;
        } else if (!EMAIL_PATTERN.matcher(email2).matches()) {
            email.setError("Некорректный email. Пример: name@domain.ru");
            return false;
        } else {
            email.setError(null);
            return true;
        }
    }

    private boolean validateForm() {
        boolean emailValid = validateEmail();
        boolean sixTextValid = validatesixText();
        boolean BirthDate = BirthDateForm();
        boolean LastNameForm =LastNameForm();
        boolean MiddleNameForm=MiddleNameForm();
        boolean FirstNameForm=FirstNameForm();
        return emailValid && sixTextValid && BirthDate && LastNameForm && MiddleNameForm && FirstNameForm;
    }

    private boolean validatesixText() {
        String sixText = sixEdit.getText().toString();

        if (sixText.isEmpty()) {
            sixEdit.setError("Введите пол (Мужской/Женский");
            return false;
        } else if (!sixText.equals("Мужской") || !sixText.equals("Женский")) {
            sixEdit.setError("Напишите пол");
            return false;
        } else {
            sixEdit.setError(null);
            return true;
        }
    }
    private boolean BirthDateForm() {
        String BirthDate2 = BirthDateEdit.getText().toString();

        if (BirthDate2.isEmpty()) {
            BirthDate.setError("Введите дату рождения (Формат дд.мм.гг");
            return false;
        } else if (BirthDate2.length() > 9) {
            BirthDate.setError("Введите дату рождения в правильном формате (дд.мм.гг)");
            return false;
        } else {
            BirthDate.setError(null);
            return true;
        }
    }
    private boolean LastNameForm() {
        String LastName2 = LastNameEdit.getText().toString();

        if (LastName2.isEmpty()) {
            LastName.setError("Введите фамилию");
            return false;
        } else if (LastName2.length() <2 ) {
            LastName.setError("Пожалуйста введите фамилию содержащие больше 1 буквы");
            return false;
        } else {
            LastName.setError(null);
            return true;
        }
    }
    private boolean MiddleNameForm() {
        String MiddleName2 = MiddleNameEdit.getText().toString();

        if (MiddleName2.isEmpty()) {
            MiddleName.setError("Введите отчество");
            return false;
        } else if (MiddleName2.length() <2 ) {
            MiddleName.setError("Пожалуйста введите отчество содержащие больше 1 буквы");
            return false;
        } else {
            MiddleName.setError(null);
            return true;
        }
    }
    private boolean FirstNameForm() {
        String FirstName2 = FirstNameEdit.getText().toString();

        if (FirstName2.isEmpty()) {
            FirstName.setError("Введите имя");
            return false;
        } else if (FirstName2.length() <2 ) {
            FirstName.setError("Пожалуйста введите имя содержащие больше 1 буквы");
            return false;
        } else {
            FirstName.setError(null);
            return true;
        }
    }
}