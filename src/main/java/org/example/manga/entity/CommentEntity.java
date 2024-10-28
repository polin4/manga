package org.example.manga.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="Comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentID;

    @Column(name = "text")
    private String text;


    @Column(name = "rating")
    private int rating;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    //ссылка на эту же сущность parent comment
    //????
    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    private CommentEntity parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> childComments;

    @ManyToOne
    @JoinColumn(name = "manga_id")
    private MangaEntity manga;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    // Геттеры и сеттеры
    public Long getCommentID() {
        return commentID;
    }

    public void setCommentID(Long commentID) {
        this.commentID = commentID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CommentEntity getParentComment() {
        return parentComment;
    }

    public void setParentComment(CommentEntity parentComment) {
        this.parentComment = parentComment;
    }

    public List<CommentEntity> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<CommentEntity> childComments) {
        this.childComments = childComments;
    }

    public MangaEntity getManga() {
        return manga;
    }

    public void setManga(MangaEntity manga) {
        this.manga = manga;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


}
