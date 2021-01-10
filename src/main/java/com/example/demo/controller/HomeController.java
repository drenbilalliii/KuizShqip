package com.example.demo.controller;

import com.example.demo.model.KuiziEntity;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.repository.KuiziRepository;
import com.example.demo.repository.PyetjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.List;

/**
 * @author Dren Bilalli on 1/8/2021
 */

@Controller
public class HomeController {


    @Autowired
    private KuiziRepository kuiziRepository;

    @Autowired
    private PyetjaRepository pyetjaRepository;

    @RequestMapping("/")
    public String redirectToHome(){

        long millis=System.currentTimeMillis();
        KuiziEntity kuiziEntity = new KuiziEntity();
        kuiziEntity.setEmriKuizit("Testime");
        kuiziEntity.setKategoria("Java");
        kuiziEntity.setDataKuizit(new Date(millis));
        kuiziRepository.save(kuiziEntity);

        PyetjaEntity pyetjaEntity = new PyetjaEntity();
        pyetjaEntity.setPiket(4);
        pyetjaEntity.setEmriPyetjes("Qka eshte java");
        pyetjaEntity.setOpsioniA("Kurjga");
        pyetjaEntity.setOpsioniB("D");
        pyetjaEntity.setOpsioniC("f");
        pyetjaEntity.setOpsioniD("y");
        pyetjaEntity.setOpsioniSakt("D");
        pyetjaEntity.setKuiziEntity(kuiziEntity);

        pyetjaRepository.save(pyetjaEntity);


        return "home";
    }

    @RequestMapping("/test")
    public String f(){

        return "404NotFound";
    }

}
