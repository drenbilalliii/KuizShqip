package com.example.demo.repository;

import com.example.demo.model.KuiziEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dren Bilalli on 1/9/2021
 */

@Repository
public interface KuiziRepository extends JpaRepository<KuiziEntity,Long> {


    @Override
    <S extends KuiziEntity> S save(S s);


}
