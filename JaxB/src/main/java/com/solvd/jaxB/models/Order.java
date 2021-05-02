package com.solvd.jaxB.models;

public class Order extends AbstractEntity{
    private int peopleId;
    private int flightId;
    private double price;

    public Order() {
    }

    public Order(int id, int peopleId, int flightId, double price) {
        super(id);
        this.peopleId = peopleId;
        this.flightId = flightId;
        this.price = price;
    }

    public int getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(int peopleId) {
        this.peopleId = peopleId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + getId() +
                ", peopleId=" + peopleId +
                ", flightId=" + flightId +
                ", price=" + price +
                '}';
    }
}
