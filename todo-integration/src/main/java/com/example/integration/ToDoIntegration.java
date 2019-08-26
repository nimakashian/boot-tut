package com.example.integration;


import com.example.integration.domain.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

//@EnableIntegration
//@Configuration
public class ToDoIntegration {

//    @Bean
//    public DirectChannel input(){
////        return MessageChannels.direct().get();
//        return new DirectChannel();
//    }
//    @Bean
//    public MessageChannel toTransform(){
//        return new DirectChannel();
//    }
//
//    @Bean
//    public MessageChannel toLog(){
//        return new DirectChannel();
//    }

//    @Bean
//    public IntegrationFlow simpleFlow(){
//        return IntegrationFlows
//                .from(input())
//                .filter(ToDo.class,ToDo::isCompleted)
//                .transform(ToDo.class,toDo -> toDo.getDescription().toUpperCase())
//                .handle(System.out::println)
//                .get();
//    }

//    @MessageEndpoint
//    class SimplFilter {
//        @Filter(inputChannel = "input",outputChannel = "toTransform")
//        public boolean process(ToDo message){
//            return message.isCompleted();
//        }
//    }
//    @MessageEndpoint
//    class SimpleTransform{
//        @Transformer(inputChannel = "toTransform",outputChannel = "toLog")
//        public String process(ToDo message){
//            return message.getDescription().toUpperCase();
//        }
//    }
//    @MessageEndpoint
//    class SimpleServiceActivator{
//        Logger log = LoggerFactory.getLogger(SimpleServiceActivator.class);
//        @ServiceActivator(inputChannel = "toLog")
//        public void process(String message){
//            log.info(message);
//        }
//    }
}
