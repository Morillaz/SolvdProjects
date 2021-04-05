package com.solvd.buildingCompany.client;

import com.solvd.buildingCompany.product.Construction;
import com.solvd.buildingCompany.product.House;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Client<T extends Construction>{
    private String name;
    private T requestedConstruction;
    private static final Logger logger = LogManager.getLogger(Client.class);

    public Client() {
        logger.info( "New Client created.");
    }

    public Client(String name, T requestedConstruction) {
        this.name = name;
        this.requestedConstruction = requestedConstruction;
        logger.info("New Client created.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getRequestedConstruction() {
        return this.requestedConstruction;
    }

    public void setRequestedConstruction(T requestedConstruction) {
        this.requestedConstruction = requestedConstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) && Objects.equals(requestedConstruction, client.requestedConstruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, requestedConstruction);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", requestedHouse=" + requestedConstruction +
                '}';
    }
}
