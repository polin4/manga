package org.example.manga.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
// Add other necessary imports

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
    @JoinColumn(name = "manga_id", insertable = false, updatable = false)
    private MangaEntity manga;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId; // ID пользователя

    @Column(name = "manga_id")
    private Long mangaId; // ID манги

    @Column(name = "parent_comment_id", insertable = false, updatable = false)
    private Long parentCommentId; // ID родительского комментария

    // Геттеры и сеттеры
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) { // Устанавливает ID пользователя
        this.userId = userId;
    }

    // Геттеры и сеттеры для mangaId

    public Long getMangaId() {
        return mangaId;
    }

    public void setMangaId(Long mangaId) { // Устанавливает ID манги
        this.mangaId = mangaId;
    }

    // Геттеры и сеттеры для parentCommentId

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) { // Устанавливает ID родительского комментария
        this.parentCommentId = parentCommentId;
    }

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
