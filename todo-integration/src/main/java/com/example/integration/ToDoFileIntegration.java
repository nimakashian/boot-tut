package com.example.integration;

import com.example.integration.config.ToDoProperties;
import com.example.integration.message.ToDoConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.splitter.FileSplitter;

import java.io.File;


@EnableConfigurationProperties(ToDoProperties.class)
@Configuration
@EnableIntegration
public class ToDoFileIntegration {
    ToDoProperties props;
    ToDoConverter converter;

    public ToDoFileIntegration(ToDoProperties props, ToDoConverter converter) {
        this.props = props;
        this.converter = converter;
    }

    @Bean
    public IntegrationFlow fileFLow(){
        return IntegrationFlows
                .from(Files.inboundAdapter(new File(this.props.getDirectory()))
                        .preventDuplicates(true)
                        .patternFilter(this.props.getFilePattern()), e->e.poller(Pollers.fixedDelay(5000L))
                )
                .split(Files.splitter().markers())
                .filter(p -> !(p instanceof FileSplitter.FileMarker))
                .transform(Transformers.converter(converter))
                .handle("toDoMessageHandler","process")
                .get();
    }
}
