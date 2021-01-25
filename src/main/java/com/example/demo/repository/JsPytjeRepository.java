package com.example.demo.repository;

import com.example.demo.model.JsPytjeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JsPytjeRepository  extends JpaRepository<JsPytjeEntity,Long> {


    @Query(value = "SELECT p.Pergjigjja from js_pytje p",nativeQuery = true)
    public List<String> findByPergjigja();

    @Query(value = "select * from js_pytje where KuiziID = ?1",nativeQuery = true)
    public List<JsPytjeEntity> findAllByQuizID(Long id);


}
