package com.Project_N7.boat_management.facade;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.service.QuaysideService;
import com.Project_N7.boat_management.to.QuaysideTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

@Service
public class QuaysideFacade {

    @Autowired
    QuaysideService quaysideService;

    public List<String> getQuaysideById(Long pier) throws ErrorException {
        if (!quaysideService.idQuaysideExist(pier)) { // Prima chiamata al server per vedere se il
            // l'id esiste
            throw new ErrorException(QUAYSIDE_ID_NOT_FOUND); // Altrimenti lancio l'eccezione
        }
        // Se il numero è presente vado a cercarmi i moli che lo posseggono
        return quaysideService.getAllQuaysideByIdPier(pier);
    }

    public Object quaysideSave(QuaysideTO quaysideTO) {
        Long idQuayside = quaysideService.quaysideSave(quaysideTO);
        if (idQuayside != null) {
            String addOk = PIER_WITH_NAME + quaysideTO.getName() + ADDED_WITH_A;
            return addOk;
        }
        return QUAYSIDE_ERROR;
    }

    public List<Long> getAllQuayside() throws ErrorException { return quaysideService.getAllQuayside(); }

}