package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomerServiceAgent extends Employee{
    private static final Logger logger = LogManager.getLogger(SalesAgent.class);
    public CustomerServiceAgent() {
        logger.info("New Sales Agent created.");
    }

    public CustomerServiceAgent(String name, double salary, Boss boss, Company company) {
        super(name, "Sales", "Customer Service Agent", salary, boss, company);
        logger.info("New Sales Agent created.");
    }

    public void callClient(){
        logger.warn("Call Client not implemented");
    }
}
