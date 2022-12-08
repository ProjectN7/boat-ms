package com.Project_N7.boat_management.facade;
import com.Project_N7.boat_management.entity.Risposta;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.BoatCompletaRTO;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.service.BoatService;
import com.Project_N7.boat_management.service.PierService;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatFacade {
    @Autowired
    BoatService boatService;

    Risposta risp = new Risposta();

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
        if (licencePlate != null) {
            risp.setResponse("Registrazione effettuata con Successo");
            return risp;
        }
        return "";
    }
    public Object modificaBoat(String licencePlate, BoatToModifyTo boatToModifyTO) {
        boatService.modificaBoat(licencePlate, boatToModifyTO);
        risp.setResponse("Modifica effettuata con successo");
        return risp;
    }

    public List<String> getAllBoat() throws LicencePlateException { return boatService.getAllBoat(); }




}