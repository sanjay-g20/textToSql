package com.texttosql.textToSql.model;

public class SqlResponse {
    private String sqlQuery;

    public SqlResponse(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
}
