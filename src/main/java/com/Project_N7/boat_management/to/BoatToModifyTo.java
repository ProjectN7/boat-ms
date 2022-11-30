package com.Project_N7.boat_management.to;


public class BoatToModifyTo {
    private String name;

    private String colour;

    private String navigationLicence;

    private String power;

    private String declarationOfConformity;

    private String rca;

    public BoatToModifyTo() { super(); }

    public BoatToModifyTo(String name, String colour, String navigationLicence,
                          String power, String declarationOfConformity, String rca) {
        this.name = name;
        this.colour = colour;
        this.navigationLicence = navigationLicence;
        this.power = power;
        this.declarationOfConformity = declarationOfConformity;
        this.rca = rca;
    }

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
        this.declarationOfConformity = declarationOfConformity;
    }

    public String getRca() {
        return rca;
    }

    public void setRca(String rca) {
        this.rca = rca;
    }
}
