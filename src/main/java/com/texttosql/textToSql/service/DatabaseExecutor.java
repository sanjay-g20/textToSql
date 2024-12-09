package com.texttosql.textToSql.service;

//import com.texttosql.textToSql.repository.CustomQueryRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DatabaseExecutor {

//    private final CustomQueryRepository customQueryRepository;

//    public DatabaseExecutor(CustomQueryRepository customQueryRepository) {
//        this.customQueryRepository = customQueryRepository;
//    }

    public DatabaseExecutor(){

    }

    public List<Object> runQuery(String sqlQuery) {
        // Example static call; use dynamic logic as needed
//        return customQueryRepository.findWithCustomQuery("value");
        return Collections.singletonList("Query output from database");
    }
}
