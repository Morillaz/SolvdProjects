package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Architect extends Employee {
    private static final Logger logger = LogManager.getLogger(Architect.class);
    public Architect() {
        logger.info("New Architect Created.");
    }

    public Architect(String name, double salary, Boss boss, Company company) {
        super(name, "Planification", "Architect", salary, boss, company);
        logger.info("New Architect Created.");
    }

    public void designHouse(){
        logger.warn("Design House not implemented.");
    }

    public void makeBlueprint(){
        logger.warn("Make blueprint not implemented.");
    }

    public void makeRender(){
        logger.warn("Make Render not implemented.");
    }
}
