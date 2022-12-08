package com.Project_N7.boat_management.repository;

import com.Project_N7.boat_management.entity.TypeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeTicketRepository extends JpaRepository<TypeTicket, Integer> {

    @Query("SELECT ty FROM TypeTicket ty")
    List<Integer> getAllTypeTicket();

    @Query("SELECT ty FROM TypeTicket ty WHERE ty.idTypeTicket = ?1")
    TypeTicket getTypeTicketById(Integer id);


}
