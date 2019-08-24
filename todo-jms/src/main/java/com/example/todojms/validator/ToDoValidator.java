package com.example.todojms.validator;

import com.example.todojms.domain.ToDo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ToDoValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(ToDo.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ToDo toDo = (ToDo)o;
        if (toDo == null) {
            errors.reject(null, "ToDo cannot be null");
        }else {
            if (toDo.getDescription() == null || toDo.getDescription().isEmpty())
                errors.rejectValue("description",null,"description cannot be null or empty");
        }

    }
}
