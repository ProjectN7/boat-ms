package com.Project_N7.boat_management.repository;
import com.Project_N7.boat_management.entity.Pier;
import com.Project_N7.boat_management.to.PierTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PierRepository extends JpaRepository<Pier, Integer> {
    @Query("SELECT p.name FROM Pier p")
    List<String> getAllPier();

    @Query(value = "SELECT p.idPier " + "FROM Pier p" + " WHERE p.idPier = ?1")
    Pier getPierById(int idPier);


}
