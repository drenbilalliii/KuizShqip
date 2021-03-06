package com.example.demo.service;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.JsPytjeEntity;
import com.example.demo.model.KuiziEntity;
import com.example.demo.model.PyetjaEntity;
import com.example.demo.repository.KuiziRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Dren Bilalli on 1/10/2021
 */
@Service
public class KuiziServiceImplementation implements KuiziService{


    private static final Logger logger = LoggerFactory.getLogger(KuiziServiceImplementation.class); // per debbuging

    private KuiziRepository kuiziRepository;

    private List<KuiziEntity> kuiziEntityListFour = new ArrayList<>();

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
    public KuiziEntity find(Integer id) throws KuiziException {

        Optional<KuiziEntity> kuiziEntity = kuiziRepository.findById(id);

        if(kuiziEntity == null) {
            logger.error(id + " nuk gjendet");
            throw new KuiziException("Kuizi me id : " + id + " nuk u gjendet ne sistem!");
        }

        return kuiziEntity.get();
    }

    @Override
    public KuiziEntity update(KuiziEntity newKuizi) {
        //me vone
        return null;
    }

    @Override
    public void delete(Integer kuiziID) {

        kuiziRepository.deleteByKuiziId(kuiziID);

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

    @Override
    public List<KuiziEntity> teGjitheKuizet() throws KuiziException {

        List<KuiziEntity> teGjitheKuizet = kuiziRepository.findAll();

        if(teGjitheKuizet.size() == 0){
            logger.error("Nuk ka asnje kuiz ne sistem");
            throw new KuiziException("Nuk u kthye asnje rezultat");
        }
        return teGjitheKuizet;
    }

    @Override
    public Integer countAllKuizet() throws KuiziException {
        return  kuiziRepository.countAllKuizet();
    }

    @Override
    @PostConstruct
    @Scheduled(cron = "0 */15 * ? * *")
    public void updateList30Min() throws KuiziException {

        kuiziEntityListFour = kuiziRepository.KaterRandomKuize();
    }

    @Override
    public List<KuiziEntity> teGjitheKuizetJavaScript() throws KuiziException {
        List<KuiziEntity> teGjitheKuizet = kuiziRepository.gjejKuizetJavaScript();

        if(teGjitheKuizet.size() == 0){
            logger.error("Nuk ka asnje kuiz ne sistem");
            throw new KuiziException("Nuk u kthye asnje rezultat");
        }
        return teGjitheKuizet;
    }

    @Override
    public List<KuiziEntity> katerKuizetEDatesSotshme() throws KuiziException, ParseException {



        List<KuiziEntity> teGjitheKuizet = kuiziRepository.findByDataSotshme(LocalDate.now());


//        if(teGjitheKuizet.size() == 0){
//            logger.error("Nuk ka asnje kuiz ne sistem");
//            throw new KuiziException("Nuk u kthye asnje rezultat");
//        }
        return teGjitheKuizet;
    }

    @Override
    public String getEmriKuizitByID(Integer id) throws KuiziException {
        return kuiziRepository.getEmriKuizitByID(id);
    }

    @Override
    public int [] countPergjigjenESakta(List<String> userPergjigje, List<PyetjaEntity> pyetjaEntities) throws KuiziException {

        int piketShuma = 0;

        int countPytjeTeSakta = 0;

        for(int i=0;i<userPergjigje.size();i++){
            if(userPergjigje.get(i).equalsIgnoreCase(pyetjaEntities.get(i).getOpsioniSakt())){
                countPytjeTeSakta++;
                piketShuma+=pyetjaEntities.get(i).getPiket();
            }
        }
        return new int[]{countPytjeTeSakta,piketShuma};

    }

    @Override
    public List<KuiziEntity> teGjithaNeBazeTeAdministratorit(String emriAdministratorit) throws KuiziException {
        return kuiziRepository.teGjithaNeBazeTeAdministratorit(emriAdministratorit);
    }


    @Override
    public List<KuiziEntity> KaterRandomKuize() throws KuiziException {
        return kuiziEntityListFour;
    }



}
