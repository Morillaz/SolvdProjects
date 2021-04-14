package com.solvd.buildingCompany.staff.subordinates;


import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.implementation.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Worker extends Employee {
    private static final Logger logger = LogManager.getLogger(Worker.class);
    public Worker() {
        logger.info("New Worker created.");
    }

    public Worker(String name, double salary, Boss boss, Company company) {
        super(name, "Construction", "com.solvd.buildingCompany.hierarchy.Worker", salary, boss, company);
        logger.info("New Worker created.");
    }

    public <T> void buildStructure(T t){
        this.build(t);
    }

    private <T> void build(T t){
        logger.warn("Build not implemented.");
    }

}
