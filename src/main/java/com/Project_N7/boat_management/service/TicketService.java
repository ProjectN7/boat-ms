package com.Project_N7.boat_management.service;


import com.Project_N7.boat_management.entity.Ticket;
import com.Project_N7.boat_management.repository.TicketRepository;
import com.Project_N7.boat_management.rto.TicketRTO;
import com.Project_N7.boat_management.to.TicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    public TicketRTO getTicketById (Long idTicket){

        return populateTicketRTO(ticketRepository.getTicketById(idTicket));
    }

    private TicketRTO populateTicketRTO (Ticket ticket){
        TicketRTO ticketRTOtemp = new TicketRTO();

        ticketRTOtemp.setIdTicket(ticket.getIdTicket());
        ticketRTOtemp.setLicencePlate(ticket.getLicencePlate());
        ticketRTOtemp.setIdTypeTicket(ticket.getIdTypeTicket());
        ticketRTOtemp.setDate(ticket.getDate());
        ticketRTOtemp.setDescription(ticket.getDescription());
        ticketRTOtemp.setIsActive(ticket.getIsActive());
        return ticketRTOtemp;
    }

    public boolean idTicketExist(Long idTicket) { return (ticketRepository.getTicketById(idTicket)!= null); }

    public Long ticketSave(TicketTO ticketTO){
        Ticket ticketToSave = new Ticket();
        ticketToSave.setLicencePlate(ticketTO.getLicencePlate());
        ticketToSave.setDate(ticketTO.getDate());
        ticketToSave.setIdTypeTicket(ticketTO.getIdTypeTicket());
        ticketToSave.setDescription(ticketTO.getDescription());
        ticketToSave.setIsActive(1);
        return ticketRepository.save(ticketToSave).getIdTicket();
    }

    public List<TicketRTO> convertTicketTOTicketRTO(List<Ticket> ticketList) {
        List<TicketRTO> ticketRTOList = new ArrayList<>();

        for (Ticket ticket : ticketList) {
            TicketRTO ticketRTOtemp = populateTicketRTO(ticket);
            ticketRTOList.add(ticketRTOtemp);
        }
        return ticketRTOList;
    }

    public List<Long> getAllTicket() { return ticketRepository.getAllTicket(); }

    public List<String> getAllLicencePlateActive() { return ticketRepository.getAllLicencePlateActive(); }


    public void deleteTicketById(Long idTicket) { ticketRepository.deleteTicketById(idTicket); }

    public List<Ticket> getTicketByLicencePlate(String licencePlate) { return (ticketRepository.getTicketByLicencePlate(licencePlate)); }

    public boolean ticketByLicencePlateExist(String licencePlate) { return (ticketRepository.getTicketByLicencePlate(licencePlate)!= null); }

    public List<Integer> getIdTicketSameIdTypeTicket(String licencePlate, Integer idTypeTicket) { return  (ticketRepository.getIdTicketSameIdTypeTicket(licencePlate, idTypeTicket)); }
}
