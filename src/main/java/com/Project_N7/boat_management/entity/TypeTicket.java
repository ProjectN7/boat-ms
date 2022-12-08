package com.Project_N7.boat_management.entity;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name="typeTicket")
public class TypeTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTypeTicket")
    private Integer idTypeTicket;


    @Column(name = "description")
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