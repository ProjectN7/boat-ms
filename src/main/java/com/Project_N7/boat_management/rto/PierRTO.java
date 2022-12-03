package com.Project_N7.boat_management.rto;

public class PierRTO {

    private Integer idPier;
    private String name;
    private int capacity;

    public PierRTO() { super(); }

    public PierRTO(Integer idPier, String name, int capacity) {
        this.idPier = idPier;
        this.name = name;
        this.capacity = capacity;
    }

    public Integer getIdPier() {
        return idPier;
    }

    public void setIdPier(Integer idPier) {
        this.idPier = idPier;
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

    public String toString() {
        return " \"Id Pier:\": \"" +idPier  + "\",\n \"Nome\": \"" + name + "\",\n \"Capacità\": \"" + capacity + "\",";
    }
}