package org.example.manga.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
// Add other necessary imports

@Entity
@Table(name = "Tag")
public class TagEntity {

    @Id
    @Column(name = "tag_name", nullable = false, unique = true)
    private String tagName;

    @ManyToMany
    @JoinTable(
            name = "manga_tag",
            joinColumns = @JoinColumn(name = "tag_name"),
            inverseJoinColumns = @JoinColumn(name = "manga_id")
    )
    private List<MangaEntity> mangas;

    // Getters and Setters
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
