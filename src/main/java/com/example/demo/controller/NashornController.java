package com.example.demo.controller;

import com.example.demo.exceptions.NashornException;
import com.example.demo.model.JsPytjeEntity;
import com.example.demo.repository.JsPytjeRepository;
import com.example.demo.service.JsPytjeService;
import com.example.demo.service.NashornService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dren Bilalli on 1/16/2021
 */

@Controller
public class NashornController {



    @Autowired
    private JsPytjeService jsPytjeService;

    @Autowired
    private NashornService nashornService;

    @Autowired
    private JsPytjeRepository jsPytjeRepository;


    @GetMapping("home/playJSQuiz/{id}")
    public String returnJsQuestion(@PathVariable("id") Integer id, Model model) throws NashornException {

        List<JsPytjeEntity> jsPytjeEntityList = jsPytjeService.findByQuizID(id);

        model.addAttribute("jsPytjeEntityList",jsPytjeEntityList);

        return "takeJsQuiz";
    }

    @PostMapping("/jsQuiz/playerPoints")
    public String compileJsCodeAndShowPoints(@RequestParam("KodiJSText") List<String> kodiJsText,
                                             @RequestParam("IDJS") String KuiziID,Model model,
                                             @RequestParam(value = "emriLojtarit",defaultValue = "Pa emer") String emriLojtarit) throws NoSuchMethodException, ScriptException, NashornException {


        int countPiket = 0;
        Integer IDKuiz = Integer.parseInt(KuiziID);

        List<JsPytjeEntity> jsPytjeEntityList = jsPytjeRepository.findAllByQuizID(IDKuiz);
        List<String> pergjigjet = new ArrayList<>();


        for(int i=0;i<kodiJsText.size();i++){
            pergjigjet.add(nashornService.ekzekutoKodin(kodiJsText.get(i),jsPytjeEntityList.get(i).getMetoda()));
        }

        for(int i=0;i<kodiJsText.size();i++){
            if(pergjigjet.get(i).equalsIgnoreCase(jsPytjeEntityList.get(i).getPergjigja())){
                countPiket+=jsPytjeEntityList.get(i).getPiketPytjes();
            }


        }

        model.addAttribute("userPoints",countPiket);
        model.addAttribute("playerName",emriLojtarit);



        return "displayUserJsPoints";
    }

}
