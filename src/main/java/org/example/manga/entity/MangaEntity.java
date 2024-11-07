package org.example.manga.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// Add other necessary imports

@Entity
@Table(name = "Folder")
public class MangaEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long mangaId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author; //связь с таблицей Пользователь по роли автор по айдишнику

    private String description;


    private int rating;

    private StatusManga status;

    // Геттеры и сеттеры

    public Long getMangaID() {
        return mangaId;
    }

    public void setMangaID(Long mangaID) {
        this.mangaId = mangaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public StatusManga getStatus() {
        return status;
    }

    public void setStatus(StatusManga status) {
        this.status = status;
    }
}
