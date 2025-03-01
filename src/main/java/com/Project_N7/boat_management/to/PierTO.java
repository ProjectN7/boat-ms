package com.Project_N7.boat_management.to;

import javax.validation.constraints.Pattern;

import static com.Project_N7.boat_management.constants.Constants.NAME_INFO;

public class PierTO {
    @Pattern(regexp = "^[a-z A-Z]+$", message = NAME_INFO)
    private String name;

    
    private int capacity;

    public PierTO() { super(); }

    public PierTO(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}