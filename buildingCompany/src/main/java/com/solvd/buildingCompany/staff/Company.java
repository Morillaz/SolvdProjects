package com.solvd.buildingCompany.staff;

import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.product.Construction;
import com.solvd.buildingCompany.resources.CompanyResources;
import com.solvd.buildingCompany.staff.bosses.GeneralManager;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Company {
    private String name;
    private GeneralManager generalManager;
    private String webpage;
    private String email;
    private String phone;
    private Map<Integer, Employee> employees;
    private CompanyResources resources;
    private Queue<Construction> constructionsToBuild;
    private static final Logger logger = LogManager.getLogger(Company.class);

    public Company() {
        logger.info("New Company Created.");
    }

    public Company(String name, GeneralManager generalManager, String webpage, String email, String phone) {
        this.name = name;
        this.generalManager = generalManager;
        this.webpage = webpage;
        this.email = email;
        this.phone = phone;
        this.employees = new HashMap<>();
        logger.info("New Company Created.");
    }

    public Company(String name, GeneralManager generalManager, String webpage, String email, String phone, CompanyResources resources) {
        this.name = name;
        this.generalManager = generalManager;
        this.webpage = webpage;
        this.email = email;
        this.phone = phone;
        this.resources = resources;
        this.employees = new HashMap<>();
        logger.info("New Company Created.");
    }

    public Company(String name, GeneralManager generalManager, String webpage, String email, String phone, Map<Integer, Employee> employees, CompanyResources resources) {
        this.name = name;
        this.generalManager = generalManager;
        this.webpage = webpage;
        this.email = email;
        this.phone = phone;
        this.employees = employees;
        this.resources = resources;
        logger.info("New Company Created.");
    }

    public Company(String name, String webpage, String email, String phone, CompanyResources resources) {
        this.name = name;
        this.webpage = webpage;
        this.email = email;
        this.phone = phone;
        this.resources = resources;
        this.employees = new HashMap<>();
        logger.info("New Company Created.");
    }

    public Company(String name, String webpage, String email, String phone, CompanyResources resources, Queue<Construction> constructionsToBuild) {
        this.name = name;
        this.webpage = webpage;
        this.email = email;
        this.phone = phone;
        this.resources = resources;
        this.employees = new HashMap<>();
        this.constructionsToBuild = constructionsToBuild;
        logger.info("New Company Created.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeneralManager getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(GeneralManager generalManager) {
        this.generalManager = generalManager;
    }

    public String getWebpage() {
        return webpage;
    }

    public void setWebpage(String webpage) {
        this.webpage = webpage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CompanyResources getResources() {
        return resources;
    }

    public void setResources(CompanyResources resources) {
        this.resources = resources;
    }

    public Queue<Construction> getConstructionsToBuild() {
        return constructionsToBuild;
    }

    public void setConstructionsToBuild(Queue<Construction> constructionsToBuild) {
        this.constructionsToBuild = constructionsToBuild;
    }

    public void addConstructionsToBuild(Construction construction){
        if(this.constructionsToBuild == null)
        {
            this.constructionsToBuild = new LinkedList<>();
        }
        constructionsToBuild.add(construction);
        logger.info("Construction added to Queue.");
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }


    public void addGeneralManager(String name, double salary){
        this.generalManager = new GeneralManager(name, salary, this);
        this.addEmployee(this.generalManager);
        logger.info("General Manager added to Company " + this.name + ".");
    }

    public void removeManager() throws EmployeeException{
        removeEmployee(this.generalManager);
        this.generalManager = null;
    }

    public void addEmployee(Employee employee){
        this.employees.put(employee.getId(), employee);
        logger.info("Employee added to company.");
    }

    public void removeEmployee(Employee employee) throws EmployeeException {
        if (this.employees.containsKey(employee.getId())) {
            this.employees.remove(employee.getId(), employee);
            employee.setCompany(null);
            logger.info("Employee removed from company.");
        } else throw new EmployeeException("Employee not in company.");
    }
    public void removeEmployee(int id) throws EmployeeException {
        if (this.employees.containsKey(id)) {
            employees.get(id).setCompany(null);
            this.employees.remove(id);
            logger.info("Employee removed from company.");
        } else throw new EmployeeException("Employee not in company.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(name, company.name) && Objects.equals(generalManager, company.generalManager) && Objects.equals(webpage, company.webpage) && Objects.equals(email, company.email) && Objects.equals(phone, company.phone) && Objects.equals(employees, company.employees) && Objects.equals(resources, company.resources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, generalManager, webpage, email, phone, employees, resources);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", webpage='" + webpage + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", employees=" + generalManager +
                ", resources=" + resources +
                ", resources=" + constructionsToBuild +
                '}';
    }
}
