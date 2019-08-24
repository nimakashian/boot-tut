package com.example.todorabbitmq.model;


import com.example.todorabbitmq.rmq.ToDoProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoSender {

    @Bean
    public CommandLineRunner sendToDos(@Value("${todo.ampq.queue}") String destination, ToDoProducer producer ){
        return args -> {
          producer.sendTo(destination,new ToDo("some message"));
        };
    }
}
