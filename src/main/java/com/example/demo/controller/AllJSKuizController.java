package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.NashornException;
import com.example.demo.model.JsPytjeEntity;
import com.example.demo.model.KuiziEntity;
import com.example.demo.service.JsPytjeService;
import com.example.demo.service.KuiziService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Dren Bilalli on 1/16/2021
 */

@Controller
public class AllJSKuizController {


    @Autowired
    private JsPytjeService jsPytjeService;

    @Autowired
    private KuiziService kuiziService;


    @RequestMapping("/allJsQuizzes")
    public String redirectToJsQuizzes(Model model) throws KuiziException {

        List<KuiziEntity> listaMeKuizeJs = kuiziService.teGjitheKuizetJavaScript();


        model.addAttribute("listaMeKuizeJs",listaMeKuizeJs);


        return "AllJSQuizzes";

    }


}