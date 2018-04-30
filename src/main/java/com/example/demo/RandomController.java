package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomController
{
    @GetMapping("/exercise_1")
    public String exec_1(){
        return "exercise_1";
    }
}
