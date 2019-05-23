package com.arosado.moviles.notesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.arosado.moviles.notesapp.R;
import com.arosado.moviles.notesapp.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private AppCompatActivity activity;
    private List<Note> notes;

    public NotesAdapter(AppCompatActivity activity) {
        this.activity = activity;
        notes = new ArrayList<>();
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_note, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Note note = this.notes.get(i);
        Context context = viewHolder.itemView.getContext();

        viewHolder.title.setText(note.getTitle());
        viewHolder.description.setText(note.getDescription());
        viewHolder.date.setText(note.getDate());

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_text);
            description = itemView.findViewById(R.id.description_text);
            date = itemView.findViewById(R.id.date_text);
        }
    }
}
