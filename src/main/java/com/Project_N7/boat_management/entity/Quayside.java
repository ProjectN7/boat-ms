package com.Project_N7.boat_management.entity;

import javax.persistence.*;

@Entity
@Table(name="quayside")
public class Quayside {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Quayside")
    private Long idQuayside;

    @Column(name = "ID_PIER")
    private Long pier;

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

    public Long getPier() {
        return pier;
    }

    public void setPier(Long pier) {
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


