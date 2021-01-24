package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.*;
import com.example.demo.service.KuizeTeLuajturaService;
import com.example.demo.service.KuiziService;
import com.example.demo.service.PerdoruesiService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;
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

    @RequestMapping("/dashboardPage/shtoKuiz")
    public String redirectToShtoKuiz(Model model,HttpSession httpSession){


        if(httpSession.getAttribute("EmriAdminit") == null){
            return "redirect:/";
        }

        model.addAttribute("kuizi",new KuiziEntity());
        model.addAttribute("EmriAdminit",(String)httpSession.getAttribute("EmriAdminit"));
        return "DashboardShtoKuiz";
    }

    @PostMapping("/dashboard/shtoKuizAction")
    public String shtoKuizThenRedirect(@ModelAttribute("kuizi") KuiziEntity kuiziEntity, @RequestParam("question") List<String> pytjet, @RequestParam(value = "optionAName", defaultValue = "") List<String> opsionetA,
                    @RequestParam("optionBName") List<String> opsionetB,
                    @RequestParam("optionCName") List<String> opsionetC,
                    @RequestParam("optionDName") List<String> opsionetD,
                    @RequestParam("correctAnswerName") List<String> pergjigjjet,
                    @RequestParam("piketName") List<Integer> piket, HttpSession httpSession) throws PyetjaException, KuiziException {


        String administatori = (String)httpSession.getAttribute("EmriAdminit");

        Date date = new Date(System.currentTimeMillis());
        kuiziEntity.setDataKuizit(date);
        kuiziEntity.setAdministatori(administatori);

        kuiziService.save(kuiziEntity);



        for (int i = 0; i < pytjet.size(); i++) {
            PyetjaEntity pyetjaEntity =  ModelFactory.getInstanceOfModel("PyetjaEntity");
            pyetjaEntity.setEmriPyetjes(pytjet.get(i));
            pyetjaEntity.setOpsioniA(opsionetA.get(i));
            pyetjaEntity.setOpsioniB(opsionetB.get(i));
            pyetjaEntity.setOpsioniC(opsionetC.get(i));
            pyetjaEntity.setOpsioniD(opsionetD.get(i));
            pyetjaEntity.setOpsioniSakt(pergjigjjet.get(i));
            pyetjaEntity.setPiket(piket.get(i));
            pyetjaEntity.setKuiziEntity(kuiziEntity);
            pyetjaService.save(pyetjaEntity);

        }

        return "DashboardShtoKuiz";


    }

    @RequestMapping("/dashboard/shtoKuizMagicWay")
    public String addFromFileMagicWay(@RequestParam("fileInput") File fileInput){





        return "redirect:/dashboardPage/shtoKuiz";
    }
}
