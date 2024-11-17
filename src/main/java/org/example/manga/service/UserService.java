package org.example.manga.service;

import org.example.manga.entity.Role;
import org.example.manga.entity.UserEntity;
import org.example.manga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Создание нового пользователя
    public UserEntity createUser(String name, String mail, String password, Role role) {
        UserEntity user = new UserEntity();
        user.setUserName(name);
        user.setMail(mail);
        user.setPassword(password);
        user.setRole(role);
        return userRepository.save(user);
    }

    // Получение пользователя по ID
    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Обновление информации о пользователе
    public Optional<UserEntity> updateUser(Long id, String name, String mail, Role role) {
        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setUserName(name);
            user.setMail(mail);
            user.setRole(role);
            return Optional.of(userRepository.save(user));
        }

        return Optional.empty();
    }

    // Удаление пользователя по ID
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Получение всех пользователей
    public List<UserEntity> getAllUsers() {
        return (List<UserEntity>) userRepository.findAll();
    }
}