package com.arosado.moviles.notesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arosado.moviles.notesapp.R;
import com.arosado.moviles.notesapp.repositories.UserRepository;

public class RegisterActivity extends AppCompatActivity {

    private EditText nicknameInput;
    private EditText full_nameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("Registro");

        nicknameInput = findViewById(R.id.nickname_register_input);
        full_nameInput = findViewById(R.id.full_name_register_input);
        emailInput = findViewById(R.id.email_register_input);
        passwordInput = findViewById(R.id.password_register_input);
        registerButton = findViewById(R.id.go_to_register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    public void register() {
        String nickname = nicknameInput.getText().toString().trim();
        String full_name = full_nameInput.getText().toString().trim();
        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if(nickname.isEmpty() || full_name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        Boolean token = UserRepository.verifyIfExits(nickname, email);

        if(token) {
            Toast.makeText(this, "Ya existe esa cuenta", Toast.LENGTH_SHORT).show();
        }else {
            UserRepository.addUser(nickname, full_name, email, password);
        }

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
