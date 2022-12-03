package com.Project_N7.boat_management.controller;

import java.util.List;

import com.Project_N7.boat_management.checkerrors.CheckErrorsBoat;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.facade.PierFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


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
        List<String> pierRTOs;
        try {
            pierRTOs = pierFacade.getAllPier();
        } catch (IdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        if (pierRTOs.isEmpty()) {
            return new ResponseEntity<>("Nessun molo presente nel database", HttpStatus.NOT_FOUND);
        } else {

            return new ResponseEntity<>(pierRTOs,HttpStatus.OK);
        }

    }


}
