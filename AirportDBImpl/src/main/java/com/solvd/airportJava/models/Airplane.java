package com.solvd.airportJava.models;

public class Airplane extends AbstractEntity{
    private int modelId;
    private int airlineId;

    public Airplane() {
    }

    public Airplane(int id, int modelId, int airlineId) {
        super(id);
        this.modelId = modelId;
        this.airlineId = airlineId;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + getId() +
                ", modelId=" + modelId +
                ", airlineId=" + airlineId +
                '}';
    }
}
