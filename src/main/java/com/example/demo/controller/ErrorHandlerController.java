package com.example.demo.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dren Bilalli on 1/8/2021
 */

@Controller
public class ErrorHandlerController implements ErrorController {





    @Override
    @RequestMapping("/error")
    public String getErrorPath() {

        return "404NotFound";
    }
}


