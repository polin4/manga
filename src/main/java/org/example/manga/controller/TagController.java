package org.example.manga.controller;

import org.example.manga.entity.TagEntity;
import org.example.manga.repository.TagRepository;
import org.example.manga.entity.MangaEntity;
import org.example.manga.repository.MangaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private MangaRepository mangaRepository;

    // Endpoint to create a new tag
    @PostMapping("/add")
    public TagEntity addTag(@RequestParam String tagName) {
        TagEntity tag = new TagEntity();
        tag.setTagName(tagName);
        return tagRepository.save(tag);
    }

    // Method to retrieve all tags
    @GetMapping("/all")
    public List<TagEntity> getAllTags() {
        List<TagEntity> tagList = new ArrayList<>();
        tagRepository.findAll().forEach(tagList::add);
        return tagList;
    }
    // Endpoint to associate a tag with a manga by ID
    @PostMapping("/{tagName}/addManga")
    public String addMangaToTag(@PathVariable String tagName, @RequestParam Long mangaId) {
        TagEntity tag = tagRepository.findById(tagName).orElse(null);
        MangaEntity manga = mangaRepository.findById(mangaId).orElse(null);

        if (tag == null || manga == null) {
            return "Tag or Manga not found";
        }

        tag.getMangas().add(manga);
        tagRepository.save(tag);
        return "Manga added to Tag";
    }
}
