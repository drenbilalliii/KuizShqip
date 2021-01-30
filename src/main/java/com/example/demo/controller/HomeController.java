package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.KuiziEntity;
import com.example.demo.model.PerdoruesiEntity;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.repository.KuiziRepository;
import com.example.demo.repository.PyetjaRepository;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.ArrayList;
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

    @Autowired
    private KuizeTeLuajturaService kuizeTeLuajturaService;

    @Autowired
    private PerdoruesiService perdoruesiService;


    @RequestMapping(value = "/")
    public String redirectToHome(Model model) throws KuiziException, PyetjaException, ParseException {

        List<KuiziEntity> listKuizEntity = kuiziService.KaterRandomKuize();
        List<KuiziEntity> listKuizEntitySot = kuiziService.katerKuizetEDatesSotshme();
        Integer numriITeGjithaKuizeve = kuiziService.countAllKuizet();
        Integer numriITeGjithaPytjeve = pyetjaService.getNumrinEpyetjeve();
        Integer numriIKuizeveTeLuajtura = kuizeTeLuajturaService.getKuizeTeLuajtura();
        Integer numriAdministratoreve = perdoruesiService.getNumrinAdministratoreve();


        model.addAttribute("listaKuiz", listKuizEntity);
        model.addAttribute("listaKuizSot", listKuizEntitySot);
        model.addAttribute("numriIKuizeve", numriITeGjithaKuizeve);
        model.addAttribute("numriIPyetjeve", numriITeGjithaPytjeve);
        model.addAttribute("numriIKuizeveLuajtura", numriIKuizeveTeLuajtura);
        model.addAttribute("numriAdministratoreve",numriAdministratoreve);

        return "home";
    }


}