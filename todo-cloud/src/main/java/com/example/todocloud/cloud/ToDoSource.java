package com.example.todocloud.cloud;

import com.example.todocloud.domain.ToDo;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;


@EnableBinding(Source.class)
public class ToDoSource {

    @Bean
    @InboundChannelAdapter(channel = Source.OUTPUT)
    public MessageSource<ToDo> simpleToDo(){
        return ()-> MessageBuilder
                .withPayload(new ToDo("howdy buddy"))
                .build();
    }
}
