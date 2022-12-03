package com.Project_N7.boat_management.controller;


import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.facade.QuaysideFacade;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class QuaysideController {

    @Autowired
    private QuaysideFacade quaysideFacade;

    /*@Autowired
    private Check

    @CrossOrigin
    @GetMapping(value = "/pier/pierAllList")
    public ResponseEntity<Object> getQuaysideFromI() {
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

     */

}

