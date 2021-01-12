package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuiziEntity;

import java.util.List;

public interface KuiziService {

    KuiziEntity save(KuiziEntity kuiziEntity) throws KuiziException;

    KuiziEntity find(Long id) throws KuiziException;

    KuiziEntity update(KuiziEntity newKuizi) throws KuiziException;

    void delete(KuiziEntity kuiziEntity) throws KuiziException;

    List<KuiziEntity> TreKuizetEFundit() throws KuiziException;
}
