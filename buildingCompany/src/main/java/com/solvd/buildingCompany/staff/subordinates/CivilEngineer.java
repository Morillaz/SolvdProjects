package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.implementation.Boss;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CivilEngineer extends Employee{
    private static final Logger logger = LogManager.getLogger(CivilEngineer.class);
    public CivilEngineer() {
    }

    public CivilEngineer(String name, double salary, Boss boss, Company company) {
        super(name, "Planification", "Civil Engineer", salary, boss, company);
    }

    public void studyZone(){
        logger.warn("Study Zone method not implemented.");
    }
    public void prepareSafetyMeasures(){
        logger.warn("Prepare safety measures method not implemented.");
    }

}
