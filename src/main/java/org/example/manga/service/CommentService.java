package org.example.manga.service;

import org.example.manga.entity.CommentEntity;
import org.example.manga.entity.MangaEntity;
import org.example.manga.entity.UserEntity;
import org.example.manga.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Добавить новый комментарий
    public CommentEntity addComment(String text, Long userId, Long mangaId, Long parentCommentId) {
        CommentEntity comment = new CommentEntity();
        comment.setText(text);
        comment.setDate(LocalDateTime.now());
        comment.setRating(0); // Начальный рейтинг комментария

        // Устанавливаем ID пользователя и манги
        comment.setUserId(userId);
        comment.setMangaId(mangaId);

        // Если комментарий является ответом на другой комментарий
        if (parentCommentId != null) {
            Optional<CommentEntity> parentComment = commentRepository.findById(parentCommentId);
            parentComment.ifPresent(comment::setParentComment);
        }

        return commentRepository.save(comment);
    }

    // Получить все комментарии
    public List<CommentEntity> getAllComments() {
        return (List<CommentEntity>) commentRepository.findAll();
    }

    // Получить комментарии по ID манги
    public List<CommentEntity> getCommentsByMangaId(Long mangaId) {
        return getAllComments().stream()
                .filter(comment -> comment.getMangaId().equals(mangaId))
                .toList();
    }

    // Получить комментарии по ID пользователя
    public List<CommentEntity> getCommentsByUserId(Long userId) {
        return getAllComments().stream()
                .filter(comment -> comment.getUserId().equals(userId))
                .toList();
    }

    // Удалить комментарий по ID
    public boolean deleteComment(Long commentId) {
        Optional<CommentEntity> comment = commentRepository.findById(commentId);
        if (comment.isPresent()) {
            commentRepository.delete(comment.get());
            return true;
        }
        return false;
    }

    // Найти комментарий по ID
    public Optional<CommentEntity> findCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }
}