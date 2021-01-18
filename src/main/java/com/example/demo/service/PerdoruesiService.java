package com.example.demo.service;

import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.PerdoruesiEntity;

/**
 * author Gramos Shala
 */

public interface PerdoruesiService {

    PerdoruesiEntity findByEmailAndPassword(String Username,String password) throws PerdoruesiException;

}
