package com.solvd.jaxB.models;

public class Airport extends AbstractEntity{
    private String name;
    private int cityId;

    public Airport() {
    }

    public Airport(int id, String name, int cityId) {
        super(id);
        this.name = name;
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
