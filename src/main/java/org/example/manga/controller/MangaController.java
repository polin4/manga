package org.example.manga.controller;


import org.example.manga.entity.MangaEntity;
import org.example.manga.entity.UserEntity;
import org.example.manga.repository.MangaRepository;
import org.example.manga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/manga")
public class MangaController {

    @Autowired
    private MangaRepository mangaRepository;

    @Autowired
    private UserRepository userRepository; // Inject the UserRepository to fetch UserEntity

    // Method to add a new manga
    @PostMapping(path = "/add")
    public String addNewManga(@RequestParam String name,
                              @RequestParam Long authorId, // Accept an author ID instead of a name
                              @RequestParam String description,
                              @RequestParam int rating) {
        MangaEntity manga = new MangaEntity();
        manga.setName(name);
        manga.setDescription(description);
        manga.setRating(rating);

        // Fetch UserEntity by ID and set as author
        UserEntity author = userRepository.findById(authorId).orElse(null);
        if (author == null) {
            return "Author Not Found";
        }
        manga.setAuthor(author);

        mangaRepository.save(manga);
        return "Manga Saved";
    }

    // Method to get all manga
    @GetMapping(path = "/all")
    public Iterable<MangaEntity> getAllManga() {
        return mangaRepository.findAll();
    }

    // Method to get manga by ID
    @GetMapping(path = "/{id}")
    public MangaEntity getMangaById(@PathVariable Long id) {
        return mangaRepository.findById(id).orElse(null);
    }

    // Method to update manga information
    @PutMapping(path = "/update/{id}")
    public String updateManga(@PathVariable Long id,
                              @RequestParam String name,
                              @RequestParam Long authorId, // Accept an author ID instead of a name
                              @RequestParam String description,
                              @RequestParam int rating) {
        MangaEntity manga = mangaRepository.findById(id).orElse(null);
        if (manga != null) {
            manga.setName(name);
            manga.setDescription(description);
            manga.setRating(rating);

            // Fetch UserEntity by ID and set as author
            UserEntity author = userRepository.findById(authorId).orElse(null);
            if (author == null) {
                return "Author Not Found";
            }
            manga.setAuthor(author);

            mangaRepository.save(manga);
            return "Manga Updated";
        } else {
            return "Manga Not Found";
        }
    }
}