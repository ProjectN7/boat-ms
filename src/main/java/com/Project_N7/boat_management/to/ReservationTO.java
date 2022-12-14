package com.Project_N7.boat_management.to;

import com.Project_N7.boat_management.entity.Boat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static com.Project_N7.boat_management.constants.Constants.*;

public class ReservationTO {
    @NotBlank(message = LICENCE_PLATE_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{5}$", message = LICENCE_PLATE_INFO)
    private String licencePlate;

    @NotNull
    private String pier;

    @NotBlank(message = QUAYSIDE_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[a-z A-Z]+[0-9]+$", message = QUAYSIDE_INFO)
    private String quayside;



    private java.sql.Date dateTimeFrom;


    private java.sql.Date dateTimeTo;

    private int isActive;

    private Boat boat;

    public ReservationTO() { super(); }

    public ReservationTO(String licencePlate, String pier, String quayside, java.sql.Date dateTimeFrom, java.sql.Date dateTimeTo, Byte isActive, Boat boat) {
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

    public String getPier() {
        return pier;
    }

    public void setPier(String pier) {
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

    public int  isActive() { return isActive; }

    public void setActive(int active) { isActive = active; } //Da controllare

    public Boat getBoat() { return boat; }

    public void setBoat(Boat boat) { this.boat = boat; }
}
