package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Pier;
import com.Project_N7.boat_management.entity.Quayside;
import com.Project_N7.boat_management.rto.QuaysideRTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuaysideRepository extends JpaRepository<Quayside, Long> {

    Pier pier = new Pier();
    @Query("SELECT q.idQuayside FROM Quayside q")
    List<Long> getAllQuayside();

    @Query("SELECT q.name FROM Quayside q WHERE q.pier = ?1")
    List<String> getQuaysideById(Long pier);

    @Query("SELECT q.idQuayside FROM Quayside q WHERE q.idQuayside = ?1")
    Quayside getQuaysideByIdToChange(Long idQuayside);

}
