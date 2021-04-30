package com.solvd.airportJava.models;

public class City extends AbstractEntity{
    private String name;
    private int stateId;

    public City() {
    }

    public City(int id, String name, int stateId) {
        super(id);
        this.name = name;
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", stateId=" + stateId +
                '}';
    }
}
