package org.example.manga.service;

import org.example.manga.entity.ChapterEntity;
import org.example.manga.repository.ChapterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    // Метод для добавления новой главы
    public ChapterEntity addChapter(ChapterEntity chapter) {
        return chapterRepository.save(chapter);
    }

    // Получение всех глав
    public List<ChapterEntity> getAllChapters() {
        return StreamSupport.stream(chapterRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    // Получение главы по ID
    public Optional<ChapterEntity> getChapterById(Long id) {
        return chapterRepository.findById(id);
    }

    // Обновление главы
    public ChapterEntity updateChapter(Long id, ChapterEntity updatedChapter) {
        Optional<ChapterEntity> optionalChapter = chapterRepository.findById(id);

        if (optionalChapter.isPresent()) {
            ChapterEntity existingChapter = optionalChapter.get();
            existingChapter.setChapterName(updatedChapter.getChapterName());
            existingChapter.setFrame(updatedChapter.getFrame());
            existingChapter.setChapterNumber(updatedChapter.getChapterNumber());
            existingChapter.setMangaId(updatedChapter.getMangaId());
            existingChapter.setAuthor(updatedChapter.getAuthor());
            existingChapter.setStatus(updatedChapter.getStatus());
            return chapterRepository.save(existingChapter);
        } else {
            throw new IllegalArgumentException("Chapter with ID " + id + " not found.");
        }
    }

    // Удаление главы по ID
    public void deleteChapter(Long id) {
        if (chapterRepository.existsById(id)) {
            chapterRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Chapter with ID " + id + " not found.");
        }
    }
}