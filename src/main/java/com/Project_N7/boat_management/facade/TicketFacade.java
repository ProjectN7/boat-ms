package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.entity.Risposta;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.TicketRTO;
import com.Project_N7.boat_management.service.TicketService;
import com.Project_N7.boat_management.to.TicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketFacade {

    @Autowired
    TicketService ticketService;

    public TicketRTO getTicketById(Long idTicket) throws IdException {
        if (!ticketService.idTicketExist(idTicket)) {
            throw new IdException("Id non presente");
        }

        return ticketService.getTicketById(idTicket);
    }

    public TicketRTO getTicketByLicencePlate(String licencePlate) throws LicencePlateException{
        if(!ticketService.ticketByLicencePlateExist(licencePlate)){
            throw new LicencePlateException("Targa non presente");
        }
        return  ticketService.getTicketByLicencePlate(licencePlate);
    }

    public Object ticketSave(TicketTO ticketTO) {
        Long idTicket = ticketService.ticketSave(ticketTO);
        Risposta risp = new Risposta();
        if (idTicket != null) {
            risp.setResponse("Ticket creato con successo");
        } else {
            risp.setResponse("Il ticket non è stato inserito");
        }
        return risp;
    }

    public List<Long> getAllTicket() throws IdException { return ticketService.getAllTicket(); }

    public Object deleteReservationByLicencePlate (String licencePlate) {
        Risposta risp = new Risposta();
        if(licencePlate != null) {
            ticketService.deleteTicketByLicencePlate(licencePlate);
            risp.setResponse("Ticket cancellato con successo");
            return risp;
        }
        return "";
    }
}
