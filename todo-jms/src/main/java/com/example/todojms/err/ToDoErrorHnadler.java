package com.example.todojms.err;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ErrorHandler;

public class ToDoErrorHnadler implements ErrorHandler {

    private static Logger logger= LoggerFactory.getLogger(ToDoErrorHnadler.class);

    @Override
    public void handleError(Throwable throwable) {
       logger.warn("ToDo Error ...");
       logger.info(throwable.getCause().getMessage());


    }
}
