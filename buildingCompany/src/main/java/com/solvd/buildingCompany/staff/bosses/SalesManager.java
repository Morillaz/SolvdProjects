package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.subordinates.CustomerServiceAgent;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.subordinates.SalesAgent;
import com.solvd.buildingCompany.staff.bosses.interfaces.ISalesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SalesManager extends Boss implements ISalesManager {
    private static final Logger logger = LogManager.getLogger(SalesManager.class);
    public SalesManager() {
        logger.info("New Sales Manager created.");
    }

    public SalesManager(String name, double salary, Boss boss, Company company) {
        super(name, "Sales", "Sales Manager", salary, boss, company);
        logger.info("New Sales Manager created.");
    }

    public SalesManager(String name, double salary, Boss boss, Company company, Map<Integer, Employee> employees) {
        super(name, "Sales", "Sales Manager", salary, boss, company, employees);
        logger.info("New Sales Manager created.");
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeException{
        String role = employee.getRole();
        if(role.equalsIgnoreCase("Sales Agent") && employee instanceof SalesAgent) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else  if (role.equalsIgnoreCase("Customer Service Agent") && employee instanceof CustomerServiceAgent){
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else {
            throw new EmployeeException("Invalid role.");
        }
    }

    public void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException{
        switch (ROLES){
            case SALES_AGENT:
                SalesAgent seller = new SalesAgent(name, salary, this, this.getCompany());
                super.addEmployee(seller);
                logger.info("Employee added.");
                break;
            case CUSTOMER_SERVICE_AGENT:
                CustomerServiceAgent customerServiceAgent = new CustomerServiceAgent(name, salary, this, this.getCompany());
                super.addEmployee(customerServiceAgent);
                logger.info("Employee Added.");
                break;
            default:
                throw new EmployeeException("Incorrect Role");
        }
    }

    public void makeSalesInform(){
        logger.warn("Make sales inform not implemented.");
    }

}
