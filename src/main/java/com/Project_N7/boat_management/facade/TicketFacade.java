package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.TicketRTO;
import com.Project_N7.boat_management.service.TicketService;
import com.Project_N7.boat_management.to.TicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class TicketFacade {

    @Autowired
    TicketService ticketService;

    public TicketRTO getTicketById(Long idTicket) throws ErrorException {
        if (!ticketService.idTicketExist(idTicket)) {
            throw new ErrorException(TICKET_ID_NOT_FOUND);
        }

        return ticketService.getTicketById(idTicket);
    }

    public TicketRTO getTicketByLicencePlate(String licencePlate) throws ErrorException{
        if(!ticketService.ticketByLicencePlateExist(licencePlate)){
            throw new ErrorException(LICENCE_PLATE_NOT_PRESENT);
        }
        return  ticketService.getTicketByLicencePlate(licencePlate);
    }

    public Object ticketSave(TicketTO ticketTO) {
        Long idTicket = ticketService.ticketSave(ticketTO);
        String resp = "";
        if (idTicket != null) {
            resp = TICKET_CREATED;
        } else {
            resp = TICKET_NOT_CREATED;
        }
        return resp;
    }

    public List<Long> getAllTicket() throws ErrorException { return ticketService.getAllTicket(); }

    public List<String> getAllLicencePlateActive() throws ErrorException { return ticketService.getAllLicencePlateActive(); }


    @Transactional
    public Object deleteTicketById (Long idTicket) {
        if (idTicket != null) {
            ticketService.deleteTicketById(idTicket);
            return TICKET_CANCELLED;
        }
        return TICKET_NOT_CANCELLED;
    }






}
