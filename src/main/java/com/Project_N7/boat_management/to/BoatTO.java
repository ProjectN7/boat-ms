package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.Project_N7.boat_management.constants.Constants.*;

public class BoatTO {
    @NotBlank(message = LICENCE_PLATE_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{5}$", message = LICENCE_PLATE_INFO)
    private String licencePlate;

    @NotBlank(message = CF_CANNOT_BE_EMPTY)
    @Pattern(regexp = "[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]", message = CF_INFO)
    private String cf;
    @Pattern(regexp = "^[a-z A-Z]+$", message = NAME_INFO)
    private String name;

    @Pattern(regexp = "^[a-z A-Z]+$", message = NAME_INFO)
    private String colour;

    @NotBlank(message = NAVIGATION_LICENCE_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{4}$", message =NAVIGATION_LICENCE_INFO)
    private String navigationLicence;

    @NotBlank(message = POWER_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[0-9]{3}$", message = POWER_INFO)
    private String power;

    @NotBlank(message = DECLARATION_OF_CONFORMITY_CANNOT_BE_EMPTY)
    @Pattern(regexp = "^[A-Z]{6}-[0-9]{3}$", message = DECLARATION_OF_CONFORMITY_INFO)
    private String declarationOfConformity;

    private String rca;

    public BoatTO() { super(); }

    public BoatTO(String licencePlate, String name, String colour, String navigationLicence, String power,
                  String declarationOfConformity, String rca) {
        this.licencePlate = licencePlate;
        this.name = name;
        this.colour = colour;
        this.navigationLicence = navigationLicence;
        this.power = power;
        this.declarationOfConformity = declarationOfConformity;
        this.rca = rca;
    }

    public String getCf() { return cf; }

    public void setCf(String cf) { this.cf = cf; }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
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
