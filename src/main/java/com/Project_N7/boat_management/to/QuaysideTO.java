package com.Project_N7.boat_management.to;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class QuaysideTO {
    @Pattern(regexp = "^[a-z A-Z]+$", message = "Il nome non può contenere numeri o caratteri speciali")
    private String name;


    public QuaysideTO() { super(); }

    public QuaysideTO(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}