package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dren Bilalli on 1/15/2021
 */

@Controller
public class AllKuizController {



    @RequestMapping("/allQuizes")
    public String redirectToAll(){


        return "AllQuizes";

    }

}