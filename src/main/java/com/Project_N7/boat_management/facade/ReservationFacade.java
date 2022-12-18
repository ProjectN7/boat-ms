package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.ReservationRTO;
import com.Project_N7.boat_management.service.QuaysideService;
import com.Project_N7.boat_management.service.ReservationService;
import com.Project_N7.boat_management.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class ReservationFacade {

    @Autowired
    ReservationService reservationService;

    @Autowired
    QuaysideService quaysideService;

    public ReservationRTO getReservationById(Long idReservation) throws ErrorException {
        if (!reservationService.idReservationExist(idReservation)) { // Prima chiamata al server per vedere se il
            // l'id esiste
            throw new ErrorException(RESERVATION_ID_NOT_FOUND); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le prenotazioni che lo posseggono
        return reservationService.getReservationById(idReservation);
    }

    public ReservationRTO getReservationByLicencePlate(String licencePlate) throws ErrorException{
        if(!reservationService.reservationByLicencePlateExist(licencePlate)){
            throw new ErrorException(LICENCE_PLATE_NOT_PRESENT);
        }
        return reservationService.getReservationByLicencePlate(licencePlate);
    }

    public Object reservationSave(ReservationTO reservationTO) {
        Long idReservation = reservationService.reservationSave(reservationTO);
        String resp = "";
        if (idReservation != null) {
            resp = RESERVATION_MADE;
        }else {
            resp = RESERVATION_NOT_MADE;
        }
        return resp;
    }

    public List<Long> getAllReservation() throws ErrorException { return reservationService.getAllReservation(); }

    public List<String> getAllLicencePlateActive() throws ErrorException { return reservationService.getAllLicencePlateActive(); }

    @Transactional
    public Object deleteReservationById (Long idReservation) {
        if (idReservation != null) {
            reservationService.deleteReservationById(idReservation);
            return RESERVATION_CANCELLED;
        }
        return RESERVATION_NOT_CANCELLED;
    }
}
