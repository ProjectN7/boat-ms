package com.Project_N7.boat_management.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdReservation")
    private Long idReservation;


    @Column(name = "licencePlate")
    private String licencePlate;

    @Column(name = "pier")
    private String pier;

    @Column(name = "quayside")
    private String quayside;

    @Column(name = "datetime_from")
    private java.sql.Date dateTimeFrom;

    @Column(name = "datetime_to")
    private java.sql.Date dateTimeTo;

    @Column(name = "is_active")
    private boolean isActive;

    public Reservation() { super(); }

    public Long getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Long idReservation) {
        this.idReservation = idReservation;
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

}
