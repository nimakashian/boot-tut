package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("${data.server}")
    private String server;

    @Autowired
    public MyComp(ApplicationArguments args){
        System.out.println("heloooooooooooooo boot");
        System.out.println(server);
        if(args.containsOption("aaa"))
            System.out.println("contains AAAAAAAAAAAAAAAAAAAAAAAAAA");
        if(!args.getNonOptionArgs().isEmpty())
            args.getNonOptionArgs().forEach(s -> System.out.println(s));
    }
}