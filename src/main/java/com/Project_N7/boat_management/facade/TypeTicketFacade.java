package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.entity.TypeTicket;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.TypeTicketRTO;
import com.Project_N7.boat_management.service.TypeTicketService;
import com.Project_N7.boat_management.to.TypeTicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class TypeTicketFacade {

    @Autowired
    TypeTicketService typeTicketService;

    public TypeTicketRTO getTypeTicketById(Integer idTypeTicket) throws ErrorException {
        if (!typeTicketService.idTypeTicketExist(idTypeTicket)) {
            throw new ErrorException(TYPE_TICKET_ID_NOT_FOUND);
        }

        return typeTicketService.getTypeTicketById(idTypeTicket);
    }

    public Object typeTicketSave(TypeTicketTO typeTicketTO) {
        Integer idTypeTicket = typeTicketService.typeTicketSave(typeTicketTO);
        String resp = "";
        if (idTypeTicket != null){
           resp = TYPE_TICKET_CREATED;
        } else {
            resp = TYPE_TICKET_NOT_CREATED;
        }
        return resp;
    }

    public List<TypeTicket> getAllTypeTicket() throws ErrorException { return typeTicketService.getAllTypeTicket(); }

    public String getTypeTicketName(int idTypeTicket) throws  ErrorException { return typeTicketService.getTypeTicketName(idTypeTicket); }



}
