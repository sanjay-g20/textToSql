package com.texttosql.textToSql.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private int graduationYear;
    private double gpa;

}
