package com.Project_N7.boat_management.entity;

import javax.persistence.*;

@Entity
@Table(name="Pier")
public class Pier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPier")
    private Long IdPier;

    @Column(name = "name")
    private String name;

    @Column(name = "Capacity")
    private int capacity;

    public Pier() { super(); }

    public Long getIdPier() { return IdPier; }

    public void setIdPier(Long idPier) { IdPier = idPier; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }
}
