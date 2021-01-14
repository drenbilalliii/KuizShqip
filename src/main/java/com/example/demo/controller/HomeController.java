package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.KuiziEntity;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.repository.KuiziRepository;
import com.example.demo.repository.PyetjaRepository;
import com.example.demo.service.KuiziService;
import com.example.demo.service.PyetjaService;
import com.example.demo.service.PyetjaServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

/**
 * @author Dren Bilalli on 1/8/2021
 */

@Controller
public class HomeController {


    @Autowired
    private KuiziService kuiziService;



    @Autowired
    private PyetjaService pyetjaService;

    @RequestMapping("/")
    public String redirectToHome(Model model) throws KuiziException {

        List<KuiziEntity> listKuizEntity = kuiziService.teGjitheKuizet();

        model.addAttribute("listaKuiz",listKuizEntity);

        return "home";
    }

    @RequestMapping("/test")
    public String f() throws PyetjaException {


        List<PyetjaEntity> p = pyetjaService.findThreePytjetMeMaxPike();

        System.out.println(p);
        return "404NotFound";
    }

}
