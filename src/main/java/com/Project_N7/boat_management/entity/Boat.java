package com.Project_N7.boat_management.entity;

import javax.persistence.*;

@Entity
@Table(name="boat")
public class Boat {

    @Id
    @Column(name = "licence_plate")
    private String licencePlate;

    @Column(name = "cf")
    private String cf;


    @Column(name = "name")
    private String name;

    @Column(name = "colour")
    private String colour;

    @Column(name = "navigation_licence")
    private String navigationLicence;

    @Column(name = "power")
    private String power;

    @Column(name = "declaration_of_conformity")
    private String declarationOfConformity;

    @Column(name = "rca")
    private String rca;


    public Boat() { super(); }

    public String getCf() { return cf; }

    public void setCf(String cf) { this.cf = cf; }

    public String getLicencePlate() {return licencePlate;}

    public void setLicencePlate(String licencePlate) {this.licencePlate = licencePlate;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getNavigationLicence() {
        return navigationLicence;
    }

    public void setNavigationLicence(String navigationLicence) {
        this.navigationLicence = navigationLicence;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDeclarationOfConformity() {
        return declarationOfConformity;
    }

    public void setDeclarationOfConformity(String declarationOfConformity) {
        this.declarationOfConformity = declarationOfConformity;}

    public String getRca() {
        return rca;
    }

    public void setRca(String rca) {
        this.rca = rca;
    }
}
