package com.texttosql.textToSql.controller;

import com.texttosql.textToSql.model.SqlResponse;
import com.texttosql.textToSql.service.TextToSqlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TextToSqlController {

    private final TextToSqlService textToSqlService;

    public TextToSqlController(TextToSqlService textToSqlService) {
        this.textToSqlService = textToSqlService;
    }

    @PostMapping("/convert")
    public SqlResponse convertToSql(@RequestBody Map<String,String> textQuery) {
        return textToSqlService.convertTextToSql(textQuery);
    }

    @PostMapping("/execute")
    public ResponseEntity<Object> executeSql(@RequestBody String sqlQuery) {
//        Object results = textToSqlService.executeSqlQuery(sqlQuery);
        System.out.println("Trying to execute"+sqlQuery);
        Object results = textToSqlService.executeDynamicSqlQuery(sqlQuery);
        return ResponseEntity.ok(results);
    }

//    @GetMapping("/students")x
//    public ResponseEntity<List<Student>> getAllStudents() {
//        List<Student> students = studentService.getAllStudents();
//        System.out.println(students);
//        return ResponseEntity.ok(students);
//    }


}