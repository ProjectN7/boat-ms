package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Pier;
import com.Project_N7.boat_management.entity.Quayside;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuaysideRepository extends JpaRepository<Quayside, Long> {

    Pier pier = new Pier();
    @Query("SELECT q.idQuayside FROM Quayside q")
    List<Long> getAllQuayside();

    @Query("SELECT q.name FROM Quayside q WHERE q.isActive = 0 AND q.pier = ?1")
    List<String> getQuaysideById(Long pier);

    @Query("SELECT q.idQuayside FROM Quayside q WHERE q.idQuayside = ?1")
    Quayside getQuaysideByIdToChange(Long idQuayside);


    @Query("select q.name from Quayside q where IS_ACTIVE = 0 AND ID_PIER = :idPier")
    List<Quayside> findPierByQuayside(@Param("idPier") Long idPier);

}
