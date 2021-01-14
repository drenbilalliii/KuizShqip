package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.exceptions.NashornException;
import com.example.demo.model.JsPytjeEntity;
import com.example.demo.model.KuizeTeLuajturaEntity;

import java.util.List;

public interface JsPytjeService {


    JsPytjeEntity save(JsPytjeEntity jsPytjeEntity) throws NashornException;

    JsPytjeEntity find(Long id) throws NashornException;

    JsPytjeEntity update(JsPytjeEntity newJsPyetja) throws NashornException;

    void delete(JsPytjeEntity jsPytjeEntity) throws NashornException;

    List<JsPytjeEntity> findAllJs() throws NashornException;

    List<String> findByPergjigja() throws NashornException;
}

