package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuiziEntity;

public interface KuiziService {

    KuiziEntity save(KuiziEntity kuiziEntity);

    KuiziEntity find(Long id) throws KuiziException;

    KuiziEntity update(KuiziEntity newKuizi);

    void delete(KuiziEntity kuiziEntity);
}
