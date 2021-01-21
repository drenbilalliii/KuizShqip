package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuizeteluajturaEntity;
import com.example.demo.repository.KuizeTeLuajturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public KuizeteluajturaEntity save(KuizeteluajturaEntity kuizeTeLuajturaEntity) throws KuiziException {
        return kuizeTeLuajturaRepository.save(kuizeTeLuajturaEntity);
    }

    @Override
    public KuizeteluajturaEntity find(Long id) throws KuiziException {

        KuizeteluajturaEntity kuizeTeLuajturaEntity = kuizeTeLuajturaRepository.getOne(id);

        if(kuizeTeLuajturaEntity == null){
            throw new KuiziException("Nuk u kthye asnje e dhene");
        }
        return kuizeTeLuajturaEntity;
    }

    @Override
    public KuizeteluajturaEntity update(KuizeteluajturaEntity newKuizi) throws KuiziException {

        return null;
    }

    @Override
    public void delete(KuizeteluajturaEntity kuizeTeLuajturaEntity) throws KuiziException {

    }

    @Override
    public Integer getKuizeTeLuajtura() throws KuiziException {
        return kuizeTeLuajturaRepository.getKuizeTeLuajtura();
    }


    @Override
    public Integer countSaNjerzKanMePakPike(Integer kuiziID, Integer pike) throws KuiziException {
        return kuizeTeLuajturaRepository.countSaNjerzKanMePakPike(kuiziID,pike);
    }

    @Override
    public List<String> getKuizinMeTeLuajturin() throws KuiziException {
        return kuizeTeLuajturaRepository.getKuizinMeTeLuajturin();
    }
}
