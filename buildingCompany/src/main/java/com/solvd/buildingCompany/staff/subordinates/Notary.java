package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.implementation.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Notary extends Employee {
    private static final Logger logger = LogManager.getLogger(Notary.class);
    public Notary() {
        logger.info("New Notary created.");
    }

    public Notary(String name, double salary, Boss boss, Company company) {
        super(name, "Legal", "XCCº com.solvd.buildingCompany.hierarchy.Notary", salary, boss, company);
        logger.info("New Notary created.");
    }

    public void certifyDocument(){
        logger.warn("Certify Document not implemented.");
    }
}
