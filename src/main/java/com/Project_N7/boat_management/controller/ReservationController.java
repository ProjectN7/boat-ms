package com.Project_N7.boat_management.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsReservation;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.facade.ReservationFacade;
import com.Project_N7.boat_management.repository.ReservationRepository;
import com.Project_N7.boat_management.rto.ReservationRTO;
import com.Project_N7.boat_management.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

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
        } catch (IdException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(reservationRTOs,HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/reservation/reservationListLicencePlate")
    public ResponseEntity<Object> getReservationFromLicencePlate(@RequestParam String licencePlate) {
        ReservationRTO reservationRTOs;
        try {
            reservationRTOs = reservationFacade.getReservationByLicencePlate(licencePlate);
        } catch (LicencePlateException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservationRTOs, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/reservation/reservationSave")
    public ResponseEntity<Object> reservationSave(@Valid @RequestBody ReservationTO reservationTO){
        try {
            errors.checkExistLicencePlate(reservationTO.getLicencePlate());
        } catch (LicencePlateException e) {
            return new ResponseEntity<>(e.getErrorRTOList(), e.getHttpStatus());
        }
        return new ResponseEntity<>(reservationFacade.reservationSave(reservationTO), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/boat/reservationAllList")
    public ResponseEntity<Object> getAllReservation() {
        List<Long> reservationRTOs;
        try {
            reservationRTOs = reservationFacade.getAllReservation();
        } catch (IdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        if (reservationRTOs.isEmpty()) {
            return new ResponseEntity<>("Nessuna barca presente nel database", HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(reservationRTOs,HttpStatus.OK);
        }

    }


    @CrossOrigin
    @GetMapping(path = "/reservation/reservationDelete")
    public ResponseEntity<Object> deleteReservation(@RequestParam Long idReservation){
        try {
            errors.checkExistId(idReservation);
        } catch (IdException e) {
            return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
        }
        return new ResponseEntity<>(reservationFacade.deleteReservationById(idReservation), HttpStatus.OK);
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


