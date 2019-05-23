package com.arosado.moviles.notesapp.repositories;

import com.arosado.moviles.notesapp.models.Note;
import com.orm.SugarRecord;

import java.util.List;

public class NoteRepository {

    public static List<Note> getAllNotes() {
        List<Note> notes = SugarRecord.listAll(Note.class);
        return notes;
    }

    public static List<Note> getNotesByUserId(Long userId) {
        List<Note> notes = SugarRecord.find(Note.class, "user_id=?", userId.toString());
        return notes;
    }

    public static void addNote(String title, String description, String date, String favorite, String store, Long userId){
        Note note = new Note(title, description, date, favorite, store, userId);
        SugarRecord.save(note);
    }

    public static void editNote(Long id, String title, String description, Long userId){
        Note note = SugarRecord.findById(Note.class, id);
        note.setTitle(title);
        note.setDescription(description);
        note.setUserId(userId);
        SugarRecord.save(note);
    }

    public static void deleteNote(Long id){
        Note note = SugarRecord.findById(Note.class, id);
        SugarRecord.delete(note);
    }
}
