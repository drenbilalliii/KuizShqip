package com.example.demo.service;

import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.PyetjaEntity;

import com.example.demo.repository.PyetjaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author Dren Bilalli on 1/10/2021
 */

@Service
public class PyetjaServiceImplementation implements PyetjaService{


    private static final Logger logger = LoggerFactory.getLogger(PyetjaServiceImplementation.class); // per debbuging

    private PyetjaRepository pyetjaRepository;

    @Autowired
    private PyetjaService pyetjaService;


    public PyetjaServiceImplementation(PyetjaRepository pyetjaRepository){
        this.pyetjaRepository = pyetjaRepository;
    }

    public void setQuestionService(PyetjaService pyetjaService) {
        this.pyetjaService = pyetjaService;
    }

    @Override
    public PyetjaEntity save(PyetjaEntity pyetjaEntity) throws PyetjaException {

        return pyetjaRepository.save(pyetjaEntity);
    }

    @Override
    public PyetjaEntity find(Long id) throws PyetjaException {

        PyetjaEntity pyetjaEntity = pyetjaRepository.getOne(id);

        if(pyetjaEntity == null){
            logger.error("Pyetja me id : " + id + " nuk mundet te gjendet ne sistem");
            throw new PyetjaException("Pyetja me ; " + id + " nuk mundet te gjendet ne sistem");
        }

        return pyetjaEntity;

    }

    @Override
    public PyetjaEntity update(PyetjaEntity newPyetja) throws PyetjaException {


        return null;
    }

    @Override
    public void delete(PyetjaEntity pyetjaEntity) throws PyetjaException {
    }

    @Override
    public List<PyetjaEntity> findAllByQuizID(Long id) throws PyetjaException {
        List<PyetjaEntity> pyetjaEntityList;

        pyetjaEntityList = pyetjaRepository.findAllByQuizID(id);

        if(pyetjaEntityList.size() == 0){
            logger.error("Nuk u kthyen asnje pytje gjatesia e listes eshte 0");
            throw new PyetjaException("Nuk u kthyen asnje pytje gjatesia e listes eshte 0\"");
        }

        return pyetjaEntityList;
    }

    @Override
    public List<PyetjaEntity> findAllPergjigjetByQuizID(Long id) throws PyetjaException {
        List<PyetjaEntity> pergjigjetList;

        pergjigjetList = pyetjaRepository.findAllPergjigjetByQuizID(id);

        if(pergjigjetList.size() == 0){
            logger.error("Nuk u kthyen asnje pergjigje gjatesia e listes eshte 0");
            throw new PyetjaException("Nuk u kthyen asnje pergjigje gjatesia e listes eshte 0\"");
        }

        return pergjigjetList;
    }

    @Override
    public List<PyetjaEntity> findThreePytjetMeMaxPike() throws PyetjaException {
        return pyetjaRepository.findThreePytjetMeMaxPike();
    }

    @Override
    public List<PyetjaEntity> findThreePytjetMeMaxPikeByQuizID(Long id) throws PyetjaException {
        return pyetjaRepository.findThreePytjetMeMaxPikeByQuizID(id);
    }

    @Override
    public Integer getNumrinEpyetjeve() throws PyetjaException {
        return pyetjaRepository.getNumrinEpyetjeve();
    }
}
