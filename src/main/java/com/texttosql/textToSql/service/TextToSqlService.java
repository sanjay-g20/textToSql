package com.texttosql.textToSql.service;

import com.texttosql.textToSql.model.SqlResponse;
import org.springframework.stereotype.Service;

@Service
public class TextToSqlService {

    private final AIIntegrationService aiIntegrationService;
    private final DatabaseExecutor databaseExecutor;

    public TextToSqlService(AIIntegrationService aiIntegrationService, DatabaseExecutor databaseExecutor) {
        this.aiIntegrationService = aiIntegrationService;
        this.databaseExecutor = databaseExecutor;
    }

    public SqlResponse convertTextToSql(String textQuery) {
        String sqlQuery = aiIntegrationService.callAiModel(textQuery);
        return new SqlResponse(sqlQuery);
    }


    public Object executeSqlQuery(String sqlQuery) {
        return databaseExecutor.runQuery(sqlQuery);
    }
}
