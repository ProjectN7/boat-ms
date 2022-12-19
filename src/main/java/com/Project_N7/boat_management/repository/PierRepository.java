package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Pier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PierRepository extends JpaRepository<Pier, Integer> {
    @Query("SELECT p.idPier FROM Pier p")
    List<Long> getAllPier();

    @Query("SELECT p.idPier FROM Pier p WHERE p.idPier = ?1")
    Pier getPierById(int idPier);
}
