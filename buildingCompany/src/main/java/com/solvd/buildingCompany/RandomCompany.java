package com.solvd.buildingCompany;

import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.staff.*;
import com.solvd.buildingCompany.staff.bosses.implementation.ConstructionManager;
import com.solvd.buildingCompany.staff.bosses.implementation.GeneralManager;
import com.solvd.buildingCompany.staff.bosses.implementation.SalesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomCompany {
    private static final Logger logger = LogManager.getLogger(RandomCompany.class);
    public static GeneralManager generateRandom(){
        Company buildingsCo = new Company("Buildings Co.", null, "www.buildings.co", "buildings@mail.com", "555-999-BUILD");
        buildingsCo.addGeneralManager( "John Doe", 10000);
        GeneralManager manager = buildingsCo.getGeneralManager();

        try{
            manager.addEmployee("John Thinker", Roles.PLANIFICATION_MANAGER, 2500);
            manager.addEmployee("Esmerald Green", Roles.DESIGN_MANAGER, 2500);
            manager.addEmployee("Bob Constructor",Roles.CONSTRUCTION_MANAGER, 2500);
            manager.addEmployee("John Notes", Roles.ACCOUNTING_MANAGER, 2500);
            manager.addEmployee("Jude Law", Roles.LEGAL_MANAGER, 2500);
            manager.addEmployee("Selena Sell", Roles.SALES_MANAGER, 2500);
        } catch (EmployeeException e){
            logger.error(e.getMessage());
        }


        try{
            SalesManager sales = manager.getEmployee("Sales");
            sales.addEmployee("W. Streep Wolf", Roles.SALES_AGENT, 500);

            ConstructionManager construction = manager.getEmployee("Construction");
            construction.addEmployee("Jesuis Desole", Roles.WORKER, 500);
            construction.addEmployee("Jesuis Nosole", Roles.WORKER, 500);
            construction.addEmployee("Peter P.", Roles.WORKER, 500);
        } catch (EmployeeException e){
            logger.error(e.getMessage());
        }

        return manager;
    }
}
