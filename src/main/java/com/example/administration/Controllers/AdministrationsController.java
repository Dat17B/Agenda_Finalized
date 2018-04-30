package com.example.administration.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdministrationsController
{
    private static final String BASE_PATH = "/Administration";

    @RequestMapping(value = BASE_PATH + "/")
    public String index() {
        return BASE_PATH + "/index";
    }
}
