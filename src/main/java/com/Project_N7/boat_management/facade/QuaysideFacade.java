package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.entity.Risposta;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.BoatCompletaRTO;
import com.Project_N7.boat_management.rto.BoatRTO;
import com.Project_N7.boat_management.rto.PierRTO;
import com.Project_N7.boat_management.rto.QuaysideRTO;
import com.Project_N7.boat_management.service.BoatService;

import com.Project_N7.boat_management.service.PierService;
import com.Project_N7.boat_management.service.QuaysideService;
import com.Project_N7.boat_management.to.BoatTO;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import com.Project_N7.boat_management.to.PierTO;
import com.Project_N7.boat_management.to.QuaysideTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuaysideFacade {

    @Autowired
    QuaysideService quaysideService;

    public List<String> getQuaysideById(Long pier) throws IdException {
        if (!quaysideService.idQuaysideExist(pier)) { // Prima chiamata al server per vedere se il
            // l'id esiste
            throw new IdException("Id non presente"); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi i moli che lo posseggono
        return quaysideService.getAllQuaysideByIdPier(pier);
    }

    public Object quaysideSave(QuaysideTO quaysideTO) {
        Long idQuayside = quaysideService.quaysideSave(quaysideTO);
        Risposta risp = new Risposta();
        if (idQuayside != null) {
            risp.setResponse("La banchina con il nome: " + quaysideTO.getName() + " è stata aggiunta");
            return risp;
        }
        risp.setResponse("La banchina non è stata inserita");
        return risp;
    }

    public List<Long> getAllQuayside() throws IdException { return quaysideService.getAllQuayside(); }

}