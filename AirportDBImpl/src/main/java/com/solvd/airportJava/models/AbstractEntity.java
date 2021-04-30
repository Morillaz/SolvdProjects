package com.solvd.airportJava.models;

public abstract class AbstractEntity {
    private int id;

    public AbstractEntity() {
        this.id = 0;
    }

    public AbstractEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;

    }
}