package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuiziEntity;
import com.example.demo.repository.KuiziRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Dren Bilalli on 1/10/2021
 */
@Service
public class KuiziServiceImplementation implements KuiziService {


    private static final Logger logger = LoggerFactory.getLogger(KuiziServiceImplementation.class); // per debbuging

    private KuiziRepository kuiziRepository;

    @Autowired
    private KuiziService kuiziService;


    public KuiziServiceImplementation(KuiziRepository kuiziRepository){
        this.kuiziRepository = kuiziRepository;
    }

    public void setQuestionService(KuiziService kuiziService) {
        this.kuiziService = kuiziService;
    }


    @Override
    public KuiziEntity save(KuiziEntity kuiziEntity) {

         return kuiziRepository.save(kuiziEntity);
    }

    @Override
    public KuiziEntity find(Long id) throws KuiziException {

        KuiziEntity kuiziEntity = kuiziRepository.getOne(id);

        if(kuiziEntity == null) {
            logger.error(id + " nuk gjendet");
            throw new KuiziException("Kuizi me id : " + id + " nuk u gjendet ne sistem!");
        }

        return kuiziEntity;
    }

    @Override
    public KuiziEntity update(KuiziEntity newKuizi) {
        //me vone
        return null;
    }

    @Override
    public void delete(KuiziEntity kuiziEntity) {

        //me vone
    }

    @Override
    public List<KuiziEntity> TreKuizetEFundit() throws KuiziException {

        List<KuiziEntity> lista3KuizFundit =  kuiziRepository.TreKuizetEFundit();

        if(lista3KuizFundit.size() == 0){
            logger.error("Nuk ka asnje kuiz ne sistem");
            throw new KuiziException("Nuk u kthye asnje rezultat ");
        }

        return lista3KuizFundit;
    }
}
