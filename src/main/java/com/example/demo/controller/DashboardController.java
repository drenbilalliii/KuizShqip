package com.example.demo.controller;

import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.KuizeteluajturaEntity;
import com.example.demo.service.KuizeTeLuajturaService;
import com.example.demo.service.KuiziService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Donat Krasniqi on 1/21/2021
 */

@Controller
public class DashboardController {



    @Autowired
    private KuizeTeLuajturaService kuizeTeLuajturaService;

    @Autowired
    private KuiziService kuiziService;


    @RequestMapping("/dashboardPage")
    public String returnToDashboard(HttpSession httpSession, Model model) {

        if(httpSession.getAttribute("EmriAdminit") == null){
            return "redirect:/";
        }

        String emriAdmin = (String)httpSession.getAttribute("EmriAdminit");


        model.addAttribute("emriAdmin",emriAdmin);

        return "Dashboard";
    }

}
