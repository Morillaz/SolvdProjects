package com.solvd.buildingCompany.resources;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;

public class CompanyResources {
    private Money money;
    private Bricks bricks;
    private List<Machine> machines;
    private static final Logger logger = LogManager.getLogger(CompanyResources.class);

    public CompanyResources() {
        logger.info("Company Resources created.");
    }

    public CompanyResources(Money money, Bricks bricks, List<Machine> machines) {
        this.money = money;
        this.bricks = bricks;
        this.machines = machines;
        logger.info("Company Resources created.");
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Bricks getBricks() {
        return bricks;
    }

    public void setBricks(Bricks bricks) {
        this.bricks = bricks;
    }

    public List<Machine> getMachine() {
        return machines;
    }

    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyResources that = (CompanyResources) o;
        return Objects.equals(money, that.money) && Objects.equals(bricks, that.bricks) && Objects.equals(machines, that.machines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, bricks, machines);
    }

    @Override
    public String toString() {
        return "CompanyResources{" +
                "money=" + money +
                ", bricks=" + bricks +
                ", machines=" + machines +
                ", machine=" + getMachine() +
                '}';
    }
}
