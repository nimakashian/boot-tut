package com.example.todojms.jms;

import com.example.todojms.domain.ToDo;
import com.example.todojms.repositories.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ToDoConsumer {

    private static final Logger log = LoggerFactory.getLogger(ToDoProducer.class);

    ToDoRepository rep;

    public ToDoConsumer(ToDoRepository rep){
        this.rep=rep;
    }

    @JmsListener(destination="${todo.jms.destination}",containerFactory = "jmsFactory")
    public void processToDo(@Valid ToDo toDo){
        log.info("Conxumer >" +toDo);
        ToDo t=this.rep.save(toDo);
        log.info("toDO created>"+t);
    }

}
