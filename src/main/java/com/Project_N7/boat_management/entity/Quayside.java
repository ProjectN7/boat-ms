package com.Project_N7.boat_management.entity;

import javax.persistence.*;

@Entity
@Table(name="quayside")
public class Quayside {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDQuayside")
    private Long idQuayside;

    @ManyToOne
    @JoinColumn(name = "Id_Pier", nullable = false)
    private Pier pier;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private boolean isActive;

    public Quayside() {
        super();
    }

    public Long getIdQuayside() {
        return idQuayside;
    }

    public void setIdQuayside(Long idQuayside) {
        this.idQuayside = idQuayside;
    }

    public Pier getPier() {
        return pier;
    }

    public void setPier(Pier pier) {
        this.pier = pier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}


