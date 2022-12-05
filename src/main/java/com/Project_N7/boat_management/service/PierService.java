package com.Project_N7.boat_management.service;

import com.Project_N7.boat_management.entity.Pier;
import com.Project_N7.boat_management.entity.Quayside;
import com.Project_N7.boat_management.repository.PierRepository;
import com.Project_N7.boat_management.rto.PierRTO;
import com.Project_N7.boat_management.rto.QuaysideRTO;
import com.Project_N7.boat_management.to.PierTO;
import com.Project_N7.boat_management.to.QuaysideTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PierService {

    @Autowired
    private PierRepository pierRepository;

    
    public PierRTO getPierById(Integer idPier) {

        // Chiamo il metodo trasferisciDaPersonaAPersonaRto per popolarla con i dati che
        // mi servono
        return populatePierRTO(pierRepository.getPierById(idPier));
    }

    private PierRTO populatePierRTO(Pier pier) {
        PierRTO pierRTOtemp = new PierRTO();

        // Popolamento tramite setter e getter
        pierRTOtemp.setIdPier(pier.getIdPier());
        pierRTOtemp.setName(pier.getName());
        pierRTOtemp.setCapacity(pier.getCapacity());
        return pierRTOtemp;
    }

    public boolean idPierExist(Integer idPier) { return (pierRepository.getPierById(idPier)!= null); }


    public Integer pierSave(PierTO pierTO) {
        Pier pierToSave = new Pier();
        pierToSave.setName(pierTO.getName());
        pierToSave.setCapacity(pierTO.getCapacity());

        return pierRepository.save(pierToSave).getIdPier();
    }

    private List<PierRTO> convertPierTOPierRTO(List<Pier> pierList) {

        // Creo la lista di PersonaRTO
        List<PierRTO> pierRTOList = new ArrayList<>();
        // Ciclo for per passare una ad una le persone dall'entità completa
        // all'oggetto custom RTO contenente solo le informazioni che vogliamo
        for (Pier pier : pierList) {

            // Creazione della PersonaRTO temporanea
            PierRTO pierRTOtemp = populatePierRTO(pier);

            // Inserimento della PersonaRTO temporanea in nella lista di personeRto
            pierRTOList.add(pierRTOtemp);
        }
        return pierRTOList;
    }

    public List<Long> getAllPier() { return pierRepository.getAllPier(); }

}
