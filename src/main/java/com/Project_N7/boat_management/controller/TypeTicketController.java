package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsTypeTicket;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.facade.TypeTicketFacade;
import com.Project_N7.boat_management.repository.TypeTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


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
    @GetMapping(value = "/boat/typeTicketAllList")
    public ResponseEntity<Object> getAllTypeTicket() {
        List<Integer> typeTicketRTOs;
        try {
            typeTicketRTOs = typeTicketFacade.getAllTypeTicket();
        } catch (IdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        if (typeTicketRTOs.isEmpty()) {
            return new ResponseEntity<>("Nessuna tipologia di ticket è presente nel database", HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(typeTicketRTOs,HttpStatus.OK);
        }

    }

}