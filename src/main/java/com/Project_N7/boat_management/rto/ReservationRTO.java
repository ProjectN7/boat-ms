package com.Project_N7.boat_management.rto;

import com.Project_N7.boat_management.entity.Boat;

import java.sql.Date;

public class ReservationRTO {

    private Long IdReservation;
    private Boat boat;
    private String pier;
    private String quayside;
    private java.sql.Date dateTimeFrom;
    private java.sql.Date dateTimeTo;
    private boolean isActive;

    public ReservationRTO() { super(); }

    public ReservationRTO(Long idReservation, Boat boat, String pier, String quayside, Date dateTimeFrom, Date dateTimeTo, boolean isActive) {
        IdReservation = idReservation;
        this.boat = boat;
        this.pier = pier;
        this.quayside = quayside;
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
        this.isActive = isActive;
    }

    public Long getIdReservation() {
        return IdReservation;
    }

    public void setIdReservation(Long idReservation) {
        IdReservation = idReservation;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
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

    public Date getDateTimeFrom() {
        return dateTimeFrom;
    }

    public void setDateTimeFrom(Date dateTimeFrom) {
        this.dateTimeFrom = dateTimeFrom;
    }

    public Date getDateTimeTo() {
        return dateTimeTo;
    }

    public void setDateTimeTo(Date dateTimeTo) {
        this.dateTimeTo = dateTimeTo;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String toString() {
        return " \"Plate\": \"" + boat.getLicencePlate() + "\",\n \"Id Prenotazione\": \"" + IdReservation + "\",\n \"Molo\": \"" + pier
                + ",\"\n \"Banchina\": \"" + quayside + "\",\n \"Data partenza prenotazione\": \"" + dateTimeFrom
                + "\", \n \"Data fine prenotazione\": \"" + dateTimeTo + "\", \n \"è attiva?\": \"" + isActive
                + "\",";
    }
}
