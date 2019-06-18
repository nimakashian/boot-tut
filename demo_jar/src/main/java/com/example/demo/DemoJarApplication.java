package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class DemoJarApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJarApplication.class, args);

    }

}
@Component
class MyComp{

    @Autowired
    public MyComp(ApplicationArguments args){
        System.out.println("heloooooooooooooo boot");
        if(args.containsOption("aaa"))
            System.out.println("contains AAAAAAAAAAAAAAAAAAAAAAAAAA");
        if(!args.getNonOptionArgs().isEmpty())
            args.getNonOptionArgs().forEach(s -> System.out.println(s));
    }
}