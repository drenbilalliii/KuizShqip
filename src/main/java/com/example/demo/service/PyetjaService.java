package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.KuiziEntity;
import com.example.demo.model.PyetjaEntity;

import java.util.List;

/**
 * @author Dren Bilalli on 1/10/2021
 */


public interface PyetjaService {


    PyetjaEntity save(PyetjaEntity pyetjaEntity) throws PyetjaException;

    PyetjaEntity find(Long id) throws PyetjaException;

    PyetjaEntity update(PyetjaEntity newPyetja) throws PyetjaException;

    void delete(PyetjaEntity pyetjaEntity) throws PyetjaException;

    List<PyetjaEntity> findAllByQuizID(Long id) throws PyetjaException;

    List<PyetjaEntity> findAllPergjigjetByQuizID(Long id) throws PyetjaException;

    List<PyetjaEntity> findThreePytjetMeMaxPike() throws PyetjaException;

    List<PyetjaEntity> findThreePytjetMeMaxPikeByQuizID(Long id) throws PyetjaException;

}