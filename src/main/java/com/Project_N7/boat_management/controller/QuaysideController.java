package com.Project_N7.boat_management.controller;

import com.Project_N7.boat_management.checkerrors.CheckErrorsQuayside;
import com.Project_N7.boat_management.entity.Quayside;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.facade.QuaysideFacade;
import com.Project_N7.boat_management.models.ServiceResponse;
import com.Project_N7.boat_management.rto.QuaysideRTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

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
        } catch (ErrorException e) {
            return new ResponseEntity<>(new ServiceResponse(CODE_500, HttpStatus.INTERNAL_SERVER_ERROR.name(), EXCEPTION, e.getMessage(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (quaysideRTOs.isEmpty()) {
            return new ResponseEntity<>(new ServiceResponse(CODE_404, HttpStatus.NOT_FOUND.name(), EXCEPTION, QUAYSIDE_NOT_FOUND, QUAYSIDE_NOT_FOUND), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ServiceResponse(CODE_200, HttpStatus.OK.name(), QUAYSIDE_FOUND, QUAYSIDE_FOUND, quaysideRTOs), HttpStatus.OK);
        }
    }

}