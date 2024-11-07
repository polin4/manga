package org.example.manga.entity;
import jakarta.persistence.*;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// Add other necessary imports

@Entity
@Table(name = "Folder")
public class FolderEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long folderID;

    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToMany
    @JoinTable(
            name = "folder_manga",
            joinColumns = @JoinColumn(name = "folder_id"),
            inverseJoinColumns = @JoinColumn(name = "manga_id")
    )
    private List<MangaEntity> mangas;
    // Геттеры и сеттеры

    public Long getFolderID() {
        return folderID;
    }

    public void setFolderID(Long folderID) {
        this.folderID = folderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<MangaEntity> getMangas() {
        return mangas;
    }

    public void setMangas(List<MangaEntity> mangas) {
        this.mangas = mangas;
    }
}
