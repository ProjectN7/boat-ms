package com.Project_N7.boat_management.checkerrors;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.Project_N7.boat_management.service.ReservationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class CheckErrorsReservation {
    @Autowired
    private ReservationService reservationService;

    public void checkIfReservationExistForLicencePlate(String licencePlate) throws ErrorException {
       ErrorRTO error = new ErrorRTO();
        if (reservationService.reservationByLicencePlateExist(licencePlate)) {
            error.setMessage(RESERVATION_ALREADY_PRESENT);
        }
        if (StringUtils.isNotBlank(error.getMessage())) {
            throw new ErrorException(error.getMessage());
        }
    }
    public void checkReservationByLicencePlateExist(String licencePlate) throws ErrorException {
        if (!reservationService.reservationByLicencePlateExist(licencePlate)) {
            throw new ErrorException(RESERVATION_WITH_LICENCE_PLATE + licencePlate + NOT_PRESENT);
        }
    }

    public void checkExistId(Long idReservation) throws ErrorException {
        if (!reservationService.idReservationExist(idReservation)) {
            throw new ErrorException(TICKET_WITH_ID + idReservation + NOT_PRESENT);
        }
    }
}
