package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.KuizeteluajturaEntity;
import com.example.demo.model.KuiziEntity;
import com.example.demo.service.KuizeTeLuajturaService;
import com.example.demo.service.KuiziService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Donat Krasniqi on 1/21/2021
 */

@Controller
public class DashboardController {



    @Autowired
    private KuizeTeLuajturaService kuizeTeLuajturaService;

    @Autowired
    private KuiziService kuiziService;

    @Autowired
    private PyetjaService pyetjaService;


    @RequestMapping("/dashboardPage")
    public String returnToDashboard(HttpSession httpSession, Model model) throws KuiziException {

        if(httpSession.getAttribute("EmriAdminit") == null){
            return "redirect:/";
        }
        String emriAdmin = (String)httpSession.getAttribute("EmriAdminit");
        List<KuiziEntity> teGjitheKuizetByAdmin = kuiziService.teGjithaNeBazeTeAdministratorit(emriAdmin);


        model.addAttribute("emriAdmin",emriAdmin);
        model.addAttribute("teGjitheKuizetByAdmin",teGjitheKuizetByAdmin);

        return "Dashboard";
    }

    @RequestMapping("dashboardPage/deleteQuiz/{id}")
    public String deleteQuiz(@PathVariable("id") Integer id,HttpSession httpSession) throws KuiziException, PyetjaException {

        if(httpSession.getAttribute("EmriAdminit") == null){
            return "redirect:/";
        }
        //fshirja e referencave
        pyetjaService.deleteByKuiziID(id);

        kuiziService.delete(id);

        return "redirect:/dashboardPage";
    }

}
