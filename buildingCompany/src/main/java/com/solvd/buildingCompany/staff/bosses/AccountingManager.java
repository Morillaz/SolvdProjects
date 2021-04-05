package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.exceptions.NoBudgetException;
import com.solvd.buildingCompany.staff.subordinates.Accountant;
import com.solvd.buildingCompany.staff.subordinates.Bookkeeper;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.bosses.interfaces.IAccountingManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Map;



public class AccountingManager extends Boss implements IAccountingManager {
    private static final Logger logger = LogManager.getLogger(AccountingManager.class);

    public AccountingManager() {
        logger.info("New Accountant Manager Created");
    }

    public AccountingManager(String name, double salary, Boss boss, Company company) {
        super(name,  "Accounting", "Accounting Manager", salary, boss, company);
        logger.info("New Accountant Manager Created.");
    }

    public AccountingManager(String name, double salary, Boss boss, Company company, Map<Integer, Employee> employees) {
        super(name, "Accounting", "Accounting Manager", salary, boss, company, employees);
        logger.info("New Accountant Manager Created.");
    }

    public void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException{
        switch (ROLES){
            case ACCOUNTANT:
                Accountant accountant = new Accountant(name, salary, this, this.getCompany());
                super.addEmployee(accountant);
                logger.info("Employee Added.");
                break;
            case BOOKKEEPER:
                Bookkeeper bookkeeper = new Bookkeeper(name, salary, this, this.getCompany());
                super.addEmployee(bookkeeper);
                logger.info("Employee Added.");
                break;
            default:
                throw new EmployeeException("Incorrect Role");
        }
    }

    public double calculateTaxes(double budget) throws NoBudgetException{
        if(budget > 0){
            logger.info("Taxes Calculated.");
            return budget * 1.15;
        } else {
            throw new NoBudgetException("There is not a budget to calculate taxes");
        }
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeException{
        String role = employee.getRole();
        if(role.equalsIgnoreCase("Accountant") && employee instanceof Accountant) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if(role.equalsIgnoreCase("Bookkeeper") && employee instanceof Bookkeeper) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else {
            throw new EmployeeException("Invalid role");
        }
    }

}
