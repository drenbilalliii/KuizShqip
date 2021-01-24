package com.example.demo.service;

import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.PerdoruesiEntity;
import com.example.demo.repository.JsPytjeRepository;
import com.example.demo.repository.PerdoruesiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * author Gramos Shala
 */

@Service
public class PerdoruesiServiceImplementation implements PerdoruesiService{


    private PerdoruesiRepository perdoruesiRepository;

    @Autowired
    private PerdoruesiService perdoruesiService;


    public PerdoruesiServiceImplementation(PerdoruesiRepository perdoruesiRepository){
        this.perdoruesiRepository = perdoruesiRepository;
    }

    public void setPerdoruesiService(PerdoruesiService perdoruesiService) {
        this.perdoruesiService = perdoruesiService;
    }


    @Override
    public PerdoruesiEntity findByEmailAndPassword(String username, String password) throws PerdoruesiException {


        PerdoruesiEntity perdoruesiEntityList;

        perdoruesiEntityList = perdoruesiRepository.findByEmailAndPassword(username,password);


        return perdoruesiEntityList;
    }

    @Override
    public boolean kontrolloALejohetQasja(HttpSession httpSession) {
        return (httpSession.getAttribute("EmriAdminit") == null) ? true : false;
    }

    @Override
    public Integer getNumrinAdministratoreve() {
        return perdoruesiRepository.getNumrinAdministratoreve();
    }
}
