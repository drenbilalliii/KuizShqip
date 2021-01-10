package com.example.demo.repository;

import com.example.demo.exceptions.PyetjaException;
import com.example.demo.model.KuiziEntity;
import com.example.demo.model.PyetjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface PyetjaRepository extends JpaRepository<PyetjaEntity,Long> {

    @Override
    <S extends PyetjaEntity> S save(S s);

    @Query(value = "select * from Pyetja where KuiziID = ?1",nativeQuery = true)
    public List<PyetjaEntity> findAllByQuizID(Long id) throws PyetjaException;
}
