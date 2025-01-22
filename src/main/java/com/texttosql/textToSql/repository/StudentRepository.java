package com.texttosql.textToSql.repository;

import com.texttosql.textToSql.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Custom queries can be added here if needed

}
