package com.solvd.jackson.models;

public class SeatsAvailability extends AbstractEntity{
    private int availables;
    private int occupied;
    private int seatsId;

    public SeatsAvailability() {
    }

    public SeatsAvailability(int id, int availables, int occupied, int seatsId) {
        super(id);
        this.availables = availables;
        this.occupied = occupied;
        this.seatsId = seatsId;
    }

    public int getAvailables() {
        return availables;
    }

    public void setAvailables(int availables) {
        this.availables = availables;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public int getSeatsId() {
        return seatsId;
    }

    public void setSeatsId(int seatsId) {
        this.seatsId = seatsId;
    }

    @Override
    public String toString() {
        return "SeatsAvailability{" +
                "id=" + getId() +
                ", availables=" + availables +
                ", occupied=" + occupied +
                ", seatsId=" + seatsId +
                '}';
    }
}
