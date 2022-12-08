package com.Project_N7.boat_management.rto;

public class TypeTicketRTO {

    private Integer idTypeTicket;

    private String description;

    public TypeTicketRTO() { super(); }

    public TypeTicketRTO(Integer idTypeTicket, String description) {
        this.idTypeTicket = idTypeTicket;
        this.description = description;
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

    public String toString() {
        return " \"Id tipo di ticket\": \"" + idTypeTicket + "\",\n \"Descrizione\": \"" + description + "\",";
    }
}
