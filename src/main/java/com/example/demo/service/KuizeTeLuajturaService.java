package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuizeTeLuajturaEntity;
import com.example.demo.model.KuiziEntity;

public interface KuizeTeLuajturaService {


    KuizeTeLuajturaEntity save(KuizeTeLuajturaEntity kuizeTeLuajturaEntity) throws KuiziException;

    KuizeTeLuajturaEntity find(Long id) throws KuiziException;

    KuizeTeLuajturaEntity update(KuizeTeLuajturaEntity newKuizi) throws KuiziException;

    void delete(KuizeTeLuajturaEntity kuizeTeLuajturaEntity) throws KuiziException;
}


