package com.example.demo.repository;



import com.example.demo.model.KuizeteluajturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KuizeTeLuajturaRepository extends JpaRepository<KuizeteluajturaEntity,Long> {



    @Query(value = "select count(*) from KuizeTeLuajtura ",nativeQuery = true)
    public Integer getKuizeTeLuajtura();

    @Query(value = "select count(*) from KuizeTeLuajtura where KuiziID  = ?1 and Piket < ?2",nativeQuery = true)
    public Integer countSaNjerzKanMePakPike(Integer KuiziID,Integer piket);
}
