package com.Project_N7.boat_management.service;

import com.Project_N7.boat_management.entity.Boat;
import com.Project_N7.boat_management.entity.Reservation;
import com.Project_N7.boat_management.repository.ReservationRepository;
import com.Project_N7.boat_management.rto.ReservationRTO;
import com.Project_N7.boat_management.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public ReservationRTO getReservationById(Long idReservation) {

        // Chiamo il metodo trasferisciDaPersonaAPersonaRto per popolarla con i dati che
        // mi servono
        return populateReservationRTO(reservationRepository.getReservationByIds(idReservation));
    }

    private ReservationRTO populateReservationRTO(Reservation reservation) {
        ReservationRTO reservationRTOtemp = new ReservationRTO();

        // Popolamento tramite setter e getter
        reservationRTOtemp.setIdReservation(reservation.getIdReservation());
        reservationRTOtemp.setLicencePlate(reservation.getLicencePlate());
        reservationRTOtemp.setPier(reservation.getPier());
        reservationRTOtemp.setQuayside(reservation.getQuayside());
        reservationRTOtemp.setDateTimeFrom(reservation.getDateTimeFrom());
        reservationRTOtemp.setDateTimeTo(reservation.getDateTimeTo());
        reservationRTOtemp.setActive(reservationRTOtemp.isActive());
        return reservationRTOtemp;
    }

    public boolean idReservationExist(Long idReservation) { return (reservationRepository.getReservationByIds(idReservation)!= null); }

    //Da vedere
    public boolean ReservationExistByLicencePlate(Reservation reservation) { return (reservationRepository.getReservationByLicencePlate(reservation.getLicencePlate())!=null);}

    public Long reservationSave(ReservationTO reservationTO) {
        Reservation reservationToSave = new Reservation();
        reservationToSave.setLicencePlate(reservationTO.getLicencePlate());
        reservationToSave.setPier(reservationTO.getPier());
        reservationToSave.setQuayside(reservationTO.getQuayside());
        reservationToSave.setDateTimeFrom(reservationTO.getDateTimeFrom());
        reservationToSave.setDateTimeTo(reservationTO.getDateTimeTo());
        reservationToSave.setActive(1);
        return reservationRepository.save(reservationToSave).getIdReservation();
    }

    private List<ReservationRTO> convertReservationTOReservationRTO(List<Reservation> reservationList) {

        // Creo la lista di PersonaRTO
        List<ReservationRTO> reservationRTOList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (Reservation reservation : reservationList) {

            // Creazione della PersonaRTO temporanea
            ReservationRTO reservationRTOtemp = populateReservationRTO(reservation);

            // Inserimento della PersonaRTO temporanea in nella lista di personeRto
            reservationRTOList.add(reservationRTOtemp);
        }
        return reservationRTOList;
    }

    public List<Long> getAllReservation() { return reservationRepository.getAllReservation(); }

    public void deleteReservationById(Long idReservation) {
        reservationRepository.deleteById(idReservation);
    }

    public ReservationRTO getReservationByLicencePlate(String licencePlate) { return populateReservationRTO(reservationRepository.getReservationByLicencePlate(licencePlate)); }

    public void deleteReservationByLicencePlate(String licencePlate) { reservationRepository.deleteReservationByLicencePlate(licencePlate); }

    public boolean reservationByLicencePlateExist(String licencePlate) { return (reservationRepository.getReservationByLicencePlate(licencePlate) !=null); }
}
