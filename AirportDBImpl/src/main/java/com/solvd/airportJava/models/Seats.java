package com.solvd.airportJava.models;

public class Seats extends AbstractEntity{
    private String classType;
    private int airplaneModel;

    public Seats() {
    }

    public Seats(int id, String classType, int airplaneModel) {
        super(id);
        this.classType = classType;
        this.airplaneModel = airplaneModel;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public int getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(int airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    @Override
    public String toString() {
        return "Seats{" +
                "id=" + getId() +
                ", classType='" + classType + '\'' +
                ", airplaneModel=" + airplaneModel +
                '}';
    }
}
