package com.solvd.airportJava.models;

public class Country extends AbstractEntity{
    private String name;

    public Country() {
    }

    public Country(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
