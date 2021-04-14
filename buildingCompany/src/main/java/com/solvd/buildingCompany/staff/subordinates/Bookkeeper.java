package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.implementation.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bookkeeper extends Employee{
    private static final Logger logger = LogManager.getLogger(Accountant.class);

    public Bookkeeper() {
        logger.info("New Accountant Created");
    }

    public Bookkeeper(String name, double salary, Boss boss, Company company) {
        super(name, "Accounting", "Bookkeeper", salary, boss, company);
        logger.info("New Bookkeeper Created");
    }

    public void recordTransaction(){
        logger.warn("Record transaction not implemented");
    }
}
