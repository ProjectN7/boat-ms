package com.Project_N7.boat_management.rto;

import com.Project_N7.boat_management.entity.Pier;

public class QuaysideRTO {
    private Long idQuayside;
    private Pier pier;
    private String name;
    private boolean isActive;

    public QuaysideRTO() { super(); }

    public QuaysideRTO(Long idQuayside, Pier pier, String name, boolean isActive) {
        this.idQuayside = idQuayside;
        this.pier = pier;
        this.name = name;
        this.isActive = isActive;
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

    public String toString() {
        return " \"Id Quayside:\": \"" +idQuayside  + "\",\n \"Id Pier:\": \"" + pier.getIdPier() + "\",\n \"Name\": \"" + name + "\",";
    }
}
