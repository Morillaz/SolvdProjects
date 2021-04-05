package com.solvd.buildingCompany.staff.subordinates;


import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Accountant extends Employee {
    private static final Logger logger = LogManager.getLogger(Accountant.class);

    public Accountant() {
        logger.info("New Accountant Created");
    }

    public Accountant(String name, double salary, Boss boss, Company company) {
        super(name, "Accounting", "com.solvd.buildingCompany.hierarchy.Accountant", salary, boss, company);
        logger.info("New Accountant Created");
    }

    public void generateTaxReport(){
        logger.warn("Tax Report not implemented");
    }
}
