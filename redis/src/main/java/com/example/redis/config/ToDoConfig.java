package com.example.mongo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ToDoConfig {

    private Environment environment;
    public ToDoConfig(Environment environment){
        this.environment = environment;
    }

    /*
    @Bean
    @DependsOn("embeddedMongoServer")
    public MongoClient mongoClient() {
        int port = this.environment.getProperty("local.mongo.port", Integer.class);
        return new MongoClient("localhost",port);
    }
    */

}
