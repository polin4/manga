package org.example.manga.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Folder")
public class MangaEntity {

    @Id
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
        return mangaID;
    }

    public void setMangaID(Long mangaID) {
        this.mangaID = mangaID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public List<TagEntity> getTags() {
        return tags;
    }

    public void setTags(List<TagEntity> tags) {
        this.tags = tags;
    }
}
