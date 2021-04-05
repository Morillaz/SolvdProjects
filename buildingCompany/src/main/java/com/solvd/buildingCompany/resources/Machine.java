package com.solvd.buildingCompany.resources;

public class Machine extends Resource{
    private String condition;

    public Machine() {
    }

    public Machine(String type, double amount, String condition) {
        super(type, amount);
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
