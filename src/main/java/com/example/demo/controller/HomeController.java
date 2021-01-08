package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dren Bilalli on 1/8/2021
 */

@Controller
public class HomeController {



    @RequestMapping("/")
    public String redirectToHome(){



        return "home";
    }

    @RequestMapping("/test")
    public String f(){

        return "404NotFound";
    }

}
