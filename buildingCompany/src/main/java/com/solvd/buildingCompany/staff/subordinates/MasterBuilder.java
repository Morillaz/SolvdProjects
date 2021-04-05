package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MasterBuilder extends Employee{
    private static final Logger logger = LogManager.getLogger(MasterBuilder.class);
    public MasterBuilder() {
        logger.info("New Master Builder created.");
    }

    public MasterBuilder(String name, double salary, Boss boss, Company company) {
        super(name, "Construction", "Master Builder", salary, boss, company);
        logger.info("New Master Builder created.");
    }

    public void superviseConstruction(){
        logger.warn("supervise Construction not implemented.");
    }

    public void fixConstructionMistake(){
        logger.warn("Fix Construction Mistake not implemented.");
    }
}
