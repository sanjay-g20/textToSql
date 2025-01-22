package com.texttosql.textToSql.service;

//import com.texttosql.textToSql.repository.CustomQueryRepository;
import com.texttosql.textToSql.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DatabaseExecutor {
    private final StudentRepository studentRepository;

//    private final CustomQueryRepository customQueryRepository;

//    public DatabaseExecutor(CustomQueryRepository customQueryRepository) {
//        this.customQueryRepository = customQueryRepository;
//    }

    public DatabaseExecutor(StudentRepository studentRepository){

        this.studentRepository = studentRepository;
    }

    public List<Object> runQuery(String sqlQuery) {
        return Collections.singletonList(studentRepository.findAll());
    }
}
