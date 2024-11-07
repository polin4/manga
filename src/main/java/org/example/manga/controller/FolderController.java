package org.example.manga.controller;

import org.example.manga.entity.FolderEntity;
import org.example.manga.entity.UserEntity;
import org.example.manga.repository.FolderRepository;
import org.example.manga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/folders")
public class FolderController {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private UserRepository userRepository;

    // Метод для создания новой папки
    @PostMapping("/add")
    public @ResponseBody String addNewFolder(
            @RequestParam String name,
            @RequestParam Long userId
    ) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return "User not found";
        }

        FolderEntity folder = new FolderEntity();
        folder.setName(name);
        folder.setUser(user);
        folderRepository.save(folder);
        return "Folder saved";
    }

    // Метод для получения всех папок
    @GetMapping("/all")
    public @ResponseBody List<FolderEntity> getAllFolders() {
        List<FolderEntity> folders = new ArrayList<>();
        folderRepository.findAll().forEach(folders::add);
        return folders;
    }

    // Метод для получения папок по ID пользователя
    @GetMapping("/user/{userId}")
    public @ResponseBody List<FolderEntity> getFoldersByUserId(@PathVariable Long userId) {
        List<FolderEntity> userFolders = folderRepository.findByUser_UserID(userId);
        return userFolders;
    }
}
