package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BoatTO {
    @NotBlank(message = "La targa non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{5}$", message = "La targa non può contenere caratteri speciali o non seguire la forma XX00000")
    private String licencePlate;

    @NotBlank(message = "Il codice fiscale non può essere nullo o vuoto")
    @Pattern(regexp = "[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]", message = "Codice fiscale non valido")
    private String cf;
    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String name;

    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String colour;

    @NotBlank(message = "La licenza di navigazione non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{4}$", message = "La licenza di navigazione non può contenere caratteri speciali o non seguire la forma XX0000")
    private String navigationLicence;

    @NotBlank(message = "La potenza non può essere nulla o vuota")
    @Pattern(regexp = "^[0-9]{3}$", message = "La potenza non può contenere caratteri speciali o lettere")
    private String power;

    @NotBlank(message = "La dichiarazione di conformità non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{6}-[0-9]{3}$", message = "La dichiarazione di conformità non può contenere caratteri speciali o non seguire la forma XXXXXX000")
    private String declarationOfConformity;

    @NotBlank(message = "L 'RCA non può essere nulla o vuota")
    @Pattern(regexp = "^[A-Z]{2}-[0-9]{3}$", message = "LL 'RCA non può contenere caratteri speciali o non seguire la forma XX000")
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
