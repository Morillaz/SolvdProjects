package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.enums.Size;
import com.solvd.buildingCompany.exceptions.ConstructionException;
import com.solvd.buildingCompany.exceptions.ConstructionSpecificationsException;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.product.Construction;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.interfaces.ILegalManager;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.subordinates.Lawyer;
import com.solvd.buildingCompany.staff.subordinates.Notary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class LegalManager extends Boss implements ILegalManager {
    private static final Logger logger = LogManager.getLogger(LegalManager.class);
    public LegalManager() {
        logger.info("New Legal Manager created.");
    }

    public LegalManager(String name, double salary, Boss boss, Company company) {
        super(name, "Legal", "Legal Manager", salary, boss, company);
        logger.info("New Legal Manager created.");
    }

    public LegalManager(String name, double salary, Boss boss, Company company, Map<Integer, Employee> employees) {
        super(name, "Legal", "Legal Manager", salary, boss, company, employees);
        logger.info("New Legal Manager created.");
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeException{
        String role = employee.getRole();
        if(role.equalsIgnoreCase("Notary") && employee instanceof Notary) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if (role.equalsIgnoreCase("Lawyer") && employee instanceof Lawyer){
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else {
            throw new EmployeeException("Incorrect role");
        }
    }

    public void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException{
        switch (ROLES){
            case NOTARY:
                Notary notary = new Notary(name, salary, this, this.getCompany());
                super.addEmployee(notary);
                logger.info("Employee Added.");
                break;
            case LAWYER:
                Lawyer lawyer = new Lawyer(name, salary, this, this.getCompany());
                super.addEmployee(lawyer);
                logger.info("Employee Added.");
                break;
            default:
                throw new EmployeeException("Incorrect Role");
        }
    }

    public double generateConstructionLicensesBudget(Construction construction) throws ConstructionException{
        ConstructionTypes type = construction.getType();
        switch (type){
            case HOUSE:
                try {
                    return houseLicenses(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case CHURCH:
                try {
                    return churchLicenses(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case MULTIPURPOSE_BUILDING:
                try {
                    return multipurposeLicenses(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case HOSPITAL:
                try {
                    return hospitalLicenses(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            case SKYSCRAPER:
                try {
                    return skyscraperLicenses(construction);
                } catch (ConstructionSpecificationsException e) {
                    logger.error(e.getMessage());
                }
            default:
                throw new ConstructionException("Invalid Construction.");
        }
    }

    private double houseLicenses(Construction construction) throws ConstructionSpecificationsException {
        if(construction.getSize() != null && construction.getFloors() > 0){
            Size size = construction.getSize();
            int floors = construction.getFloors();
            double budget = 0;

            switch (size) {
                case SMALL:
                    budget = 100;
                    break;
                case STANDARD:
                    budget = 250;
                    break;
                case BIG:
                    budget = 500;
                    break;
            }

            if (floors > 1){
                budget += (floors * 100);
            }

            logger.info("Legal cost added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough data to calculate the legal costs.");
        }
    }

    private double churchLicenses(Construction construction) throws ConstructionSpecificationsException {
        if(construction.getSize() != null && construction.getFloors() > 0){
            Size size = construction.getSize();
            int floors = construction.getFloors();
            double budget = 0;

            switch (size) {
                case SMALL:
                    budget = 250;
                    break;
                case STANDARD:
                    budget = 500;
                    break;
                case BIG:
                    budget = 700;
                    break;
            }

            if (floors > 1){
                budget += (floors * 200);
            }

            logger.info("Legal cost added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough data to calculate the legal costs.");
        }
    }

    private double multipurposeLicenses(Construction construction) throws ConstructionSpecificationsException {
        if(construction.getSize() != null && construction.getFloors() > 0){
            Size size = construction.getSize();
            int floors = construction.getFloors();
            double budget = 0;

            switch (size) {
                case SMALL:
                    budget = 400;
                    break;
                case STANDARD:
                    budget = 800;
                    break;
                case BIG:
                    budget = 1200;
                    break;
            }

            if (floors > 1){
                budget += (floors * 300);
            }

            logger.info("Legal cost added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough data to calculate the legal costs.");
        }
    }

    private double hospitalLicenses(Construction construction) throws ConstructionSpecificationsException {
        if(construction.getSize() != null && construction.getFloors() > 0){
            Size size = construction.getSize();
            int floors = construction.getFloors();
            double budget = 0;

            switch (size) {
                case SMALL:
                    budget = 200;
                    break;
                case STANDARD:
                    budget = 250;
                    break;
                case BIG:
                    budget = 300;
                    break;
            }

            if (floors > 1){
                budget += (floors * 600);
            }

            logger.info("Legal cost added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough data to calculate the legal costs.");
        }
    }

    private double skyscraperLicenses(Construction construction) throws ConstructionSpecificationsException {
        if(construction.getSize() != null && construction.getFloors() > 0){
            Size size = construction.getSize();
            int floors = construction.getFloors();
            double budget = 0;

            switch (size) {
                case SMALL:
                    budget = 1000;
                    break;
                case STANDARD:
                    budget = 2500;
                    break;
                case BIG:
                    budget = 5000;
                    break;
            }

            if (floors > 1){
                budget += (floors * 1000);
            }

            logger.info("Legal cost added to budget.");
            return budget;
        } else {
            throw new ConstructionSpecificationsException("There are not enough data to calculate the legal costs.");
        }
    }
}
