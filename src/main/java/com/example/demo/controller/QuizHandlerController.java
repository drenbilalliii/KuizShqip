package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.service.KuizeTeLuajturaService;
import com.example.demo.service.KuiziService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author Dren Bilalli on 1/15/2021
 */

@Controller
public class QuizHandlerController {


    @Autowired
    private PyetjaService pyetjaService;

    @Autowired
    private KuiziService kuiziService;

    @Autowired
    KuizeTeLuajturaService kuizeTeLuajturaService;


    @GetMapping("home/playQuiz/{id}")
    public String displayTheQuiz(@PathVariable("id") Long id, Model model) throws PyetjaException, KuiziException {

       List<PyetjaEntity> listaPytjesh =  pyetjaService.findAllByQuizID(id);
       String emriKuizit = kuiziService.getEmriKuizitByID(id);

        Collections.shuffle(listaPytjesh);
        model.addAttribute("listaPytjesh",listaPytjesh);
        model.addAttribute("emriKuizit",emriKuizit);

        System.out.println(listaPytjesh);

        return "takeKuiz";
    }

    @PostMapping("/takeKuiz/userTakesIt")
    public String userTookQuiz(@RequestParam(value = "Opsioni",defaultValue = "") List<String>pergjigja
                               ,@RequestParam(value = "ID",defaultValue = " ")String ID,Model model) throws PyetjaException, KuiziException {


        Integer IDQuiz = Integer.parseInt(ID);
        List<PyetjaEntity> lista = pyetjaService.findAllPergjigjetByQuizID(IDQuiz);


        int countPiket = kuiziService.countPergjigjenESakta(pergjigja,lista);

        int saPersonaMbrapa = kuizeTeLuajturaService.countSaNjerzKanMePakPike(IDQuiz,countPiket);

        System.out.println("Keni : " + countPiket + " pike");
        model.addAttribute("countPiket",countPiket);
        model.addAttribute("saPersonaMbrapa",saPersonaMbrapa);


        return "displayUserPoints";


    }

}