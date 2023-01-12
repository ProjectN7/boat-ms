package com.Project_N7.boat_management.checkerrors;

import com.Project_N7.boat_management.exception.ErrorException;
import com.Project_N7.boat_management.rto.ErrorRTO;
import com.Project_N7.boat_management.service.BoatService;
import com.Project_N7.boat_management.to.BoatToModifyTo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.Project_N7.boat_management.constants.Constants.*;

//@Component
@Service
public class CheckErrorsBoat {

    @Autowired
    private BoatService boatService;

    public void checkExistLicencePlate(String licence_plate) throws ErrorException {
        ErrorRTO error = new ErrorRTO();
        if (boatService.licencePlateExist(licence_plate)) {
            error.setMessage(LICENCE_PLATE_ALREADY_PRESENT);
        }
        if (StringUtils.isNotBlank(error.getMessage())) {
            throw new ErrorException(error.getMessage());
        }
    }
    public void checkInformations(String licence_plate, BoatToModifyTo boatToModifyTO) throws ErrorException {

        checkLicencePlateExist(licence_plate);
        List<ErrorRTO> errorRtoList = new ArrayList<>();

        if (boatToModifyTO.getName() == null) {
            errorRtoList.add(new ErrorRTO("Name", "Campo non valido"));
        }

        if (boatToModifyTO.getColour() == null) {
            errorRtoList.add(new ErrorRTO("Colour", "Campo non valido"));
        }

        if (boatToModifyTO.getNavigationLicence() == null && !boatToModifyTO.getNavigationLicence().matches("^[A-Z]{2}-[0-9]{4}$")) {
            errorRtoList.add(new ErrorRTO("Navigation Licence", "Campo non valido"));
        }

        if (boatToModifyTO.getPower() == null && !boatToModifyTO.getPower().matches("^[0-9]{3}$")) {
            errorRtoList.add(new ErrorRTO("Power", "Campo non valido"));
        }

        if (boatToModifyTO.getDeclarationOfConformity() == null
                && !boatToModifyTO.getDeclarationOfConformity().matches("^[A-Z]{6}-[0-9]{3}$")) {
            errorRtoList.add(new ErrorRTO("Declaration of conformity", "Campo non valido"));
        }

        if (boatToModifyTO.getRca() == null
                && !boatToModifyTO.getRca().matches("^[A-Z]{2}-[0-9]{3}$")) {
            errorRtoList.add(new ErrorRTO("RCA", "Campo non valido"));
        }

    }

    public void checkLicencePlateExist(String licence_plate) throws ErrorException {
        if (!boatService.licencePlateExist(licence_plate)) {
            throw new ErrorException(LICENCE_PLATE + licence_plate + NOT_PRESENT);
        }
    }
}