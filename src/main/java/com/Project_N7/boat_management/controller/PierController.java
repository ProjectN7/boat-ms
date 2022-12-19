package com.Project_N7.boat_management.controller;

import com.Project_N7.boat_management.checkerrors.CheckErrorsBoat;
import com.Project_N7.boat_management.entity.Pier;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.facade.PierFacade;
import com.Project_N7.boat_management.models.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;


@RestController
@CrossOrigin(origins = "*")
public class PierController {

    @Autowired
    private PierFacade pierFacade;

    @Autowired
    private CheckErrorsBoat errors;

    @CrossOrigin
    @GetMapping(value = "/pier/pierAllList")
    public ResponseEntity<Object> getAllPier() {
        List<Long> pierRTOs;
        try {
            pierRTOs = pierFacade.getAllPier();
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_500, HttpStatus.INTERNAL_SERVER_ERROR.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (pierRTOs.isEmpty()) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, PIER_NOT_FOUND, PIER_NOT_FOUND), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), PIER_FOUND, PIER_FOUND, pierRTOs), HttpStatus.OK);
        }

    }


}
