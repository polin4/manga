package org.example.manga.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;
// Add other necessary imports

@Entity
@Table(name = "Chapter")
public class ChapterEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long chapterId;

    private String chapterName;

    private String frame;

    private int chapterNumber;

    private Long mangaId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserEntity author;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ChapterStatus status;

    // Getters and Setters

    public Long getChapterId() {
        return chapterId;
    }

    public Long getMangaId() {
        return mangaId;
    }

    public void setChapterId(Long chapterId) {
        this.chapterId = chapterId;
    }

    public void setMangaId(Long mangaId) {
        this.mangaId = mangaId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public void setAuthor(UserEntity author) {
        this.author = author;
    }

    public ChapterStatus getStatus() {
        return status;
    }

    public void setStatus(ChapterStatus status) {
        this.status = status;
    }
}
