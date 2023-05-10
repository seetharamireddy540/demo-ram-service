package com.example.application;

import com.example.application.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private MyService myService;

    public PersonController(@Autowired MyService myService) {
        this.myService = myService;
    }

    @GetMapping("/name")
    public String getName(){

//        myService.doSomethingElse();
        myService.doSomething();

        return "Ram";
    }
}
