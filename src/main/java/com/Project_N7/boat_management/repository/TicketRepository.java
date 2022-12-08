package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.idTicket IN ?1")
    Ticket getTicketById(Long id);

    @Query("DELETE FROM Ticket WHERE idTicket = ?1")
    void deleteTicketById(Long id);

    @Query("DELETE FROM Ticket t WHERE t.licencePlate = ?1")
    void deleteTicketByLicencePlate(String licencePlate);

    @Query("SELECT t FROM Ticket t WHERE t.licencePlate = ?1")
    Ticket getTicketByLicencePlate (String licencePlate);

    @Query("SELECT t FROM Ticket t")
    List<Long> getAllTicket();


    //Da testare
    @Transactional
    @Modifying(clearAutomatically = true,flushAutomatically = true)
    @Query(value = "UPDATE ticket SET is_Active = 0 WHERE  t.idTicket = ?1", nativeQuery = true)
    void updateTicket(@Param("idTicket") Long idTicket);
}
