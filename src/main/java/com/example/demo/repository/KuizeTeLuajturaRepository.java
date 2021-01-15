package com.example.demo.repository;


import com.example.demo.model.KuizeTeLuajturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KuizeTeLuajturaRepository extends JpaRepository<KuizeTeLuajturaEntity,Long> {



    @Query(value = "select count(*) from KuizeTeLuajtura ",nativeQuery = true)
    public Integer getKuizeTeLuajtura();
}
