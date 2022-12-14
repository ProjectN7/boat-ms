package com.Project_N7.boat_management.controller;

import com.Project_N7.boat_management.models.ServiceResponse;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@ControllerAdvice
public abstract class BaseController {

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> handleInvalidJson(JsonProcessingException ex) {
        return new ResponseEntity<>(new ServiceResponse(CODE_400, HttpStatus.BAD_REQUEST.name(), JSON_NOT_VALID_TITLE, JSON_NOT_VALID_MESSAGGIO), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorRTO> errorRtoList = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorRtoList.add(new ErrorRTO(fieldName, errorMessage));
        });
        return new ResponseEntity<>(new ServiceResponse(CODE_400, HttpStatus.BAD_REQUEST.name(), JSON_NOT_VALID_TITLE, JSON_NOT_VALID_MESSAGGIO, errorRtoList), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentTypeMismatchException ex) {
        List<ErrorRTO> errorRtoList = new ArrayList<>();
        String fieldName = ex.getName();
        String errorMessage = ex.getMessage();
        errorRtoList.add(new ErrorRTO(fieldName, errorMessage));
        return new ResponseEntity<>(new ServiceResponse(CODE_400, HttpStatus.BAD_REQUEST.name(), JSON_NOT_VALID_TITLE, JSON_NOT_VALID_MESSAGGIO, errorRtoList), HttpStatus.BAD_REQUEST);
    }

}