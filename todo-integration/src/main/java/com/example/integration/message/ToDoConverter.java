package com.example.integration.message;

import com.example.integration.domain.ToDo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ToDoConverter implements Converter<String, ToDo> {
    @Override
    public ToDo convert(String s) {
        List<String> fields=
                Stream.of(s.split(",")).map(String::trim)
                .collect(Collectors.toList());
        return new ToDo(fields.get(0),Boolean.parseBoolean(fields.get(1)));
    }
}
