package com.example.todojms.config;


import com.example.todojms.domain.ToDo;
import com.example.todojms.jms.ToDoProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSender {

    @Bean
    public CommandLineRunner sendToDO(
            @Value("${todo.jms.destination}") String destination,
            ToDoProducer producer){
        return args -> {
            producer.sendTo(destination,new ToDo("hi this is the jms messsage!!!"));
        };
    }
}
