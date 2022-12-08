package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.entity.Risposta;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.TypeTicketException;
import com.Project_N7.boat_management.rto.TypeTicketRTO;
import com.Project_N7.boat_management.service.TypeTicketService;
import com.Project_N7.boat_management.to.TypeTicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeTicketFacade {

    @Autowired
    TypeTicketService typeTicketService;

    public TypeTicketRTO getTypeTicketById(Integer idTypeTicket) throws TypeTicketException {
        if (!typeTicketService.idTypeTicketExist(idTypeTicket)) {
            throw new TypeTicketException("Id non presente");
        }

        return typeTicketService.getTypeTicketById(idTypeTicket);
    }

    public Object typeTicketSave(TypeTicketTO typeTicketTO) {
        Integer idTypeTicket = typeTicketService.typeTicketSave(typeTicketTO);
        Risposta risp = new Risposta();
        if (idTypeTicket != null){
            risp.setResponse("TypeTicket Creato con successo");
        } else {
            risp.setResponse("La tipologia di ticket non è stata creata");
        }
        return risp;
    }

    public List<Integer> getAllTypeTicket() throws IdException { return typeTicketService.getAllTypeTicket(); }


}
