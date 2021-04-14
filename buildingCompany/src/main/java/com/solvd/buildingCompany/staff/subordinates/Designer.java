package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.implementation.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Designer extends Employee {
    private final static Logger logger = LogManager.getLogger(Designer.class);
    public Designer() {
        logger.info("New Designer created.");
    }

    public Designer(String name, double salary, Boss boss, Company company) {
        super(name, "Design", "Designer", salary, boss, company);
        logger.info("New Designer created.");
    }

    public void DesignRoom(){
        logger.warn("Design room not implemented.");
    }
}
