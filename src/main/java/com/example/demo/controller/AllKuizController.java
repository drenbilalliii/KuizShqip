package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.KuiziEntity;
import com.example.demo.service.KuizeTeLuajturaService;
import com.example.demo.service.KuiziService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;

/**
 * @author Dren Bilalli on 1/15/2021
 */

@Controller
public class AllKuizController {


    @Autowired
    private PyetjaService pyetjaService;

    @Autowired
    private KuiziService kuiziService;




    @RequestMapping("/allQuizes")
    public String redirectToAll(Model model) throws KuiziException {


        List<KuiziEntity> kuiziEntities = kuiziService.teGjitheKuizet();
        Collections.shuffle(kuiziEntities);
        model.addAttribute("listaMeKuize",kuiziEntities);



        return "AllQuizes";

    }



}