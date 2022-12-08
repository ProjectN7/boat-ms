package com.Project_N7.boat_management.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "iDTicket")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    @Column(name = "licencePlate")
    private String licencePlate;

    @Column(name = "date")
    private java.sql.Date date;

    @Column(name = "idTypeTicket")
    private Integer idTypeTicket;

    @Column (name = "Description")
    private String description;

    @Column (name = "isActive")
    private Integer isActive;

    public Ticket() { super(); }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
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
}
