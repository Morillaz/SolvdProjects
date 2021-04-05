package com.solvd.buildingCompany.resources;

import java.util.Objects;

public abstract class Resource {
    String type;
    double amount;

    public Resource() {
    }

    public Resource(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Double.compare(resource.amount, amount) == 0 && Objects.equals(type, resource.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount);
    }

    @Override
    public String toString() {
        return "Resource{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
