package com.Project_N7.boat_management.to;


import javax.validation.constraints.Pattern;

import static com.Project_N7.boat_management.constants.Constants.NAME_INFO;

public class QuaysideTO {
    @Pattern(regexp = "^[a-z A-Z]+$", message = NAME_INFO)
    private String name;


    public QuaysideTO() { super(); }

    public QuaysideTO(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}