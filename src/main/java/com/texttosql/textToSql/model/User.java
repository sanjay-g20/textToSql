package com.texttosql.textToSql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
//change to actual table name
@Table(name = "test-user")
public class User {

    @Id
    private Long id;

    @Column(name = "username")  // Escaping 'username' column
    private String username;

    @Column(name = "password")  // Escaping 'password' column
    private String password;

    @Column(name = "role")  // Escaping 'role' column
    private String role;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
