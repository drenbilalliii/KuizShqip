package com.example.demo.service;

import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.PerdoruesiEntity;
import com.example.demo.repository.PerdoruesiRepository;


import java.util.List;

/**
 * author Gramos Shala
 */

public class PerdoruesiServiceImplemation implements PerdoruesiService{

    private PerdoruesiRepository perdoruesiRepository;

    @Override
    public PerdoruesiEntity findByEmailAndPassword(String Username, String password) throws PerdoruesiException {


        PerdoruesiEntity perdoruesiEntityList;

        perdoruesiEntityList = perdoruesiRepository.findByEmailAndPassword();

        if(perdoruesiEntityList.equals("")){
            throw new PerdoruesiException("Ne rregull !");
        }
        return perdoruesiEntityList;
    }
}
