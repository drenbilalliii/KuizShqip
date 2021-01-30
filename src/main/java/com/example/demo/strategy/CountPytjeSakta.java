package com.example.demo.strategy;

import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dren Bilalli on 1/25/2021
 */

@Component("countPytjeSakta")
public class CountPytjeSakta implements StrategyForQuizHandling {


    @Autowired
    private PyetjaService pyetjaService;


    @Override
    public int[] numeroPiketDhePytjetSakta(List<String> userPergjigje, Integer KuiziID) {

        int countPiket = 0;
        int countPergjigjetSakta = 0;
        List<PyetjaEntity> listaMePytje = new ArrayList<>();
        try {
             listaMePytje = pyetjaService.findAllByQuizID(KuiziID);
            for (int i = 0; i < userPergjigje.size(); i++) {
                if (userPergjigje.get(i).equalsIgnoreCase(listaMePytje.get(i).getOpsioniSakt())) {
                    countPiket += listaMePytje.get(i).getPiket();
                    countPergjigjetSakta++;
                }
            }
        } catch (PyetjaException e) {
            e.printStackTrace();
        }
        return new int[]{countPiket, countPergjigjetSakta,listaMePytje.size()};
    }

}