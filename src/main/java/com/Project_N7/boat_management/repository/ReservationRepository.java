package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r " + "FROM Reservation r ")
    List<Long> getAllReservation();

    @Query("SELECT r FROM Reservation r WHERE r.idReservation IN ?1")
    Reservation getReservationByIds(Long ids);

    //Da vedere
    @Query(value = "SELECT r " + " FROM Reservation r" + " INNER JOIN r.boat b" + " WHERE b.licencePlate = ?1")
    List<Reservation> getReservationByLicencePlate(String licencePlate);

    //Da vedere
    @Query("SELECT r" + " FROM Reservation r" + " WHERE r.isActive = TRUE")
    List<Reservation> getAllReservationActive();
}
