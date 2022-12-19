package com.Project_N7.boat_management.service;

import com.Project_N7.boat_management.entity.Quayside;
import com.Project_N7.boat_management.repository.QuaysideRepository;
import com.Project_N7.boat_management.rto.QuaysideRTO;
import com.Project_N7.boat_management.to.QuaysideTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuaysideService {

    @Autowired
    private QuaysideRepository quaysideRepository;


    private QuaysideRTO populateQuaysideRTO(Quayside quayside) {
        QuaysideRTO quaysideRTOtemp = new QuaysideRTO();

        // Popolamento tramite setter e getter
        quaysideRTOtemp.setIdQuayside(quayside.getIdQuayside());
        quaysideRTOtemp.setName(quayside.getName());
        return quaysideRTOtemp;
    }



    public boolean idQuaysideExist(Long pier) { return (quaysideRepository.getQuaysideById(pier)!= null); }

    public Long quaysideSave(QuaysideTO quaysideTO) {
        Quayside quaysideToSave = new Quayside();
        quaysideToSave.setName(quaysideTO.getName());

        return quaysideRepository.save(quaysideToSave).getIdQuayside();
    }

    private List<QuaysideRTO> convertQuaysideTOQuaysideRTO(List<Quayside> quaysideList) {

        // Creo la lista di PersonaRTO
        List<QuaysideRTO> quaysideRTOList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (Quayside quayside : quaysideList) {

            // Creazione della PersonaRTO temporanea
            QuaysideRTO quaysideRTOtemp = populateQuaysideRTO(quayside);

            // Inserimento della PersonaRTO temporanea in nella lista di personeRto
            quaysideRTOList.add(quaysideRTOtemp);
        }
        return quaysideRTOList;
    }

    public List<Long> getAllQuayside() { return quaysideRepository.getAllQuayside(); }

    public List<String> getAllQuaysideByIdPier(Long pier) { return quaysideRepository.getQuaysideById(pier); }


}

