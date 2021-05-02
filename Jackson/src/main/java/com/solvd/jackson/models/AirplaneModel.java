package com.solvd.jackson.models;

public class AirplaneModel extends AbstractEntity{
    private String model;
    private String size;

    public AirplaneModel() {
    }

    public AirplaneModel(int id, String model, String size) {
        super(id);
        this.model = model;
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "AirplaneModel{" +
                "id=" + getId() +
                ", model='" + model + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
