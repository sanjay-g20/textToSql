package com.texttosql.textToSql.service;

import com.texttosql.textToSql.model.SqlResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class TextToSqlService {

    private final AIIntegrationService aiIntegrationService;
    private final DatabaseExecutor databaseExecutor;
    private final JdbcTemplate jdbcTemplate;

    public TextToSqlService(AIIntegrationService aiIntegrationService, DatabaseExecutor databaseExecutor, JdbcTemplate jdbcTemplate) {
        this.aiIntegrationService = aiIntegrationService;
        this.databaseExecutor = databaseExecutor;
        this.jdbcTemplate = jdbcTemplate;
    }

    public SqlResponse convertTextToSql(String textQuery) {
        String sqlQuery = aiIntegrationService.callAiModel(textQuery);
//        return (String) executeSqlQuery(sqlQuery);
        return new SqlResponse(sqlQuery);
    }


    public Object executeSqlQuery(String sqlQuery) {
        return databaseExecutor.runQuery(sqlQuery);
    }

    // Method to execute a dynamic SQL query
    public String executeDynamicSqlQuery(String sqlQuery) {
        // Execute the query and return the results
        String sqlQueryFromAi = aiIntegrationService.callAiModel(sqlQuery);
        System.out.println("sqlQueryFromAi:"+sqlQueryFromAi);
        return sqlQueryFromAi;
    }

}
