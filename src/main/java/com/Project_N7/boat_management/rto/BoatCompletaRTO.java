package com.Project_N7.boat_management.rto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class BoatCompletaRTO extends BoatRTO {

    @JsonIgnore
    private String licencePlate;

    public BoatCompletaRTO() { super(); }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }
}
