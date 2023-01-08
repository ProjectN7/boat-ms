package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BoatRepository extends JpaRepository<Boat, String> {

    @Query("SELECT b " + "FROM Boat b WHERE b.licencePlate= ?1")
    Boat getBoatByLicencePlate(String licencePlate);

    @Query(value = "SELECT  b.licencePlate " + "FROM Boat b " + "WHERE b.licencePlate = ?1")
    String licencePlateExist(String licencePlate);

    @Query("SELECT b.licencePlate FROM Boat b")
    List<String> getAllBoat();

    @Query("SELECT b.licencePlate FROM Boat b WHERE b.cf = ?1")
    List<String> getLicencePlateByCf(String cf);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Boat b WHERE b.licencePlate = ?1")
    void boatDelete(String licencePlate);







}
