package com.Project_N7.boat_management.facade;
import com.Project_N7.boat_management.entity.Risposta;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.BoatCompletaRTO;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.service.BoatService;

import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatFacade {
    @Autowired
    BoatService boatService;

    public BoatRTO getBoatByLicencePlate(String licencePlate) throws LicencePlateException {
        if (!boatService.licencePlateExist(licencePlate)) { // Prima chiamata al server per vedere se il
            // la targa esiste
            throw new LicencePlateException("targa non presente"); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le persone che lo posseggono
        return boatService.getBoatByLicencePlate(licencePlate);
    }

    public Object boatSave(BoatTO boatTO) {
        String licencePlate = boatService.boatSave(boatTO);
        Risposta risp = new Risposta();
        if (licencePlate != null) {
            risp.setResponse("La barca con la targa: " + licencePlate + " è stata aggiunta");
            return risp;
        }
        risp.setResponse("La barca non è stata inserita");
        return risp;
    }

    public BoatCompletaRTO modificaBoat(String licencePlate, BoatToModifyTo boatToModifyTO) {
        return boatService.modificaBoat(licencePlate, boatToModifyTO);
    }

    public List<String> getAllBoat() throws LicencePlateException { return boatService.getAllBoat(); }


}