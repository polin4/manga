package org.example.manga.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity {

    @Id
    private Long userID;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
