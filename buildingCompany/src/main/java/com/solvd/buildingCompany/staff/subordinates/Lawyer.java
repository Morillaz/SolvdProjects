package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lawyer extends Employee {
    private static final Logger logger = LogManager.getLogger(Notary.class);

    public Lawyer() {
        logger.info("New Notary created.");
    }

    public Lawyer(String name, double salary, Boss boss, Company company) {
        super(name, "Legal", "Lawyer", salary, boss, company);
        logger.info("New Lawyer created.");
    }

    public void processDemand() {
        logger.warn("Process Demand not implemented.");
    }
}
