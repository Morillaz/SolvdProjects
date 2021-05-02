package com.solvd.jackson.models;

public class Route extends AbstractEntity{
    private int airportFromId;
    private int airportToId;

    public Route() {
    }

    public Route(int id, int airportFromId, int airportToId) {
        super(id);
        this.airportFromId = airportFromId;
        this.airportToId = airportToId;
    }

    public int getAirportFromId() {
        return airportFromId;
    }

    public void setAirportFromId(int airportFromId) {
        this.airportFromId = airportFromId;
    }

    public int getAirportToId() {
        return airportToId;
    }

    public void setAirportToId(int airportToId) {
        this.airportToId = airportToId;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + getId() +
                ", airportFromId=" + airportFromId +
                ", airportToId=" + airportToId +
                '}';
    }
}
