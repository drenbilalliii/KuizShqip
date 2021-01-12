package com.example.demo.repository;

import com.example.demo.exceptions.KuiziException;
import com.example.demo.model.KuiziEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Dren Bilalli on 1/9/2021
 */

@Repository
public interface KuiziRepository extends JpaRepository<KuiziEntity,Long> {


    @Override
    <S extends KuiziEntity> S save(S s);

    @Query(value ="select top 3 * from Kuizi k order by k.KuiziID DESC",nativeQuery = true)
    public List<KuiziEntity> TreKuizetEFundit() throws KuiziException;


}
