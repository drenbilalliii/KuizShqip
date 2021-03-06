package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuiziEntity;
import com.example.demo.model.PyetjaEntity;

import java.text.ParseException;
import java.util.List;

public interface KuiziService {

    KuiziEntity save(KuiziEntity kuiziEntity) throws KuiziException;

    KuiziEntity find(Integer id) throws KuiziException;

    KuiziEntity update(KuiziEntity newKuizi) throws KuiziException;

    void delete(Integer kuiziID) throws KuiziException;

    List<KuiziEntity> TreKuizetEFundit() throws KuiziException;

    List<KuiziEntity> teGjitheKuizet() throws KuiziException;

    public Integer countAllKuizet() throws KuiziException;

    public List<KuiziEntity> KaterRandomKuize() throws KuiziException;

    void updateList30Min() throws KuiziException;

    List<KuiziEntity> teGjitheKuizetJavaScript() throws KuiziException;

    List<KuiziEntity> katerKuizetEDatesSotshme() throws KuiziException, ParseException;

    String getEmriKuizitByID(Integer id) throws KuiziException;

    public  int [] countPergjigjenESakta(List<String> userPergjigje, List<PyetjaEntity> pyetjaEntities) throws KuiziException;

    List<KuiziEntity> teGjithaNeBazeTeAdministratorit(String emriAdministratorit) throws KuiziException;
}
