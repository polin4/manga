package org.example.manga.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Chapter")
public class ChapterEntity {

    @Id
    private Long chapterId;

    private String chapterName;

    private String frame;

    private int chapterNumber;

    private Long mangaId;

    @ManyToOne
    @JoinColumn(name =  "author_id")
    private UserEntity author;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ChapterStatus status; //в каком файле определять енам

    //геттеры и сеттеры
    public Long getChapterID(){
        return chapterId;
    }

    public void setChapterID(Long chapterID) {
        this.chapterId = chapterID;
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

    public Long getMangaID() {
        return mangaId;
    }

    public void setMangaID(Long mangaID) {
        this.mangaId = mangaID;
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

