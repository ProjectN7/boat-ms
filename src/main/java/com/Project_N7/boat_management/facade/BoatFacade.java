package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.service.BoatService;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class BoatFacade {
    @Autowired
    BoatService boatService;


    public BoatRTO getBoatByLicencePlate(String licencePlate) throws ErrorException {
        if (!boatService.licencePlateExist(licencePlate)) { // Prima chiamata al server per vedere se il
            // la targa esiste
            throw new ErrorException(LICENCE_PLATE_NOT_PRESENT); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi le persone che lo posseggono
        return boatService.getBoatByLicencePlate(licencePlate);
    }

    public Object boatSave(BoatTO boatTO) {
        String licencePlate = boatService.boatSave(boatTO);
        if (licencePlate != null) {

            return REGISTRATION_MADE;
        }
        return REGISTRATION_ERROR;
    }
    public Object modificaBoat(String licencePlate, BoatToModifyTo boatToModifyTO) {
        boatService.modificaBoat(licencePlate, boatToModifyTO);
        return CHANGE_MADE;
    }

    public List<String> getAllBoat() throws ErrorException { return boatService.getAllBoat(); }

    public void boatDelete(String licencePlate) {  boatService.boatDelete(licencePlate); }


    public List<String> getLicencePlateByCf(String cf) throws ErrorException { return boatService.getLicencePlateByCf(cf); }






}