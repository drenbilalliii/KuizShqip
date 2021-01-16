package com.example.demo.controller;

import com.example.demo.exceptions.NashornException;
import com.example.demo.model.JsPytjeEntity;
import com.example.demo.service.JsPytjeService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Dren Bilalli on 1/16/2021
 */

@Controller
public class NashornController {



    @Autowired
    private JsPytjeService jsPytjeService;



    @GetMapping("home/playJSQuiz/{id}")
    public String returnJsQuestion(@PathVariable("id") Long id, Model model) throws NashornException {

        List<JsPytjeEntity> jsPytjeEntityList = jsPytjeService.findByQuizID(id);

        model.addAttribute("jsPytjeEntityList",jsPytjeEntityList);

        return "takeJsQuiz";
    }

}
