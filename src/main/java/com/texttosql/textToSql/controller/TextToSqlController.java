package com.texttosql.textToSql.controller;

import com.texttosql.textToSql.model.SqlResponse;
import com.texttosql.textToSql.service.TextToSqlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TextToSqlController {

    private final TextToSqlService textToSqlService;

    public TextToSqlController(TextToSqlService textToSqlService) {
        this.textToSqlService = textToSqlService;
    }

    @PostMapping("/convert")
    public SqlResponse convertToSql(@RequestBody String textQuery) {
        return textToSqlService.convertTextToSql(textQuery);
    }

    @PostMapping("/execute")
    public ResponseEntity<Object> executeSql(@RequestBody String sqlQuery) {
        Object results = textToSqlService.executeSqlQuery(sqlQuery);
        return ResponseEntity.ok(results);
    }
}
