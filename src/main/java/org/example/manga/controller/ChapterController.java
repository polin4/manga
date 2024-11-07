package org.example.manga.controller;

import org.example.manga.entity.ChapterEntity;
import org.example.manga.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path = "/chapter") // URL будет начинаться с /chapter
public class ChapterController {

    @Autowired
    private ChapterRepository chapterRepository;

    // POST запрос для добавления новой главы
    @PostMapping(path = "/add")
    public @ResponseBody String addNewChapter(@RequestParam String chapterName,
                                              @RequestParam String frame,
                                              @RequestParam int chapterNumber,
                                              @RequestParam Long mangaID) {
        ChapterEntity chapter = new ChapterEntity();
        chapter.setChapterName(chapterName);
        chapter.setFrame(frame);
        chapter.setChapterNumber(chapterNumber);
        chapter.setMangaId(mangaID);
        chapterRepository.save(chapter);
        return "Chapter saved";
    }

    // GET запрос для получения всех глав
    @GetMapping(path="/chapters")
    public @ResponseBody List<ChapterEntity> getAllChapters() {
        // Получаем Iterable и преобразуем его в List с использованием стримов
        Iterable<ChapterEntity> iterableChapters = chapterRepository.findAll();
        return StreamSupport.stream(iterableChapters.spliterator(), false)
                .collect(Collectors.toList());
    }
}
