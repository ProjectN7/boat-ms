package com.Project_N7.boat_management.rto;


import java.sql.Date;

public class TicketRTO {

    private Long idTicket;

    private String licencePlate;

    private java.sql.Date date;

    private Integer idTypeTicket;

    private String description;

    private Integer isActive;

    public TicketRTO() { super(); }

    public TicketRTO(Long idTicket, String licencePlate, Date date,
                     Integer idTypeTicket, String description) {
        this.idTicket = idTicket;
        this.licencePlate = licencePlate;
        this.date = date;
        this.idTypeTicket = idTypeTicket;
        this.description = description;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String toString() {
        return " \"id Ticket\": \"" + idTicket + "\",\n \"Targa\": \"" + licencePlate + "\",\n \"Data\": \"" + date
                + ",\"\n \"Id Tipo Ticket\": \"" + idTypeTicket + "\",\n \"Descrizione\": \"" + description + "\", \n \"è attivo?\": \"" + isActive
                + "\",";
    }
}
