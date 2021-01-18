package com.example.demo.repository;


import com.example.demo.exceptions.PerdoruesiException;
import com.example.demo.model.PerdoruesiEntity;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

/**
 * author Gramos Shala
 */

public interface PerdoruesiRepository {


    @Query(value = "SELECT  * FROM Perdoruesi where username =1?" ,nativeQuery = true)
    public PerdoruesiEntity findByEmailAndPassword() throws PerdoruesiException;
}
