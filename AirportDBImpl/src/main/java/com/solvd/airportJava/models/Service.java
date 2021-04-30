package com.solvd.airportJava.models;

public class Service extends AbstractEntity{
    private String type;

    public Service() {
    }

    public Service(int id, String type) {
        super(id);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + getId() +
                ", type='" + type + '\'' +
                '}';
    }
}
