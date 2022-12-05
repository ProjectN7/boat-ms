package com.Project_N7.boat_management.to;

import com.Project_N7.boat_management.entity.Boat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ReservationTO {
    @NotBlank(message = "La targa non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{5}$", message = "La targa non può contenere caratteri speciali o non seguire la forma XX00000")
    private String licencePlate;

    @NotNull
    private Integer pier;

    @NotBlank(message = "La banchina non può essere nulla o vuota")
    @Pattern(regexp = "^[a-z A-Z]+[0-9]+$", message = "La banchina non può contenere caratteri speciali o numeri")
    private String quayside;



    private java.sql.Date dateTimeFrom;


    private java.sql.Date dateTimeTo;

    private boolean isActive;

    private Boat boat;

    public ReservationTO() { super(); }

    public ReservationTO(String licencePlate, Integer pier, String quayside, java.sql.Date dateTimeFrom, java.sql.Date dateTimeTo, boolean isActive, Boat boat) {
        this.licencePlate = licencePlate;
        this.pier = pier;
        this.quayside = quayside;
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
        this.isActive = isActive;
        this.boat = boat;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Integer getPier() {
        return pier;
    }

    public void setPier(Integer pier) {
        this.pier = pier;
    }

    public String getQuayside() {
        return quayside;
    }

    public void setQuayside(String quayside) {
        this.quayside = quayside;
    }

    public java.sql.Date getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(java.sql.Date dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public java.sql.Date getDateTimeTo() {
        return dateTimeTo;
    }

    public void setDateTimeTo(java.sql.Date dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    public boolean isActive() { return isActive; }

    public boolean setActive(boolean active) { return isActive = active; } //Da controllare

    public Boat getBoat() { return boat; }

    public void setBoat(Boat boat) { this.boat = boat; }
}
