package com.Project_N7.boat_management.to;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class QuaysideTO {
    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String name;

    private boolean isActive;

    public QuaysideTO() { super(); }

    public QuaysideTO(String name, boolean isActive) {
        this.name = name;
        this.isActive = isActive;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
         isActive = active;
    } //Da controllare
}