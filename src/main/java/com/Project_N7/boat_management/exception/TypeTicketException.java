package com.Project_N7.boat_management.exception;

import com.Project_N7.boat_management.rto.ErrorRTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public class TypeTicketException extends Exception {


    private static final long serialVersionUID = 1L;

    private HttpStatus httpStatus;

    private List<ErrorRTO> errorRTOList;

    public TypeTicketException() { super(); }

    public TypeTicketException(List<ErrorRTO> errorRTOList, HttpStatus httpStatus) {
        super();
        this.errorRTOList = errorRTOList;
        this.httpStatus = httpStatus;
    }

    public TypeTicketException(String message) {
        super(message);
    }

    public TypeTicketException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<ErrorRTO> getErrorRTOList() {
        return errorRTOList;
    }

    public void setErrorRTOList(List<ErrorRTO> errorRTOList) {
        this.errorRTOList = errorRTOList;
    }
}