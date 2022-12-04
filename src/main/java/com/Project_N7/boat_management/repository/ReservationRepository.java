package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Boat;
import com.Project_N7.boat_management.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("SELECT r " + "FROM Reservation r ")
    List<Long> getAllReservation();

    @Query("SELECT r FROM Reservation r WHERE r.idReservation IN ?1")
    Reservation getReservationByIds(Long ids);

    //Da vedere
    @Query(value = "SELECT r " + " FROM Reservation r" + " INNER JOIN r.licencePlate l" + " WHERE l.licencePlate = ?1", nativeQuery = true)
    Reservation getReservationByLicencePlate(String licencePlate);

    //Da vedere
    @Query("SELECT r.idReservation" + " FROM Reservation r" + " WHERE r.isActive = TRUE")
    List<Reservation> getAllReservationActive();

    @Query("DELETE FROM Reservation WHERE licencePlate = ?1")
    String deleteReservationByLicencePlate(String licencePlate);
}
