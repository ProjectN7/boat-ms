package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

import static com.Project_N7.boat_management.constants.Constants.LICENCE_PLATE_CANNOT_BE_EMPTY;
import static com.Project_N7.boat_management.constants.Constants.LICENCE_PLATE_INFO;

public class TicketTO {

    @NotBlank(message = LICENCE_PLATE_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{5}$", message = LICENCE_PLATE_INFO)
    private String licencePlate;

    @NotNull
    private java.sql.Date date;

    @NotNull
    private Integer idTypeTicket;

    @NotNull
    private String description;

    private Integer isActive;


    public TicketTO() { super(); }

    public TicketTO(String licencePlate, Date date, Integer idTypeTicket, String description, Integer isActive) {
        this.licencePlate = licencePlate;
        this.date = date;
        this.idTypeTicket = idTypeTicket;
        this.description = description;
        this.isActive = isActive;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdTypeTicket() {
        return idTypeTicket;
    }

    public void setIdTypeTicket(Integer idTypeTicket) {
        this.idTypeTicket = idTypeTicket;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }
}
