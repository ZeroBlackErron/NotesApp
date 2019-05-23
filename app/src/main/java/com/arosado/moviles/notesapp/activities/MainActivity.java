package com.arosado.moviles.notesapp.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arosado.moviles.notesapp.R;
import com.arosado.moviles.notesapp.adapters.NotesAdapter;
import com.arosado.moviles.notesapp.models.Note;
import com.arosado.moviles.notesapp.repositories.NoteRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Long id;
    private String nickname;
    private TextView infoText;
    private RecyclerView notesList;
    private FloatingActionButton addNoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        infoText = findViewById(R.id.info_text);
        notesList = findViewById(R.id.notes_list);
        addNoteButton = findViewById(R.id.add_note_button);

        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });
    }


    public void addNote() {
        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("userId", id);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        notesList.setLayoutManager(new LinearLayoutManager(this));
        this.id = getIntent().getExtras().getLong("id");
        this.nickname = getIntent().getExtras().getString("nickname");

        infoText.setText("Bienvenido, " + nickname);
        List<Note> notes = NoteRepository.getNotesByUserId(id);

        NotesAdapter adapter = new NotesAdapter(this);
        adapter.setNotes(notes);

        notesList.setAdapter(adapter);
    }
}
