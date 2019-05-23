package com.arosado.moviles.notesapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arosado.moviles.notesapp.R;
import com.arosado.moviles.notesapp.models.Note;
import com.arosado.moviles.notesapp.repositories.NoteRepository;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoteActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText descriptionInput;
    private Button createNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        titleInput = findViewById(R.id.title_input);
        descriptionInput = findViewById(R.id.description_input);
        createNoteButton = findViewById(R.id.create_note_button);

        createNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNote();
            }
        });
    }

    public void createNote() {
        String title = titleInput.getText().toString().trim();
        String description = descriptionInput.getText().toString().trim();
        Date createdAt = new Date();

        String date = new SimpleDateFormat("dd-MM-yyyy").format(createdAt);

        if(title.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Complete los campos.", Toast.LENGTH_SHORT).show();
            return;
        }

        Long userId = getIntent().getExtras().getLong("userId");

        NoteRepository.addNote(title, description,date,"no", "no", userId);

        Toast.makeText(this, "Nota añadida.", Toast.LENGTH_SHORT).show();

        finish();
    }
}
