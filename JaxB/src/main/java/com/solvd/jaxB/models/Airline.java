package com.solvd.jaxB.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Airline extends AbstractEntity{
    @XmlElement(name = "name")
    private String name;

    public Airline() {
    }

    public Airline(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
