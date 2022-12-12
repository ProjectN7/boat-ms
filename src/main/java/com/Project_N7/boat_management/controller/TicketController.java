package com.Project_N7.boat_management.controller;


import com.Project_N7.boat_management.checkerrors.CheckErrorsTicket;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.exception.TypeTicketException;
import com.Project_N7.boat_management.facade.TicketFacade;
import com.Project_N7.boat_management.repository.TicketRepository;
import com.Project_N7.boat_management.rto.ReservationRTO;
import com.Project_N7.boat_management.rto.TicketRTO;
import com.Project_N7.boat_management.to.ReservationTO;
import com.Project_N7.boat_management.to.TicketTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        } catch (IdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(ticketRTOs, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/ticket/reservationListLicencePlate")
    public ResponseEntity<Object> getReservationFromLicencePlate(@RequestParam String licencePlate) {
        TicketRTO ticketRTOs;
        try {
            ticketRTOs = ticketFacade.getTicketByLicencePlate(licencePlate);
        } catch (LicencePlateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticketRTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/ticket/reservationTicket")
    public ResponseEntity<Object> reservationSave(@Valid @RequestBody TicketTO ticketTO){
        try {
            errors.checkExistLicencePlate(ticketTO.getLicencePlate(), ticketTO.getIdTypeTicket());
        } catch (TypeTicketException e) {
            return new ResponseEntity<>(e.getErrorRTOList(), e.getHttpStatus());
        }
        return new ResponseEntity<>(ticketFacade.ticketSave(ticketTO), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/ticket/deleteTicketById")
    public ResponseEntity<Object> deleteTicketById(@RequestParam Long idTicket){
        try {
            errors.checkExistId(idTicket);
        } catch (IdException e) {
            return new ResponseEntity<>(e.getErrorRTOList(), e.getHttpStatus());
        }
        return new ResponseEntity<>(ticketFacade.deleteTicketById(idTicket), HttpStatus.OK);
    }


}
