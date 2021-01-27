package com.example.demo.controller;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.KuizeteluajturaEntity;
import com.example.demo.model.KuiziEntity;
import com.example.demo.model.ModelFactory;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.service.KuizeTeLuajturaService;
import com.example.demo.service.KuiziService;
import com.example.demo.service.PyetjaService;
import com.example.demo.strategy.StrategyForQuizHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Dren Bilalli on 1/15/2021
 */

@Controller
public class QuizHandlerController {


    @Autowired
    private PyetjaService pyetjaService;

    @Autowired
    private KuiziService kuiziService;

    @Autowired
    private KuizeTeLuajturaService kuizeTeLuajturaService;

    @Resource(name = "countPytjeSakta")
    private StrategyForQuizHandling strategyForQuizHandling;


    @GetMapping("home/playQuiz/{id}")
    public String displayTheQuiz(@PathVariable("id") Integer id, Model model) throws PyetjaException, KuiziException {

       List<PyetjaEntity> listaPytjesh =  pyetjaService.findAllByQuizID(id);
       String emriKuizit = kuiziService.getEmriKuizitByID(id);

        //Collections.shuffle(listaPytjesh);
        model.addAttribute("listaPytjesh",listaPytjesh);
        model.addAttribute("emriKuizit",emriKuizit);

        System.out.println(listaPytjesh);

        return "takeKuiz";
    }

//    @PostMapping("/takeKuiz/userTakesIt")
//    public String userTookQuiz(@RequestParam(value = "Opsioni",defaultValue = "") List<String> pergjigja
//                               ,@RequestParam(value = "ID",defaultValue = " ")String ID,
//                               @RequestParam(value = "emriLojtarit",defaultValue = "Pa emer")String emriLojtarit, Model model) throws PyetjaException, KuiziException {
//
//
//        Integer IDQuiz = Integer.parseInt(ID);
//        List<PyetjaEntity> lista = pyetjaService.findAllPergjigjetByQuizID(IDQuiz);
//
//
//        int [] rezultatiMbiPiketDhePytjet = kuiziService.countPergjigjenESakta(pergjigja,lista);
//        int countPytjeSakta = rezultatiMbiPiketDhePytjet[0];
//        int countPiket = rezultatiMbiPiketDhePytjet[1];
//
//        int saPersonaMbrapa = kuizeTeLuajturaService.countSaNjerzKanMePakPike(IDQuiz,countPiket);
//
//        KuizeteluajturaEntity kuizeTeLuajturaEntity = ModelFactory.getInstanceOfModel("KuizeteluajtuaraEntity");
//        kuizeTeLuajturaEntity.setLojetari(emriLojtarit);
//      KuiziEntity kuiziEntityID = new KuiziEntity();
//      kuiziEntityID.setKuiziId(IDQuiz);
//      kuizeTeLuajturaEntity.setKuiziEntity(kuiziEntityID);
//      kuizeTeLuajturaEntity.setPiket(countPiket);
//      kuizeTeLuajturaService.save(kuizeTeLuajturaEntity);
//
//        model.addAttribute("gjatesiaPytjeve",lista.size());
//        model.addAttribute("pytjeTeSakta",countPytjeSakta);
//        model.addAttribute("countPiket",countPiket);
//        model.addAttribute("saPersonaMbrapa",saPersonaMbrapa);
//        model.addAttribute("emriLojtarit",emriLojtarit);
//
//
//        return "displayUserPoints";
//
//
//    }

    @PostMapping("/takeKuiz/userTakesIt")
    public String userTookQuiz(@RequestParam(value = "Opsioni",defaultValue = "") List<String> pergjigja
            ,@RequestParam(value = "ID",defaultValue = " ")String ID,
                               @RequestParam(value = "emriLojtarit",defaultValue = "Pa emer")String emriLojtarit, Model model) throws PyetjaException, KuiziException {


        Integer IDQuiz = Integer.parseInt(ID);


        int [] rezultatiMbiPiketDhePytjet = strategyForQuizHandling.numeroPiketDhePytjetSakta(pergjigja,IDQuiz);


        int countPiket = rezultatiMbiPiketDhePytjet[0];
        int countPytjeSakta = rezultatiMbiPiketDhePytjet[1];
        int gjatesiaPytjeve = rezultatiMbiPiketDhePytjet[2];

        int saPersonaMbrapa = kuizeTeLuajturaService.countSaNjerzKanMePakPike(IDQuiz,countPiket);

        KuizeteluajturaEntity kuizeTeLuajturaEntity = ModelFactory.getInstanceOfModel("KuizeteluajtuaraEntity");

        kuizeTeLuajturaEntity.setLojetari(emriLojtarit);
        KuiziEntity kuiziEntityID = new KuiziEntity();
        kuiziEntityID.setKuiziId(IDQuiz);
        kuizeTeLuajturaEntity.setKuiziEntity(kuiziEntityID);
        kuizeTeLuajturaEntity.setPiket(countPiket);
        kuizeTeLuajturaService.save(kuizeTeLuajturaEntity);

        model.addAttribute("gjatesiaPytjeve",gjatesiaPytjeve);
        model.addAttribute("pytjeTeSakta",countPytjeSakta);
        model.addAttribute("countPiket",countPiket);
        model.addAttribute("saPersonaMbrapa",saPersonaMbrapa);
        model.addAttribute("emriLojtarit",emriLojtarit);


        return "displayUserPoints";


    }

}