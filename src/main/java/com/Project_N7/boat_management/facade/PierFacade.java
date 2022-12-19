package com.Project_N7.boat_management.facade;


import com.Project_N7.boat_management.entity.Pier;
import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.PierRTO;
import com.Project_N7.boat_management.service.PierService;
import com.Project_N7.boat_management.to.PierTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class PierFacade {

    @Autowired
    PierService pierService;

    public PierRTO getPierById(Integer idPier) throws ErrorException {
        if (!pierService.idPierExist(idPier)) { // Prima chiamata al server per vedere se il
            // l'id esiste
            throw new ErrorException(PIER_ID_NOT_FOUND); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi i moli che lo posseggono
        return pierService.getPierById(idPier);
    }
    

    public Object pierSave(PierTO pierTO) {
        Integer idPier = pierService.pierSave(pierTO);
        if (idPier != null) {
            String addOk = PIER_WITH_NAME + pierTO.getName() + ADDED_WITH_O;
            return addOk;
        }
        return PIER_ERROR;
    }

    public List<Pier> getAllPier() throws ErrorException { return pierService.getAllPier(); }

}
