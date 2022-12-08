package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class TicketTO {

    @NotBlank(message = "La targa non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{5}$", message = "La targa non può contenere caratteri speciali o non seguire la forma XX00000")
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
