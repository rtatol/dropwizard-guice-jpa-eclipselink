package com.example.dw.jpa.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class Config extends Configuration {

    @NotEmpty
    private String message;
    private DbConfig dbConfig;

    @JsonProperty
    public String getMessage() {
        return message;
    }

    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty
    public DbConfig getDbConfig() {
        return dbConfig;
    }

    @JsonProperty
    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
}
