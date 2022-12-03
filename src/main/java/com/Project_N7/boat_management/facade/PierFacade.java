package com.Project_N7.boat_management.facade;


import com.Project_N7.boat_management.entity.Risposta;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.rto.PierRTO;
import com.Project_N7.boat_management.service.PierService;
import com.Project_N7.boat_management.to.PierTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PierFacade {

    @Autowired
    PierService pierService;

    public PierRTO getPierById(Integer idPier) throws IdException {
        if (!pierService.idPierExist(idPier)) { // Prima chiamata al server per vedere se il
            // l'id esiste
            throw new IdException("Id non presente"); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi i moli che lo posseggono
        return pierService.getPierById(idPier);
    }
    

    public Object pierSave(PierTO pierTO) {
        Integer idPier = pierService.pierSave(pierTO);
        Risposta risp = new Risposta();
        if (idPier != null) {
            risp.setResponse("Il molo con il nome: " + pierTO.getName() + " è stato aggiunto");
            return risp;
        }
        risp.setResponse("Il molo non è stato inserito");
        return risp;
    }

    public List<String> getAllPier() throws IdException { return pierService.getAllPier(); }

}
