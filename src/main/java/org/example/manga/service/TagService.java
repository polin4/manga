
package org.example.manga.service;

import org.example.manga.entity.MangaEntity;
import org.example.manga.entity.TagEntity;
import org.example.manga.repository.MangaRepository;
import org.example.manga.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private MangaRepository mangaRepository;

    // Создать новый тег
    public TagEntity createTag(String tagName) {
        if (tagRepository.existsById(tagName)) {
            throw new RuntimeException("Tag with this name already exists");
        }

        TagEntity tag = new TagEntity();
        tag.setTagName(tagName);
        tag.setMangas(new ArrayList<>()); // Инициализация пустого списка манги
        return tagRepository.save(tag);
    }

    // Получить все теги
    public List<TagEntity> getAllTags() {
        List<TagEntity> tagList = new ArrayList<>();
        tagRepository.findAll().forEach(tagList::add);
        return tagList;
    }

    // Связать тег с мангой
    public TagEntity addMangaToTag(String tagName, Long mangaId) {
        TagEntity tag = tagRepository.findById(tagName)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
        MangaEntity manga = mangaRepository.findById(mangaId)
                .orElseThrow(() -> new RuntimeException("Manga not found"));

        if (!tag.getMangas().contains(manga)) {
            tag.getMangas().add(manga);
        }
        return tagRepository.save(tag);
    }

    // Получить мангу по тегу
    public List<MangaEntity> getMangasByTag(String tagName) {
        TagEntity tag = tagRepository.findById(tagName)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
        return tag.getMangas();
    }
}