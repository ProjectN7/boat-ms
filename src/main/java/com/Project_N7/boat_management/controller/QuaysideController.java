package com.Project_N7.boat_management.controller;

import com.Project_N7.boat_management.checkerrors.CheckErrorsQuayside;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.facade.QuaysideFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class QuaysideController {

    @Autowired
    private QuaysideFacade quaysideFacade;

    @Autowired
    private CheckErrorsQuayside checkErrorsQuayside;

    @CrossOrigin
    @GetMapping(value = "/quayside/quaysideAllList")
    public ResponseEntity<Object> getQuaysideFromId(@RequestParam Long pier) {
        List<String> quaysideRTOs;
        try {
            quaysideRTOs = quaysideFacade.getQuaysideById(pier);
        } catch (IdException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

            return new ResponseEntity<>(quaysideRTOs,HttpStatus.OK);
        }

    }

