package com.example.demo.repository;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuiziEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Dren Bilalli on 1/9/2021
 */

@Repository
public interface KuiziRepository extends JpaRepository<KuiziEntity,Integer> {


    @Override
    <S extends KuiziEntity> S save(S s);

    @Query(value ="select top 3 * from Kuizi k order by k.KuiziID DESC",nativeQuery = true)
    public List<KuiziEntity> TreKuizetEFundit() throws KuiziException;

    @Query(value = "select count(*) from Kuizi",nativeQuery = true)
    public Integer countAllKuizet();

    @Query(value = "SELECT TOP 4 * FROM Kuizi ORDER BY NEWID()",nativeQuery = true)
    public List<KuiziEntity> KaterRandomKuize();

    @Query(value = "select * from Kuizi k where k.kategoria = 'Java Script' ",nativeQuery = true)
    public List<KuiziEntity> gjejKuizetJavaScript();

    @Query(value = "select * from Kuizi where  not Kategoria = 'Java Script'",nativeQuery = true)
    public List<KuiziEntity> findAll();

    @Query(value = "select  TOP 4 * from Kuizi where datakuizit = :datakrijimit ",nativeQuery = true)
    public List<KuiziEntity> findByDataSotshme(@Param("datakrijimit") LocalDate datakrijimit);

    @Query(value = "select emri_kuizit from Kuizi where KuiziID = :numriID",nativeQuery = true)
    public String getEmriKuizitByID(@Param("numriID") Long id);

    @Query(value = "select * from Kuizi where Administratori =?1",nativeQuery = true)
    public List<KuiziEntity> teGjithaNeBazeTeAdministratorit(String administratori);

    @Transactional
    @Modifying
    @Query(value = "delete from Kuizi where  KuiziID =?1",nativeQuery = true)
    public void deleteByKuiziId(Integer id);
}
