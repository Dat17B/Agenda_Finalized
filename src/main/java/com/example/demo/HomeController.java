package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class HomeController
{
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/movies")
    public String movies() {
        return "MovieShow";
    }

    @GetMapping("/actors")
    public String actors() {
        return "actors";
    }
}
