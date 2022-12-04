package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.entity.Boat;
import com.Project_N7.boat_management.entity.Reservation;
import com.Project_N7.boat_management.entity.Risposta;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.ReservationRTO;

import com.Project_N7.boat_management.service.QuaysideService;
import com.Project_N7.boat_management.service.ReservationService;
import com.Project_N7.boat_management.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ReservationFacade {

    @Autowired
    ReservationService reservationService;

    @Autowired
    QuaysideService quaysideService;

    public ReservationRTO getReservationById(Long idReservation) throws IdException {
        if (!reservationService.idReservationExist(idReservation)) { // Prima chiamata al server per vedere se il
            // l'id esiste
            throw new IdException("Id non presente"); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le prenotazioni che lo posseggono
        return reservationService.getReservationById(idReservation);
    }

    public ReservationRTO getReservationByLicencePlate(String licencePlate) throws LicencePlateException{
        if(!reservationService.reservationByLicencePlateExist(licencePlate)){
            throw new LicencePlateException("Targa non presente");
        }
        return reservationService.getReservationByLicencePlate(licencePlate);
    }

    public Object reservationSave(ReservationTO reservationTO) {
        Long idReservation = reservationService.reservationSave(reservationTO);
        Risposta risp = new Risposta();
        if (idReservation != null) {
            risp.setResponse("La prenotazione con l'id: " + idReservation + " è stata aggiunta");
            return risp;
        }
        risp.setResponse("La prenotazione non è stata inserita");
        return risp;
    }

    public List<Long> getAllReservation() throws IdException { return reservationService.getAllReservation(); }

    public String deleteReservationByLicencePlate(String licencePlate) {
        reservationService.deleteReservationByLicencePlate(licencePlate);
        return "è stata cancellata la prenotazione associata associata alla targa: " +licencePlate;
    }
}
