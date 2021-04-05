package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.exceptions.ConstructionException;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.exceptions.NoBudgetException;
import com.solvd.buildingCompany.product.Construction;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.bosses.interfaces.IGeneralManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Calendar;
import java.util.Map;

public class GeneralManager extends Boss implements IGeneralManager {
    private static final Logger logger = LogManager.getLogger(GeneralManager.class);
    public GeneralManager() {
        logger.info("New General Manager created.");
    }

    public GeneralManager(String name, double salary, Company company) {
        super(name, "Administration", "General Manager", salary, null, company);
        logger.info("New General Manager created.");
    }

    public GeneralManager(String name, double salary, Company company, Map<Integer, Employee> employees) {
        super(name, "Administration", "General Manager", salary, null, company, employees);
        logger.info("New General Manager created.");
    }

    @Override
    public void addEmployee(Employee employee) throws EmployeeException{
        String area = employee.getArea();
        if (area.equalsIgnoreCase("construction") && employee instanceof ConstructionManager) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if (area.equalsIgnoreCase("planification") && employee instanceof PlanificationManager) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if (area.equalsIgnoreCase("accounting") && employee instanceof AccountingManager) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if (area.equalsIgnoreCase("design") && employee instanceof DesignManager) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if (area.equalsIgnoreCase("legal") && employee instanceof LegalManager) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else if (area.equalsIgnoreCase("sales") && employee instanceof SalesManager) {
            super.addEmployee(employee);
            logger.info("Employee added.");
        } else{
            throw new EmployeeException("Incorrect role");
        }
    }

    public void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException{
        switch (ROLES){
            case CONSTRUCTION_MANAGER:
                ConstructionManager construction = new ConstructionManager(name, salary, this, this.getCompany());
                super.addEmployee(construction);
                logger.info("Employee Added.");
                break;
            case PLANIFICATION_MANAGER:
                PlanificationManager planification = new PlanificationManager(name, salary, this, this.getCompany());
                super.addEmployee(planification);
                logger.info("Employee Added.");
                break;
            case ACCOUNTING_MANAGER:
                AccountingManager accounting = new AccountingManager(name, salary, this, this.getCompany());
                super.addEmployee(accounting);
                logger.info("Employee Added.");
                break;
            case DESIGN_MANAGER:
                DesignManager design = new DesignManager(name, salary, this, this.getCompany());
                super.addEmployee(design);
                logger.info("Employee Added.");
                break;
            case LEGAL_MANAGER:
                LegalManager legal = new LegalManager(name, salary, this, this.getCompany());
                super.addEmployee(legal);
                logger.info("Employee Added.");
                break;
            case SALES_MANAGER:
                SalesManager sales = new SalesManager(name, salary, this, this.getCompany());
                super.addEmployee(sales);
                logger.info("Employee Added.");
                break;
            default:
                throw new EmployeeException("Incorrect Role");
        }
    }


    public double calculateProjectBudget(Construction construction) throws ConstructionException{
        ConstructionTypes type = construction.getType();
        double budget;
        double earningRate;
        switch (type){
            case HOUSE:
                earningRate = 1.15;
                budget = (this.getPlanificationBudget(construction) + (this.getConstructionBudget() * this.getPlanificationTime(construction)) + this.getDesignBudget(construction) + this.getLicensesBudget(construction)) * earningRate;
                break;
            case CHURCH:
                earningRate = 1.20;
                budget = (this.getPlanificationBudget(construction) + (this.getConstructionBudget() * this.getPlanificationTime(construction)) + this.getDesignBudget(construction) + this.getLicensesBudget(construction)) * earningRate;
                break;
            case HOSPITAL:
            case MULTIPURPOSE_BUILDING:
                earningRate = 1.20;
                budget = (this.getPlanificationBudget(construction) + (this.getConstructionBudget() * this.getPlanificationTime(construction)) + this.getLicensesBudget(construction)) * earningRate;
                break;
            case SKYSCRAPER:
                earningRate = 1.35;
                budget = (this.getPlanificationBudget(construction) + (this.getConstructionBudget() * this.getPlanificationTime(construction)) + this.getLicensesBudget(construction)) * earningRate;
                break;
            default:
                throw new ConstructionException("Invalid Construction");
                
        } if(!construction.isStateOwned()){
            budget = this.getTaxes(budget);
        }
        logger.info("Project Budget calculated.");
        return budget;
    }

    private double getTaxes(double budget){
        double budgetWithTaxes = 0;
        try{
            AccountingManager accounting = this.getEmployee("accounting");
            budgetWithTaxes = accounting.calculateTaxes(budget);
        } catch (EmployeeException | NoBudgetException e){
            logger.error(e.getMessage());
        }
        return budgetWithTaxes;
    }

    private double getLicensesBudget(Construction construction){
        if(!construction.isStateOwned()){
            double budget;
            try{
                LegalManager legal = this.getEmployee("legal");
                budget = legal.generateConstructionLicensesBudget(construction);
                return budget;
            } catch (EmployeeException | ConstructionException e){
                logger.error(e.getMessage());
            }
        } return 0;
    }

    private double getDesignBudget(Construction construction){
        double budget = 0;
        try{
            DesignManager design = this.getEmployee("design");
            budget = design.generateDesignBudget(construction);
        } catch (EmployeeException e){
            logger.error(e.getMessage());
        }
        return budget;
    }

    private double getPlanificationBudget(Construction construction){
        double budget = 0;
        try{
            PlanificationManager planification = this.getEmployee("planification");
            budget = planification.generatePlanificationBudget(construction);
        } catch (EmployeeException | ConstructionException e){
            logger.error(e.getMessage());
        }
        return budget;
    }

    private double getPlanificationTime(Construction construction){
        double time = 0;
        try{
            PlanificationManager planification = this.getEmployee("planification");
            time = planification.estimateConstructionTime(construction);
            Calendar now = Calendar.getInstance();
            now.add(Calendar.MONTH, (int) Math.ceil(time));
            construction.setFinishConstructionDate(now);

        } catch (EmployeeException | ConstructionException e){
            logger.error(e.getMessage());
        }
        return time;
    }

    private double getConstructionBudget(){
        double budget = 0;
        try{
            ConstructionManager construction = this.getEmployee("construction");
            budget = construction.generateConstructionBudget();
        } catch (EmployeeException e){
            logger.error("Workforce cost can not be calculated.");
        }
        return budget;
    }

    @Override
    public <T extends Employee> T getEmployee(String area) throws EmployeeException {
        return (T) this.getEmployees().values().stream().filter(employee
                -> employee.getArea().equalsIgnoreCase(area)).findAny().orElseThrow(() ->
                new EmployeeException("There is no employee in the area" + area));
    }

}
