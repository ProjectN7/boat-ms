package com.Project_N7.boat_management.to;

import javax.validation.constraints.NotNull;

public class TypeTicketTO {

    private String description;

    public TypeTicketTO() { super(); }

    public TypeTicketTO(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
