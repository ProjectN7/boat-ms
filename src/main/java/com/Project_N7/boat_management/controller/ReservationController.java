package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsBoat;
import com.Project_N7.boat_management.checkerrors.CheckErrorsReservation;
import com.Project_N7.boat_management.entity.Boat;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.facade.BoatFacade;
import com.Project_N7.boat_management.facade.ReservationFacade;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.rto.ReservationRTO;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import com.Project_N7.boat_management.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationFacade reservationFacade;

    @Autowired
    private CheckErrorsReservation errors;

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


}
