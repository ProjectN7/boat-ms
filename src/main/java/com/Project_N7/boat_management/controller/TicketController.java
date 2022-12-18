package com.Project_N7.boat_management.controller;


import com.Project_N7.boat_management.checkerrors.CheckErrorsTicket;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.facade.TicketFacade;
import com.Project_N7.boat_management.models.ServiceResponse;
import com.Project_N7.boat_management.repository.TicketRepository;
import com.Project_N7.boat_management.rto.TicketRTO;
import com.Project_N7.boat_management.to.TicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@RestController
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketFacade ticketFacade;

    @Autowired
    private CheckErrorsTicket errors;

    @Autowired
    private TicketRepository ticketRepository;

    @CrossOrigin
    @GetMapping(value = "/ticket/ticketListId")
    public ResponseEntity<Object> getTicketFromId(@RequestParam Long idTicket) {
        TicketRTO ticketRTOs;
        try {
            ticketRTOs = ticketFacade.getTicketById(idTicket);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, TICKET_NOT_FOUND, TICKET_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), TICKET_FOUND, TICKET_FOUND, ticketRTOs), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/ticket/reservationListLicencePlate")
    public ResponseEntity<Object> getReservationFromLicencePlate(@RequestParam String licencePlate) {
        TicketRTO ticketRTOs;
        try {
            ticketRTOs = ticketFacade.getTicketByLicencePlate(licencePlate);
        } catch (ErrorException e){
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, BOAT_NOT_FOUND, BOAT_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), TICKET_FOUND, TICKET_FOUND, ticketRTOs), HttpStatus.OK);

    }

    @CrossOrigin
    @PostMapping(value = "/ticket/reservationTicket")
    public ResponseEntity<Object> ticketSave(@Valid @RequestBody TicketTO ticketTO){
        try {
            errors.checkExistLicencePlate(ticketTO.getLicencePlate(), ticketTO.getIdTypeTicket());
        } catch (ErrorException e) {
        return new ResponseEntity<>(new ServiceResponse(CODE_409, HttpStatus.CONFLICT.name(), EXCEPTION, TICKET_ALREADY_PRESENT, e.getErrorRTO()), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), TICKET_FOUND, TICKET_FOUND, ticketFacade.ticketSave(ticketTO)), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/ticket/deleteTicketById")
    public ResponseEntity<Object> deleteTicketById(@RequestParam Long idTicket){
        try {
            errors.checkExistId(idTicket);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), TICKET_CANCELLED, TICKET_CANCELLED, ticketFacade.deleteTicketById(idTicket)), HttpStatus.OK);

    }

    @CrossOrigin
    @GetMapping(value = "/ticket/LicencePlateActive")
    public ResponseEntity<Object> getAllLicencePlateActive() {
        List<String> reservationRTOs;
        try {
            reservationRTOs = ticketFacade.getAllLicencePlateActive();
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        if (reservationRTOs.isEmpty()) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, BOAT_NOT_FOUND, BOAT_NOT_FOUND), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), QUAYSIDE_FOUND, QUAYSIDE_FOUND, reservationRTOs), HttpStatus.OK);
        }

    }
}
