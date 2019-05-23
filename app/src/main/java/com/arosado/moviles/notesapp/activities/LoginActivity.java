package com.arosado.moviles.notesapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.arosado.moviles.notesapp.R;
import com.arosado.moviles.notesapp.models.User;
import com.arosado.moviles.notesapp.repositories.UserRepository;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextInputEditText nicknameInput;
    private TextInputEditText passwordInput;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Inicio de sesión");

        nicknameInput = findViewById(R.id.nickname_login_input);
        passwordInput = findViewById(R.id.password_login_input);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {
        String nickname = nicknameInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if(nickname.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Complete los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        User user = UserRepository.login(nickname, password);

        if(user == null) {
            Toast.makeText(this, "Credenciales no válidas", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("nickname", nickname);
        intent.putExtra("id", user.getId());
        startActivity(intent);
        finish();
    }
}
