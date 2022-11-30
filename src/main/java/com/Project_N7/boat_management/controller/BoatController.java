package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsBoat;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.facade.BoatFacade;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class BoatController {

    @Autowired
    private BoatFacade boatFacade;

    @Autowired
    private CheckErrorsBoat errors;

    @GetMapping(value = "/boat/boatList")
    public ResponseEntity<Object> getBoatFromLicencePlate(@RequestParam String licencePlate) {
        BoatRTO boatRTOs;
        try {
            boatRTOs = boatFacade.getBoatByLicencePlate(licencePlate);
        } catch (LicencePlateException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

            return new ResponseEntity<>(boatRTOs,HttpStatus.OK);
        }

    @PostMapping(value = "/boat/boatSave")
    public ResponseEntity<Object> boatSave(@Valid @RequestBody BoatTO boatTO){
        try {
            errors.checkExistLicencePlate(boatTO.getLicencePlate());
        } catch (LicencePlateException e) {
            return new ResponseEntity<>(e.getErrorRTOList(), e.getHttpStatus());
        }
        return new ResponseEntity<>(boatFacade.boatSave(boatTO), HttpStatus.OK);
    }

    @PostMapping(path = "/modificaBoat/{licence_plate}")
    public ResponseEntity<Object> modificaBoat(@Valid @PathVariable("licence_plate") String licencePlate,
                                               @Valid @RequestBody BoatToModifyTo boatToModifyTO) {

        try {

            errors.checkInformations(licencePlate, boatToModifyTO);

        } catch (LicencePlateException e) {
            return new ResponseEntity<>(e.getErrorRTOList(), e.getHttpStatus());

        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(boatFacade.modificaBoat(licencePlate, boatToModifyTO), HttpStatus.OK);
    }

    @GetMapping(value = "/boat/boatAllList")
    public ResponseEntity<Object> getAllBoat() {
        List<String> boatRTOs;
        try {
            boatRTOs = boatFacade.getAllBoat();
        } catch (LicencePlateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        if (boatRTOs.isEmpty()) {
            return new ResponseEntity<>("Nessuna barca presente nel database", HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(boatRTOs,HttpStatus.OK);
        }

    }

}
