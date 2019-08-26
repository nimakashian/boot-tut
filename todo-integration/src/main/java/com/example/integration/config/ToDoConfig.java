package com.example.integration.config;

import com.example.integration.domain.ToDo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;


@EnableConfigurationProperties(ToDoProperties.class)
@Configuration
public class ToDoConfig {

    @Bean
    public ApplicationRunner runner(MessageChannel input){
        return args -> {
            input.send(
                    MessageBuilder
                            .withPayload(new ToDo("helllo integration",true))
                            .build()
            );

        };
    }
}
