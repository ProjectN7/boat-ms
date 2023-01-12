package com.Project_N7.boat_management.controller;

import com.Project_N7.boat_management.checkerrors.CheckErrorsReservation;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.facade.ReservationFacade;
import com.Project_N7.boat_management.models.ServiceResponse;
import com.Project_N7.boat_management.repository.ReservationRepository;
import com.Project_N7.boat_management.rto.ReservationRTO;
import com.Project_N7.boat_management.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@RestController
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationFacade reservationFacade;

    @Autowired
    private CheckErrorsReservation errors;

    @Autowired
    private ReservationRepository reservationRepository;

    @CrossOrigin
    @GetMapping(value = "/reservation/reservationListId")
    public ResponseEntity<Object> getReservationFromId(@RequestParam Long idReservation) {
        ReservationRTO reservationRTOs;
        try {
            reservationRTOs = reservationFacade.getReservationById(idReservation);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), BOAT_FOUND, BOAT_FOUND, reservationRTOs), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/reservation/reservationListLicencePlate")
    public ResponseEntity<Object> getReservationFromLicencePlate(@RequestParam String licencePlate) {
        ReservationRTO reservationRTOs;
        try {
            reservationRTOs = reservationFacade.getReservationByLicencePlate(licencePlate);
        } catch (ErrorException e){
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, RESERVATION_NOT_FOUND, RESERVATION_NOT_FOUND), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), QUAYSIDE_FOUND, QUAYSIDE_FOUND, reservationRTOs), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/reservation/reservationSave")
    public ResponseEntity<Object> reservationSave(@Valid @RequestBody ReservationTO reservationTO){
        try {
            errors.checkIfReservationExistForLicencePlate(reservationTO.getLicencePlate());
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_409, HttpStatus.INTERNAL_SERVER_ERROR.name(), EXCEPTION, BOAT_NOT_FOUND, e.getMessage()), HttpStatus.CONFLICT);
        }
        if (reservationTO.getDateTimeFrom().after(reservationTO.getDateTimeTo())) {
            return new ResponseEntity<>(new ServiceResponse(CODE_409, HttpStatus.INTERNAL_SERVER_ERROR.name(), EXCEPTION, DATE_NOT_VALID, DATE_NOT_VALID), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), QUAYSIDE_FOUND, QUAYSIDE_FOUND, reservationFacade.reservationSave(reservationTO)), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/boat/reservationAllList")
    public ResponseEntity<Object> getAllReservation() {
        List<Long> reservationRTOs;
        try {
            reservationRTOs = reservationFacade.getAllReservation();
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        if (reservationRTOs.isEmpty()) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, BOAT_NOT_FOUND, BOAT_NOT_FOUND), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), QUAYSIDE_FOUND, QUAYSIDE_FOUND, reservationRTOs), HttpStatus.OK);
        }

    }

    @CrossOrigin
    @GetMapping(value = "/boat/LicencePlateActive")
    public ResponseEntity<Object> getAllLicencePlateActive(@RequestParam String cf) {
        List<String> reservationRTOs;
        try {
            reservationRTOs = reservationFacade.getAllLicencePlateActive(cf);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        if (reservationRTOs.isEmpty()) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, BOAT_NOT_FOUND, BOAT_NOT_FOUND), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), QUAYSIDE_FOUND, QUAYSIDE_FOUND, reservationRTOs), HttpStatus.OK);
        }

    }


    @CrossOrigin
    @GetMapping(path = "/reservation/reservationDelete")
    public ResponseEntity<Object> deleteReservation(@RequestParam Long idReservation){
        try {
            errors.checkExistId(idReservation);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), QUAYSIDE_FOUND, QUAYSIDE_FOUND, reservationFacade.deleteReservationById(idReservation)), HttpStatus.OK);
    }


    @Scheduled(cron = "0 0 0 * * *")
    public void scheduler() {
        java.util.Date nowDateTime = new java.util.Date();
        String ldt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        reservationRepository.updateReservation(ldt);
    }

    /*
    @GetMapping(value = "/boat/getDate")
    public ResponseEntity<Object> getDate() throws Exception{
        String ldt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        reservationRepository.updateReservation(ldt);
            return new ResponseEntity<>("Update Fatto!", HttpStatus.OK);
        }
     */

}


