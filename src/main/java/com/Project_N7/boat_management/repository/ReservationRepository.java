package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r " + "FROM Reservation r ")
    List<Long> getAllReservation();

    @Query("SELECT r FROM Reservation r WHERE r.idReservation IN ?1")
    Reservation getReservationByIds(Long ids);

    //Da vedere
    @Query("SELECT r FROM Reservation r WHERE r.licencePlate = ?1")
    Reservation getReservationByLicencePlate(String licencePlate);

    //Da vedere
    @Query("SELECT r.idReservation" + " FROM Reservation r" + " WHERE r.isActive = 1")
    List<Reservation> getAllReservationActive();

    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query("DELETE FROM Reservation WHERE licencePlate = ?1")
    void deleteReservationByLicencePlate(String licencePlate);


    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "UPDATE reservation SET is_Active = 0 WHERE dateTime_To <= :nowDateTime ", nativeQuery = true)
    void updateReservation(@Param("nowDateTime") String nowDateTime);

}
