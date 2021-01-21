package com.example.demo.repository;



import com.example.demo.model.KuizeteluajturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KuizeTeLuajturaRepository extends JpaRepository<KuizeteluajturaEntity,Long> {



    @Query(value = "select count(*) from KuizeTeLuajtura ",nativeQuery = true)
    public Integer getKuizeTeLuajtura();

    @Query(value = "select count(*) from KuizeTeLuajtura where KuiziID  = ?1 and Piket < ?2",nativeQuery = true)
    public Integer countSaNjerzKanMePakPike(Integer KuiziID,Integer piket);

    @Query(value = "select  p.KuiziID  ,count(*) as NumriPerseritjes from Kuizeteluajtura p group by KuiziID\n" +
            "having count(*) = (select max(NumriPerseritjes) from (select KuiziID,count(*)\n" +
            " as NumriPerseritjes from Kuizeteluajtura group by KuiziID)Kuizeteluajtura)",nativeQuery = true)
    public List<String> getKuizinMeTeLuajturin();
}


