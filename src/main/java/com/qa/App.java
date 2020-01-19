package com.qa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication

public class App 
{
    @RequestMapping("/")
    @ResponseBody
    String hello(){
        return "Hello Heroku";
    }

    public static void main( String[] args ){

        SpringApplication.run(App.class, args);
    }
}
