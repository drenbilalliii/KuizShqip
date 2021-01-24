package com.example.demo.service;

import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.PerdoruesiEntity;

import javax.servlet.http.HttpSession;

/**
 * author Gramos Shala
 */

public interface PerdoruesiService {

    PerdoruesiEntity findByEmailAndPassword(String Username,String password) throws PerdoruesiException;

    boolean kontrolloALejohetQasja(HttpSession httpSession);

    public Integer getNumrinAdministratoreve();

}
