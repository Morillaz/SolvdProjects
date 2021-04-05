package com.solvd.buildingCompany.resources;

public class Money extends Resource implements Convertable{
    public Money() {
    }

    public Money(String type, double amount) {
        super(type, amount);
    }

    public void convert(String to) {
        if (this.getType().equalsIgnoreCase("USD") && to.equalsIgnoreCase("EUR")) {
            setAmount(getAmount() * 0.84);
            setType("EUR");
        } else if (this.getType().equalsIgnoreCase("EUR ") && to.equalsIgnoreCase("USD")) {
            setAmount(getAmount() * 1.21);
            setType("usd");
        }
    }
}
