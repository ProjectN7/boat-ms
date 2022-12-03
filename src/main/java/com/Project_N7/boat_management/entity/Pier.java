package com.Project_N7.boat_management.entity;

import javax.persistence.*;

@Entity
@Table(name="pier")
public class Pier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PIER")
    private Integer idPier;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY")
    private int capacity;

    public Pier() { super(); }

    public Integer getIdPier() { return idPier; }

    public void setIdPier(Integer idPier) { idPier = idPier; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }
}
