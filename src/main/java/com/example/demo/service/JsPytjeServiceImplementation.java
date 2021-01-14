package com.example.demo.service;

import com.example.demo.exceptions.NashornException;
import com.example.demo.model.JsPytjeEntity;
import com.example.demo.repository.JsPytjeRepository;
import com.example.demo.repository.KuizeTeLuajturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dren Bilalli on 1/12/2021
 */

@Service
public class JsPytjeServiceImplementation implements JsPytjeService {


    private JsPytjeRepository jsPytjeRepository;

    @Autowired
    private JsPytjeService jsPytjeService;


    public JsPytjeServiceImplementation(JsPytjeRepository jsPytjeRepository){
        this.jsPytjeRepository =jsPytjeRepository;
    }

    public void setQuestionService(JsPytjeService jsPytjeService) {
        this.jsPytjeService =jsPytjeService;
    }


    @Override
    public JsPytjeEntity save(JsPytjeEntity jsPytjeEntity) throws NashornException {

        return jsPytjeRepository.save(jsPytjeEntity);
    }

    @Override
    public JsPytjeEntity find(Long id) throws NashornException {
        return null;
    }

    @Override
    public JsPytjeEntity update(JsPytjeEntity newJsPyetja) throws NashornException {
        return null;
    }

    @Override
    public void delete(JsPytjeEntity jsPytjeEntity) throws NashornException {

    }

    @Override
    public List<JsPytjeEntity> findAllJs() throws NashornException {
        return jsPytjeRepository.findAll();
    }

    @Override
    public List<String> findByPergjigja() throws NashornException {
        return  jsPytjeRepository.findByPergjigja();
    }
}