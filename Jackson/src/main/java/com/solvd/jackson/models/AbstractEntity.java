package com.solvd.jackson.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractEntity {
    @JsonProperty
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