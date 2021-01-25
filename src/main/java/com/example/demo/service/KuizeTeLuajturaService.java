package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuizeteluajturaEntity;

import java.util.List;

public interface KuizeTeLuajturaService {


    KuizeteluajturaEntity save(KuizeteluajturaEntity kuizeTeLuajturaEntity) throws KuiziException;

    KuizeteluajturaEntity find(Long id) throws KuiziException;

    KuizeteluajturaEntity update(KuizeteluajturaEntity newKuizi) throws KuiziException;

    void delete(KuizeteluajturaEntity kuizeTeLuajturaEntity) throws KuiziException;

    Integer getKuizeTeLuajtura() throws KuiziException;

    Integer countSaNjerzKanMePakPike(Integer kuiziID,Integer pike) throws KuiziException;

    public List<String> getKuizinMeTeLuajturin() throws KuiziException;

    public void deleteByKuiziID(Integer id);
}


