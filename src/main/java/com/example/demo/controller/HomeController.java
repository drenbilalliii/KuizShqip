package com.example.demo.controller;

import com.example.demo.model.KuiziEntity;
import com.example.demo.repository.KuiziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

/**
 * @author Dren Bilalli on 1/8/2021
 */

@Controller
public class HomeController {


    @Autowired
    private KuiziRepository kuiziRepository;

    @RequestMapping("/")
    public String redirectToHome(){

        long millis=System.currentTimeMillis();
        KuiziEntity kuiziEntity = new KuiziEntity();
        kuiziEntity.setEmriKuizit("Testime");
        kuiziEntity.setKategoria("Java");
        kuiziEntity.setDataKuizit(new Date(millis));
        kuiziRepository.save(kuiziEntity);


        return "home";
    }

    @RequestMapping("/test")
    public String f(){

        return "404NotFound";
    }

}
