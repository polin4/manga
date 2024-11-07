package org.example.manga.controller;

import org.example.manga.entity.CommentEntity;
import org.example.manga.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/comments") // Основной путь для комментариев
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    // Метод для создания нового комментария
    @PostMapping("/add")
    public @ResponseBody String addNewComment(@RequestParam String text,
                                              @RequestParam Long userId,
                                              @RequestParam Long mangaId,
                                              @RequestParam(required = false) Long parentCommentId) {
        CommentEntity comment = new CommentEntity();
        comment.setText(text);
        comment.setUserId(userId);  // Предполагается, что у вас есть метод установки пользователя
        comment.setMangaId(mangaId); // Предполагается, что у вас есть метод установки манги
        comment.setParentCommentId(parentCommentId); // Установка ID родительского комментария, если есть

        commentRepository.save(comment); // Сохранение комментария в БД
        return "Comment Saved";
    }

    // Метод для получения всех комментариев
    @GetMapping("/all")
    public @ResponseBody List<CommentEntity> getAllComments() {
        // Получаем Iterable и преобразуем его в List
        Iterable<CommentEntity> iterableComments = commentRepository.findAll();
        List<CommentEntity> commentList = new ArrayList<>();
        iterableComments.forEach(commentList::add);
        return commentList;
    }

    // Метод для получения комментариев по ID манги
    @GetMapping("/manga/{mangaId}")
    public @ResponseBody List<CommentEntity> getCommentsByMangaId(@PathVariable Long mangaId) {
        // Логика для получения комментариев по ID манги (можно реализовать в репозитории)
        // Примерный код, который нужно реализовать:
        List<CommentEntity> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comment -> {
            if (comment.getMangaId().equals(mangaId)) {
                comments.add(comment);
            }
        });
        return comments;
    }
}
