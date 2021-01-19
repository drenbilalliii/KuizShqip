package com.example.demo.service;

import com.example.demo.exceptions.NashornException;
import com.example.demo.model.JsPytjeEntity;

import java.util.List;

public interface JsPytjeService {


    JsPytjeEntity save(JsPytjeEntity jsPytjeEntity) throws NashornException;

    JsPytjeEntity find(Long id) throws NashornException;

    JsPytjeEntity update(JsPytjeEntity newJsPyetja) throws NashornException;

    void delete(JsPytjeEntity jsPytjeEntity) throws NashornException;

    List<JsPytjeEntity> findAllJs() throws NashornException;

    List<String> findByPergjigja() throws NashornException;

    List<JsPytjeEntity> findByQuizID(Integer id) throws NashornException;
}

