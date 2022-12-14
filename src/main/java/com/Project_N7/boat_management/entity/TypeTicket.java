package com.Project_N7.boat_management.entity;

import javax.persistence.*;
@Entity
@Table(name="typeticket")
public class TypeTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TYPETICKET")
    private Integer idTypeTicket;


    @Column(name = "DESCRIPTION")
    private String description;

    public TypeTicket() { super();
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