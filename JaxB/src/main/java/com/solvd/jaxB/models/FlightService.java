package com.solvd.jaxB.models;

public class FlightService extends AbstractEntity{
    private int flightId;
    private int serviceId;

    public FlightService() {
    }

    public FlightService(int id, int flightId, int serviceId) {
        super(id);
        this.flightId = flightId;
        this.serviceId = serviceId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public String toString() {
        return "FlightService{" +
                "id=" + getId() +
                ", flightId=" + flightId +
                ", serviceId=" + serviceId +
                '}';
    }
}
