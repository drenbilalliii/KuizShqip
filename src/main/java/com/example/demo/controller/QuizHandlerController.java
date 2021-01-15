package com.example.demo.controller;

import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Dren Bilalli on 1/15/2021
 */

@Controller
public class QuizHandlerController {


    @Autowired
    private PyetjaService pyetjaService;

    @RequestMapping("home/playQuiz/{id}")
    public String displayTheQuiz(@PathVariable("id") Long id) throws PyetjaException {

       List<PyetjaEntity> listaPytjesh =  pyetjaService.findAllByQuizID(id);

        System.out.println(listaPytjesh);

        return "home";
    }

}