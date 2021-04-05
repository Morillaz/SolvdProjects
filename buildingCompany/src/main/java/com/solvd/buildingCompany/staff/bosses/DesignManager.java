package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.enums.Size;
import com.solvd.buildingCompany.enums.StyleQuality;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.exceptions.ConstructionSpecificationsException;
import com.solvd.buildingCompany.product.Construction;
import com.solvd.buildingCompany.product.House;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.subordinates.Designer;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.bosses.interfaces.IDesignManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class DesignManager extends Boss implements IDesignManager {
    private static final Logger logger = LogManager.getLogger(DesignManager.class);
    public DesignManager() {
        logger.info("New Design Manager created.");
    }

    public DesignManager(String name, double salary, Boss boss, Company company) {
        super(name, "Design", "Design Manager", salary, boss, company);
        logger.info("New Design Manager created.");
    }

    public DesignManager(String name, double salary, Boss boss, Company company, Map<Integer, Employee> employees) {
        super(name,"Design", "Design Manager", salary, boss, company,employees);
        logger.info("New Design Manager created.");
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeException{
        String role = employee.getRole();
        if(role.equalsIgnoreCase("Designer") && employee instanceof Designer) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else {
            throw new EmployeeException("Incorrect role");
        }
    }

    public void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException {
        switch (ROLES){
            case DESIGNER:
                Designer designer = new Designer(name, salary, this, this.getCompany());
                super.addEmployee(designer);
                logger.info("Employee added.");
                break;
            default:
                throw new EmployeeException("Incorrect role");
        }

    }

    public double generateDesignBudget(Construction construction) {
        ConstructionTypes type = construction.getType();
        switch (type){
            case HOUSE:
                try {
                    return houseDesignBudget(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
        }
        return 0;
    }

    private double houseDesignBudget(Construction construction) throws ConstructionSpecificationsException {
        House house = (House) construction;
        if (house.getFloors() > 0 && house.getQuality() != null){
            double budget = 0;
            StyleQuality quality = house.getQuality();
            Size size = house.getSize();
            int floors = house.getFloors();

            switch (quality) {
                case MODEST:
                    budget = 250;
                    break;
                case STANDARD:
                    budget = 500;
                    break;
                case LUXURIOUS:
                    budget = 1000;
                    break;
            }

            if (size == Size.SMALL) {
                budget *= 0.75;
            } else if (size == Size.BIG) {
                budget *= 1.25;
            }

            if (floors > 1){
                budget *= floors * 1.2;
            }

            logger.info("Quality cost added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("Not enough data to calculate quality budget.");
        }
    }
}
