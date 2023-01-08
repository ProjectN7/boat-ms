package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Ticket;
import com.Project_N7.boat_management.rto.TicketRTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.idTicket IN ?1")
    Ticket getTicketById(Long id);

    //Appena modificata, la quesry è stata testata su DB e funziona
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query("UPDATE Ticket SET isActive = 0 WHERE idTicket = ?1")
    void deleteTicketById(Long id);

    @Query("SELECT t FROM Ticket t WHERE t.licencePlate = ?1 AND t.isActive = 1")
    List<Ticket> getTicketByLicencePlate (String licencePlate);

    @Query("SELECT t FROM Ticket t")
    List<Long> getAllTicket();

    @Query("SELECT t.licencePlate FROM Ticket t WHERE t.isActive = 1")
    List<String> getAllLicencePlateActive();

    @Query(value = "SELECT idTicket FROM Ticket WHERE licencePlate = ?1 AND idTypeTicket = ?2")
    List<Integer> getIdTicketSameIdTypeTicket(String licencePlate, Integer idTypeTicket);

}
