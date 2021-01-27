package com.example.demo.strategy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dren Bilalli on 1/25/2021
 */
@Service
public class ContextPerStrategy {


    private  StrategyForQuizHandling strategyForQuizHandling;


//    public ContextPerStrategy(StrategyForQuizHandling strategyForQuizHandling) {
//        this.strategyForQuizHandling = strategyForQuizHandling; //JOO JO JO JO JO JO
//    }

    public void setStrategyForQuizHandling(StrategyForQuizHandling strategyForQuizHandling) {
        this.strategyForQuizHandling = strategyForQuizHandling; //nullPointerException bre...
    }

    public int [] numeroPiketDhePytjetSakta(List<String> userPergjigje, Integer KuiziID){
        return this.strategyForQuizHandling.numeroPiketDhePytjetSakta(userPergjigje,KuiziID);
    }
}