package com.example.todorabbitmq.rmq;

import com.example.todorabbitmq.model.ToDo;
import com.example.todorabbitmq.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ToDoConsumer {

    private static final Logger logger= LoggerFactory.getLogger(ToDoConsumer.class);

    private ToDoRepository repository;

    public ToDoConsumer(ToDoRepository repository) {
        this.repository = repository;
    }

    @RabbitListener(queues = "${todo.amqp.queue}")
    public void processToDo(ToDo todo){
        logger.info("Consumer> " + todo);
        logger.info("ToDo created> " + this.repository.save(todo));
    }
}
