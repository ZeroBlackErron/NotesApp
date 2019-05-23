package com.arosado.moviles.notesapp.models;

import com.orm.dsl.Table;

@Table
public class Note {

    private Long id;
    private String title;
    private String description;
    private String date;
    private String favorite;
    private String store;
    private Long userId;

    public Note() {

    }

    public Note(String title, String description, String date, String favorite, String store, Long userId) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.favorite = favorite;
        this.store = store;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                ", favorite='" + favorite + '\'' +
                ", store='" + store + '\'' +
                ", userId=" + userId +
                '}';
    }
}
