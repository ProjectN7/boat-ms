package com.Project_N7.boat_management.service;

import com.Project_N7.boat_management.entity.Boat;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.repository.BoatRepository;
import com.Project_N7.boat_management.rto.BoatCompletaRTO;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BoatService {

    @Autowired
    private BoatRepository boatRepository;

    public BoatRTO getBoatByLicencePlate(String licence_plate) {

        // Chiamo il metodo trasferisciDaPersonaAPersonaRto per popolarla con i dati che
        // mi servono
        return populateBoatRTO(boatRepository.getBoatByLicencePlate(licence_plate));
    }

    public boolean licencePlateExist(String licence_plate) { return (boatRepository.getBoatByLicencePlate(licence_plate) != null); }

    public String boatSave(BoatTO boatTO) {
        Boat boat_to_save = new Boat();
        boat_to_save.setLicencePlate(boatTO.getLicencePlate());
        boat_to_save.setCf(boatTO.getCf());
        boat_to_save.setName(boatTO.getName());
        boat_to_save.setColour(boatTO.getColour());
        boat_to_save.setNavigationLicence(boatTO.getNavigationLicence());
        boat_to_save.setPower(boatTO.getPower());
        boat_to_save.setDeclarationOfConformity(boatTO.getDeclarationOfConformity());
        boat_to_save.setRca(boatTO.getRca());
        return boatRepository.save(boat_to_save).getLicencePlate();
    }

    private List<BoatRTO> convertBoatTOBoatRTO(List<Boat> boatList) {

        // Creo la lista di PersonaRTO
        List<BoatRTO> boatRTOList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (Boat boat : boatList) {

            // Creazione della PersonaRTO temporanea
            BoatRTO boatRTOTemp = populateBoatRTO(boat);

            // Inserimento della PersonaRTO temporanea in nella lista di personeRto
            boatRTOList.add(boatRTOTemp);
        }
        return boatRTOList;
    }

    private BoatRTO populateBoatRTO(Boat boat) {
        BoatRTO boatRTOTemp = new BoatRTO();

        // Popolamento tramite setter e getter
        boatRTOTemp.setLicencePlate(boat.getLicencePlate());
        boatRTOTemp.setCf(boat.getCf());
        boatRTOTemp.setName(boat.getName());
        boatRTOTemp.setColor(boat.getColour());
        boatRTOTemp.setNavigationLicence(boat.getNavigationLicence());
        boatRTOTemp.setPower(boat.getPower());
        boatRTOTemp.setDeclarationOfConformity(boat.getDeclarationOfConformity());
        boatRTOTemp.setRca(boat.getRca());
        return boatRTOTemp;
    }

    public BoatCompletaRTO modificaBoat(String licencePlate, BoatToModifyTo personaToModifyTO) {
        Boat boatTemp = boatRepository.getById(licencePlate);
        cambiaNotNull(boatTemp, personaToModifyTO);
        return convertBoatToBoatCompletaRTO(boatRepository.save(boatTemp));

    }
    public void cambiaNotNull(Boat boatTemp, BoatToModifyTo boatToModifyTO) {

        boatTemp.setName(boatToModifyTO.getName() != null ? boatToModifyTO.getName() : boatTemp.getName());
        boatTemp.setColour(
                boatToModifyTO.getColour() != null ? boatToModifyTO.getColour() : boatTemp.getColour());
        boatTemp
                .setNavigationLicence(boatToModifyTO.getNavigationLicence() != null ? boatToModifyTO.getNavigationLicence() :
                        boatTemp.getNavigationLicence());
        boatTemp.setPower(boatToModifyTO.getPower() != null ? boatToModifyTO.getPower()
                : boatTemp.getPower());
        boatTemp
                .setDeclarationOfConformity(boatToModifyTO.getDeclarationOfConformity() != null ? boatToModifyTO.getDeclarationOfConformity() :
                        boatTemp.getDeclarationOfConformity());
        boatTemp.setRca(boatToModifyTO.getRca() != null ? boatToModifyTO.getRca()
                : boatTemp.getRca());
    }
    private BoatCompletaRTO convertBoatToBoatCompletaRTO(Boat boat) {
        BoatCompletaRTO boatCompletaRtoTemp = new BoatCompletaRTO();

        // Popolamento tramite setter e getter
        boatCompletaRtoTemp.setLicencePlate(boat.getLicencePlate());
        boatCompletaRtoTemp.setCf(boat.getCf());
        boatCompletaRtoTemp.setName(boat.getName());
        boatCompletaRtoTemp.setColor(boat.getColour());
        boatCompletaRtoTemp.setNavigationLicence(boat.getNavigationLicence());
        boatCompletaRtoTemp.setPower(boat.getPower());
        boatCompletaRtoTemp.setDeclarationOfConformity(boat.getDeclarationOfConformity());
        boatCompletaRtoTemp.setRca(boat.getRca());
        return boatCompletaRtoTemp;
    }

    public List<String> getAllBoat() { return boatRepository.getAllBoat(); }

    public void boatDelete(String licencePlate) { boatRepository.boatDelete(licencePlate); }

    public List<String> getLicencePlateByCf(String cf) throws ErrorException { return boatRepository.getLicencePlateByCf(cf); }

}
