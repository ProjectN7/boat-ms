package com.Project_N7.boat_management.checkerrors;
import java.util.ArrayList;
import java.util.List;


import com.Project_N7.boat_management.entity.Boat;
import com.Project_N7.boat_management.exception.IdException;
import com.Project_N7.boat_management.exception.LicencePlateException;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.Project_N7.boat_management.service.TypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class CheckErrorsTypeTicket {
    @Autowired
    private TypeTicketService typeTicketService;

    public void checkIdList(List<Long> ids) throws IdException {

        List<ErrorRTO> errorRTO_list = new ArrayList<>();
        if (CollectionUtils.isEmpty(ids)) {
            errorRTO_list.add(new ErrorRTO("Non è stato inserito nessun id per la ricerca!"));
            throw new IdException(errorRTO_list, HttpStatus.NOT_FOUND); // Lancio subito poichè voglio che un
            // differente HttpStatus
        }

        List<ErrorRTO> errorRtoListClear = new ArrayList<>();
        for (ErrorRTO errorRtoTemp : errorRTO_list) {
            if (errorRtoTemp != null) {
                errorRtoListClear.add(errorRtoTemp);
            }
        }

        // Lancio dell'eccezione
        if (!errorRtoListClear.isEmpty()) {
            throw new IdException(errorRTO_list, HttpStatus.BAD_REQUEST);
        }
    }

    public ErrorRTO checkIfNull(Long id) {
        if (id == null) {
            return new ErrorRTO("null inserito nella lista");
        }
        return null;
    }

}