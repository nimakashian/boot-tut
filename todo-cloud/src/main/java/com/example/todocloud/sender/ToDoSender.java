package com.example.todocloud.sender;


import com.example.todocloud.domain.ToDo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;


@Configuration
public class ToDoSender {

    @Bean
    public ApplicationRunner send(MessageChannel input){
        return args -> {
            input
                    .send(
                            MessageBuilder
                                    .withPayload(new ToDo("read a new book"))
                                    .build()
                    );
        };
    }
}
