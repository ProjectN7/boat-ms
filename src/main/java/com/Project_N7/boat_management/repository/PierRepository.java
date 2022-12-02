package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Pier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PierRepository extends JpaRepository<Pier, Long> {
    @Query("SELECT p.idPier FROM Pier p")
    List<Long> getAllPier();

    @Query("SELECT p " + "FROM Pier p WHERE p.idPier IN ?1")
    Pier getPierById(Long idPier);


}
