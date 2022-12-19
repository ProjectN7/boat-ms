package com.Project_N7.boat_management.controller;

import com.Project_N7.boat_management.checkerrors.CheckErrorsBoat;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.facade.BoatFacade;
import com.Project_N7.boat_management.models.ServiceResponse;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@RestController
@CrossOrigin(origins = "*")
public class BoatController {

    @Autowired
    private BoatFacade boatFacade;

    @Autowired
    private CheckErrorsBoat errors;

    @CrossOrigin
    @GetMapping(value = "/boat/boatList")
    public ResponseEntity<Object> getBoatFromLicencePlate(@RequestParam String licencePlate) {
        BoatRTO boatRTOs;
        try {
            boatRTOs = boatFacade.getBoatByLicencePlate(licencePlate);
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), BOAT_FOUND, BOAT_FOUND, boatRTOs), HttpStatus.OK);
        }
    @CrossOrigin
    @PostMapping(value = "/boat/boatSave")
    public ResponseEntity<Object> boatSave(@Valid @RequestBody BoatTO boatTO){
        try {
            errors.checkExistLicencePlate(boatTO.getLicencePlate());
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_409, HttpStatus.CONFLICT.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), REGISTRATION_MADE, REGISTRATION_MADE, boatFacade.boatSave(boatTO)), HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(path = "/modificaBoat/{licencePlate}")
    public ResponseEntity<Object> modificaBoat(@Valid @PathVariable("licencePlate") String licencePlate,
                                               @Valid @RequestBody BoatToModifyTo boatToModifyTO) {
        try {

            errors.checkInformations(licencePlate, boatToModifyTO);

        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_400, HttpStatus.BAD_REQUEST.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_500, HttpStatus.INTERNAL_SERVER_ERROR.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), BOAT_FOUND, BOAT_FOUND, boatFacade.modificaBoat(licencePlate, boatToModifyTO)), HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping(value = "/boat/boatAllList")
    public ResponseEntity<Object> getAllBoat() {
        List<String> boatRTOs;
        try {
            boatRTOs = boatFacade.getAllBoat();
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_500, HttpStatus.INTERNAL_SERVER_ERROR.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (boatRTOs.isEmpty()) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, BOAT_NOT_FOUND, BOAT_NOT_FOUND), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), BOAT_FOUND, BOAT_FOUND, boatRTOs), HttpStatus.OK);
        }

    }

}
