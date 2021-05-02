package com.solvd.jackson.models;

public class Airline extends AbstractEntity{
    private String name;

    public Airline() {
    }

    public Airline(int id, String name) {
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
        return "Airline{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
