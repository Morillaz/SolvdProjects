package com.solvd.jackson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class State extends AbstractEntity{
    @JsonProperty
    private String name;
    @JsonProperty("Countries_id")
    private int countryId;

    public State() {
    }

    public State(int id, String name, int countryId) {
        super(id);
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
