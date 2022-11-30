package com.Project_N7.boat_management.rto;

public class BoatRTO {
    private String licencePlate;

    private String cf;
    private String name;
    private String colour;
    private String navigationLicence;
    private String power;
    private String declarationOfConformity;
    private String rca;

    public BoatRTO() { super(); }

    public BoatRTO(String licencePlate, String cf, String name, String colour, String navigationLicence, String power,
                   String declarationOfConformity, String rca) {
        this.licencePlate = licencePlate;
        this.cf = cf;
        this.name = name;
        this.colour = colour;
        this.navigationLicence = navigationLicence;
        this.power = power;
        this.declarationOfConformity = declarationOfConformity;
        this.rca = rca;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licence_plate) {
        this.licencePlate = licence_plate;
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

    public void setColor(String colour) {
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

    public String toString() {
        return " \"Plate\": \"" + licencePlate + "\",\n \"Name\": \"" + name + "\",\n \"Color\": \"" + colour
                + ",\"\n \"Navigation licence\": \"" + navigationLicence + "\",\n \"Power\": \"" + power
                + "\", \n \"Declaration of conformity\": \"" + declarationOfConformity + "\", \n \"rca\": \"" + rca
                + "\",";
    }
}
