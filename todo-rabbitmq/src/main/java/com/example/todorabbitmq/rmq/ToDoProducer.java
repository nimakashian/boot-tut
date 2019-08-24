package com.example.todorabbitmq.rmq;

import com.example.todorabbitmq.model.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ToDoProducer {

    private static final Logger logger= LoggerFactory.getLogger(ToDoProducer.class);

    private RabbitTemplate template;

    public ToDoProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendTo(String queue, ToDo toDo){
        this.template.convertAndSend(queue,toDo);
        logger.info("producer> message sent");
    }

}
