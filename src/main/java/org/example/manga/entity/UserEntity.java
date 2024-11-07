package org.example.manga.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// Add other necessary imports

@Entity
@Table(name = "AppUser")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userID;

    private String username;

    private String mail;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    // Геттеры и сеттеры

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
