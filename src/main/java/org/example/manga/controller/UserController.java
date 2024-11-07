package org.example.manga.controller;

import org.example.manga.entity.Role;
import org.example.manga.entity.UserEntity;
import org.example.manga.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestParam String name,
                                          @RequestParam String mail,
                                          @RequestParam String password,
                                          @RequestParam Role role) {
        UserEntity user = new UserEntity();
        user.setUserName(name);
        user.setMail(mail);
        user.setPassword(password);
        user.setRole(role);

        userRepository.save(user);
        return ResponseEntity.ok("User saved successfully");
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Update user information
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id,
                                             @RequestParam String name,
                                             @RequestParam String mail,
                                             @RequestParam Role role) {
        Optional<UserEntity> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setUserName(name);
            user.setMail(mail);
            user.setRole(role);

            userRepository.save(user);
            return ResponseEntity.ok("User updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
