package org.example.manga.service;

import org.example.manga.entity.FolderEntity;
import org.example.manga.entity.MangaEntity;
import org.example.manga.entity.UserEntity;
import org.example.manga.repository.FolderRepository;
import org.example.manga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private UserRepository userRepository;

    // Создание новой папки
    public FolderEntity createFolder(String name, Long userId) {
        Optional<UserEntity> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }

        FolderEntity folder = new FolderEntity();
        folder.setName(name);
        folder.setUser(userOpt.get());
        return folderRepository.save(folder);
    }

    // Получение всех папок
    public List<FolderEntity> getAllFolders() {
        return (List<FolderEntity>) folderRepository.findAll();
    }

    // Получение папок по ID пользователя
    public List<FolderEntity> getFoldersByUserId(Long userId) {
        return folderRepository.findByUser_UserID(userId);
    }

    // Добавление манги в папку
    public FolderEntity addMangaToFolder(Long folderId, MangaEntity manga) {
        Optional<FolderEntity> folderOpt = folderRepository.findById(folderId);
        if (folderOpt.isEmpty()) {
            throw new IllegalArgumentException("Folder not found with ID: " + folderId);
        }

        FolderEntity folder = folderOpt.get();
        folder.addManga(manga);
        return folderRepository.save(folder);
    }

    // Удаление манги из папки
    public FolderEntity removeMangaFromFolder(Long folderId, MangaEntity manga) {
        Optional<FolderEntity> folderOpt = folderRepository.findById(folderId);
        if (folderOpt.isEmpty()) {
            throw new IllegalArgumentException("Folder not found with ID: " + folderId);
        }

        FolderEntity folder = folderOpt.get();
        folder.removeManga(manga);
        return folderRepository.save(folder);
    }

    // Удаление папки по ID
    public void deleteFolder(Long folderId) {
        if (!folderRepository.existsById(folderId)) {
            throw new IllegalArgumentException("Folder not found with ID: " + folderId);
        }
        folderRepository.deleteById(folderId);
    }
}