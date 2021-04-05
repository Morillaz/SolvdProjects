package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.subordinates.MasterBuilder;
import com.solvd.buildingCompany.staff.subordinates.Worker;
import com.solvd.buildingCompany.staff.bosses.interfaces.IConstructionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class ConstructionManager extends Boss implements IConstructionManager {
    private static final Logger logger = LogManager.getLogger(ConstructionManager.class);
    public ConstructionManager() {
        logger.info("New Construction Manager Created.");
    }

    public ConstructionManager(String name, double salary, Boss boss, Company company) {
        super(name, "Construction", "Construction Manager", salary, boss, company);
        logger.info("New Construction Manager Created.");
    }

    public ConstructionManager(String name, double salary, Boss boss, Company company , Map<Integer, Employee> employees) {
        super(name, "Construction", "Construction Manager", salary, boss, company, employees);
        logger.info("New Construction Manager Created.");
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeException{
        String role = employee.getRole();
        if(role.equalsIgnoreCase("Worker") && employee instanceof Worker) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if(role.equalsIgnoreCase("Master Builder") && employee instanceof MasterBuilder){
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else {
            throw new EmployeeException("Incorrect Role");
        }
    }

    public void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException{
        switch (ROLES){
            case WORKER:
                Worker worker = new Worker(name, salary, this, this.getCompany());
                super.addEmployee(worker);
                logger.info("Employee Added.");
                break;
            case MASTER_BUILDER:
                MasterBuilder masterBuilder = new MasterBuilder(name, salary, this, this.getCompany());
                super.addEmployee(masterBuilder);
                logger.info("Employee Added.");
                break;
            default:
                throw new EmployeeException("Incorrect Role");
        }
    }

    public double generateConstructionBudget() throws EmployeeException{
        Map<Integer,Employee> employees = this.getEmployees();
        if(!employees.isEmpty()){
            double budget = 0;
            budget = employees.values().stream().mapToDouble(Employee::getSalary).sum();
            logger.info("Workforce cost added to budget.");
            return budget;
        } else {
            throw new EmployeeException("This manager doesn't have employees");
        }
    }
}
