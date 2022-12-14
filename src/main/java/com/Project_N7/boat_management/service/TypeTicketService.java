package com.Project_N7.boat_management.service;

import com.Project_N7.boat_management.entity.TypeTicket;
import com.Project_N7.boat_management.repository.TypeTicketRepository;
import com.Project_N7.boat_management.rto.TypeTicketRTO;
import com.Project_N7.boat_management.to.TypeTicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeTicketService {

    @Autowired
    private TypeTicketRepository typeTicketRepository;

    private TypeTicketRTO populateTypeTicketRTO (TypeTicket typeTicket){
        TypeTicketRTO typeTicketRTOtemp = new TypeTicketRTO();

        typeTicketRTOtemp.setIdTypeTicket(typeTicket.getIdTypeTicket());
        typeTicketRTOtemp.setDescription(typeTicket.getDescription());
        return typeTicketRTOtemp;
    }

    public TypeTicketRTO getTypeTicketById(Integer idTypeTicket) {

        return populateTypeTicketRTO(typeTicketRepository.getTypeTicketById(idTypeTicket));
    }

    public boolean idTypeTicketExist(Integer idTypeTicket) { return (typeTicketRepository.getTypeTicketById(idTypeTicket)!= null); }

    public Integer typeTicketSave(TypeTicketTO ticketTO){
        TypeTicket typeTicketToSave = new TypeTicket();

        typeTicketToSave.setDescription(ticketTO.getDescription());
        return typeTicketRepository.save(typeTicketToSave).getIdTypeTicket();

    }

    public List<TypeTicketRTO> convertTypeTicketTOTypeTicketRTO(List<TypeTicket> typeTicketList) {
        List<TypeTicketRTO> typeTicketRTOList = new ArrayList<>();

        for (TypeTicket typeTicket : typeTicketList) {
            TypeTicketRTO typeTicketRTOtemp = populateTypeTicketRTO(typeTicket);

            typeTicketRTOList.add(typeTicketRTOtemp);
        }
        return typeTicketRTOList;
    }

    public List<TypeTicket> getAllTypeTicket() { return typeTicketRepository.getAllTypeTicket(); }

}
