package com.example.demo.repository;


import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.PerdoruesiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.List;

/**
 * author Gramos Shala
 */
@Repository
public interface PerdoruesiRepository extends JpaRepository<PerdoruesiEntity,Long> {


    @Query(value = "SELECT  * FROM Perdoruesi where email =?1 and password =?2" ,nativeQuery = true)
    public PerdoruesiEntity findByEmailAndPassword(String username,String password) throws PerdoruesiException;
}
