package org.example.manga.service;

import org.example.manga.entity.MangaEntity;
import org.example.manga.entity.StatusManga;
import org.example.manga.entity.UserEntity;
import org.example.manga.repository.MangaRepository;
import org.example.manga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MangaService {

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    private UserRepository userRepository;

    // Создать новую мангу
    public MangaEntity createManga(String name, Long authorId, String description, int rating, StatusManga status) {
        UserEntity author = userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        MangaEntity manga = new MangaEntity();
        manga.setName(name);
        manga.setAuthor(author);
        manga.setDescription(description);
        manga.setRating(rating);
        manga.setStatus(status);

        return mangaRepository.save(manga);
    }

    // Получить все манги
    public List<MangaEntity> getAllManga() {
        return (List<MangaEntity>) mangaRepository.findAll();
    }

    // Получить мангу по ID
    public MangaEntity getMangaById(Long id) {
        return mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found"));
    }

    // Обновить информацию о манге
    public MangaEntity updateManga(Long id, String name, Long authorId, String description, int rating, StatusManga status) {
        MangaEntity manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found"));

        UserEntity author = userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        manga.setName(name);
        manga.setAuthor(author);
        manga.setDescription(description);
        manga.setRating(rating);
        manga.setStatus(status);

        return mangaRepository.save(manga);
    }

    // Удалить мангу по ID
    public void deleteManga(Long id) {
        MangaEntity manga = mangaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manga not found"));

        mangaRepository.delete(manga);
    }
}