package com.Project_N7.boat_management.controller;

import com.Project_N7.boat_management.checkerrors.CheckErrorsTypeTicket;
import com.Project_N7.boat_management.entity.TypeTicket;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.facade.TypeTicketFacade;
import com.Project_N7.boat_management.models.ServiceResponse;
import com.Project_N7.boat_management.repository.TypeTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;


@RestController
@CrossOrigin(origins = "")
public class TypeTicketController {

    @Autowired
    private TypeTicketFacade typeTicketFacade;

    @Autowired
    private CheckErrorsTypeTicket errors;

    @Autowired
    private TypeTicketRepository typeTicketRepository;

    @CrossOrigin
    @GetMapping(value = "/ticket/getAllTypeTicket")
    public ResponseEntity<Object> getAllTypeTicket() {
        List<TypeTicket> typeTickets;
        try {
            typeTickets = typeTicketFacade.getAllTypeTicket();
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, TYPE_TICKET_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        if (typeTickets.isEmpty()) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, TYPE_TICKET_NOT_FOUND), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), TYPE_TICKET_FOUND, TYPE_TICKET_FOUND, typeTickets), HttpStatus.OK);
        }

    }

}