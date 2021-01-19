package com.example.demo.controller;

import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.PerdoruesiEntity;
import com.example.demo.service.PerdoruesiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author Dren Bilalli on 1/18/2021
 */

@Controller
public class LoginController {


    @Autowired
    public PerdoruesiService perdoruesiService;


    @RequestMapping("/loginAdmin")
    public String redirectToLogin() {


        return "signin";
    }

    @PostMapping("/tryToLogin")
    public String testUserForLogin(@RequestParam("email") String email,@RequestParam("password")
            String password , HttpSession httpSession) throws PerdoruesiException {


        PerdoruesiEntity perdoruesiEntity = perdoruesiService.findByEmailAndPassword(email,password);


        httpSession.setAttribute("EmriAdminit",perdoruesiEntity.getEmri());
        httpSession.setAttribute("IDAdminit",perdoruesiEntity.getPerdoruesiId());

        return "redirect:/";
    }


    @RequestMapping("/logOut")
    public String destroyAllSessionsThenRedirect(HttpSession httpSession){

        httpSession.invalidate();

        return "redirect:/loginAdmin";

    }

}