package com.example.demo.strategy;

import com.example.demo.exceptions.NashornException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.JsPytjeEntity;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.service.JsPytjeService;
import com.example.demo.service.PyetjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dren Bilalli on 1/25/2021
 */
@Component("CountJsPytjeSakta")
public class CountJsPytjeSakta implements StrategyForQuizHandling{

    @Autowired
    private JsPytjeService jsPytjeService;


    @Override
    public int[] numeroPiketDhePytjetSakta(List<String> userPergjigje, Long KuiziID) {

        int countPiket = 0;
        int countPergjigjetSakta = 0;

        try {
            List<JsPytjeEntity> listaMePytje = jsPytjeService.findByQuizID(KuiziID);
            if(listaMePytje == null){
                throw new NashornException("KU JE :(");
            }
            for (int i = 0; i < userPergjigje.size(); i++) {
                if (userPergjigje.get(i).equalsIgnoreCase(listaMePytje.get(i).getPergjigja())) {
                    countPiket += listaMePytje.get(i).getPiketPytjes();
                    countPergjigjetSakta++;
                }
            }

        } catch (NashornException e) {
            e.printStackTrace();
        }

        return new int[]{countPiket, countPergjigjetSakta};
    }

}