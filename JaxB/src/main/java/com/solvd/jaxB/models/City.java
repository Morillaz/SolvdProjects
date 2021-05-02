package com.solvd.jaxB.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class City extends AbstractEntity{
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "States_id")
    private int stateId;

    public City() {
    }

    public City(int id, String name, int stateId) {
        super(id);
        this.name = name;
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", stateId=" + stateId +
                '}';
    }
}
