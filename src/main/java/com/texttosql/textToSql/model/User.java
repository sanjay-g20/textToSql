package com.texttosql.textToSql.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Data
@Entity
@Table(name = "test-user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "username")  // Escaping 'username' column
    private String username;

    @NotNull
    @Column(name = "password")  // Escaping 'password' column
    private String password;

    @NotNull
    @Column(name = "role")  // Escaping 'role' column
    private String role;

}
