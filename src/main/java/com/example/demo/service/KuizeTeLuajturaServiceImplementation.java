package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuizeTeLuajturaEntity;
import com.example.demo.model.KuiziEntity;
import com.example.demo.repository.KuizeTeLuajturaRepository;
import com.example.demo.repository.KuiziRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KuizeTeLuajturaServiceImplementation implements KuizeTeLuajturaService{




    private KuizeTeLuajturaRepository kuizeTeLuajturaRepository;

    @Autowired
    private KuizeTeLuajturaService kuizeTeLuajturaService;


    public KuizeTeLuajturaServiceImplementation(KuizeTeLuajturaRepository kuizeTeLuajturaRepository){
        this.kuizeTeLuajturaRepository = kuizeTeLuajturaRepository;
    }

    public void setQuestionService(KuizeTeLuajturaService kuizeTeLuajturaService) {
        this.kuizeTeLuajturaService =kuizeTeLuajturaService;
    }


    @Override
    public KuizeTeLuajturaEntity save(KuizeTeLuajturaEntity kuizeTeLuajturaEntity) throws KuiziException {
        return kuizeTeLuajturaRepository.save(kuizeTeLuajturaEntity);
    }

    @Override
    public KuizeTeLuajturaEntity find(Long id) throws KuiziException {

        KuizeTeLuajturaEntity kuizeTeLuajturaEntity = kuizeTeLuajturaRepository.getOne(id);

        if(kuizeTeLuajturaEntity == null){
            throw new KuiziException("Nuk u kthye asnje e dhene");
        }
        return kuizeTeLuajturaEntity;
    }

    @Override
    public KuizeTeLuajturaEntity update(KuizeTeLuajturaEntity newKuizi) throws KuiziException {

        return null;
    }

    @Override
    public void delete(KuizeTeLuajturaEntity kuizeTeLuajturaEntity) throws KuiziException {

    }

    @Override
    public Integer getKuizeTeLuajtura() throws KuiziException {
        return kuizeTeLuajturaRepository.getKuizeTeLuajtura();
    }
}
