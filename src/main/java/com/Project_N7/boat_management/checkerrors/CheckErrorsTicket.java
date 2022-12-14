package com.Project_N7.boat_management.checkerrors;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.Project_N7.boat_management.service.TicketService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class CheckErrorsTicket {

    @Autowired
    private TicketService ticketService;

    //Modificalo con il TypeTicket
    public void checkExistLicencePlate(String licencePlate, Integer idTypeTicket) throws ErrorException {
        ErrorRTO error = new ErrorRTO();
        if (!ticketService.getIdTicketSameIdTypeTicket(licencePlate, idTypeTicket).isEmpty()) {
         error.setMessage(TICKET_ALREADY_PRESENT);
        }
        /*Cambiare dependecies aggiungere le StringUtils*/
        if (StringUtils.isNotBlank(error.getMessage())) {
            throw new ErrorException(error.getMessage());
        }
    }

    public void checkExistId(Long idTicket) throws ErrorException {
        if (!ticketService.idTicketExist(idTicket)) {
            throw new ErrorException(TICKET_WITH_ID + idTicket + NOT_PRESENT);
        }
    }


    public void checkTicketByLicencePlateExist(String licencePlate) throws ErrorException {
        if (!ticketService.ticketByLicencePlateExist(licencePlate)) {
            throw new ErrorException(LICENCE_PLATE + licencePlate + NOT_PRESENT);
        }
    }
}
