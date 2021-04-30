package com.solvd.airportJava.models;

import java.sql.Timestamp;

public class Flight extends AbstractEntity{
    private String status;
    private Timestamp departure;
    private Timestamp arrival;
    private int routeId;
    private int airplaneId;

    public Flight(){
    }

    public Flight(int id, String status, Timestamp departure, Timestamp arrival, int routeId, int airplaneId) {
        super(id);
        this.status = status;
        this.departure = departure;
        this.arrival = arrival;
        this.routeId = routeId;
        this.airplaneId = airplaneId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Timestamp getArrival() {
        return arrival;
    }

    public void setArrival(Timestamp arrival) {
        this.arrival = arrival;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + getId() +
                ", status='" + status + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", routeId=" + routeId +
                ", airplaneId=" + airplaneId +
                '}';
    }
}
