package com.texttosql.textToSql.service;

import com.texttosql.textToSql.model.Student;
import com.texttosql.textToSql.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        System.out.println("studentRepository.findAll()"+studentRepository.findAll());
        return studentRepository.findAll();
    }
}
