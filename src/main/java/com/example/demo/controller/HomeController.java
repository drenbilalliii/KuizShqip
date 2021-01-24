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


    @RequestMapping("/")
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

//    @RequestMapping("/test")
//    public String f(Model model) throws PyetjaException {
//
//        model.addAttribute("kuizi", new KuiziEntity());
//
//        return "form";
//    }

//    @PostMapping("/test/testTeDhenat")
//    public String f(@ModelAttribute("kuizi") KuiziEntity kuiziEntity, @RequestParam("question") List<String> pytjet, @RequestParam(value = "optionAName", defaultValue = "") List<String> opsionetA,
//                    @RequestParam("optionBName") List<String> opsionetB,
//                    @RequestParam("optionCName") List<String> opsionetC,
//                    @RequestParam("optionDName") List<String> opsionetD,
//                    @RequestParam("correctAnswerName") List<String> pergjigjjet,
//                    @RequestParam("piketName") List<Integer> piket,HttpSession httpSession) throws PyetjaException, KuiziException {
//
//
//        String administatori = (String)httpSession.getAttribute("EmriAdminit");
//
//        Date date = new Date(System.currentTimeMillis());
//        kuiziEntity.setDataKuizit(date);
//       kuiziEntity.setAdministatori(administatori);
//
//        kuiziService.save(kuiziEntity);
//
//
//
//        for (int i = 0; i < pytjet.size(); i++) {
//            PyetjaEntity pyetjaEntity = new PyetjaEntity();
//            pyetjaEntity.setEmriPyetjes(pytjet.get(i));
//            pyetjaEntity.setOpsioniA(opsionetA.get(i));
//            pyetjaEntity.setOpsioniB(opsionetB.get(i));
//            pyetjaEntity.setOpsioniC(opsionetC.get(i));
//            pyetjaEntity.setOpsioniD(opsionetD.get(i));
//            pyetjaEntity.setOpsioniSakt(pergjigjjet.get(i));
//            pyetjaEntity.setPiket(piket.get(i));
//            pyetjaEntity.setKuiziEntity(kuiziEntity);
//            pyetjaService.save(pyetjaEntity);
//
//        }
//
//        return "form";
//
//
//    }
}