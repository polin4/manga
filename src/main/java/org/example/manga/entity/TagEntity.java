package org.example.manga.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tag")
public class TagEntity {

    @Id
    private String tagName;

    @ManyToMany
    @JoinTable(
            name = "manga_tag",
            joinColumns = @JoinColumn(name = "tag_name"),
            inverseJoinColumns = @JoinColumn(name = "manga_id")
    )
    private List<MangaEntity> mangas;

    // Геттеры и сеттеры

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<MangaEntity> getMangas() {
        return mangas;
    }

    public void setMangas(List<MangaEntity> mangas) {
        this.mangas = mangas;
    }
}
