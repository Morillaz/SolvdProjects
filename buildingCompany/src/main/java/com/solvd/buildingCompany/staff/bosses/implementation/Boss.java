package com.solvd.buildingCompany.staff.bosses.implementation;

import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.subordinates.Employee;
import com.solvd.buildingCompany.staff.bosses.Managerable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Boss extends Employee implements Managerable {
    private Map<Integer, Employee> employees;

    public Boss() {
        super();
    }

    public Boss(String name, String area, String role, double salary, Boss boss, Company company) {
        super(name, area, role, salary, boss, company);
        this.employees = new HashMap<>();
    }

    public Boss(String name, String area, String role, double salary, Boss boss, Company company, Map<Integer ,Employee> employees) {
        super(name, area, role, salary, boss, company);
        this.employees = employees;
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) throws EmployeeException{
        this.employees.put(employee.getId(), employee);
        this.getCompany().addEmployee(employee);
    }

    public void removeEmployee(Employee employee) throws EmployeeException{
        this.employees.remove(employee.getId());
        this.getCompany().removeEmployee(employee);
    }

    public void removeEmployee(int id) throws EmployeeException{
        this.employees.remove(id);
        this.getCompany().removeEmployee(id);
    }

    public <T extends Employee> T getEmployee(String role) throws EmployeeException {
        return (T) this.getEmployees().values().stream().filter(employee
                -> employee.getRole().equalsIgnoreCase(role)).findAny().orElseThrow(()
                -> new EmployeeException("There is no employee with the role" + role));
    }

    public <T extends Employee> T getEmployee(int id) throws EmployeeException{
        return (T) this.getEmployees().values().stream().filter(employee
                -> employee.getId() == id).findAny().orElseThrow(() ->
                new EmployeeException("There is no employee with the id " + id));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Boss boss = (Boss) o;
        return Objects.equals(employees, boss.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employees);
    }

    @Override
    public String toString() {
        if(getBoss() != null){
            return "Boss{" +
                    ", id=" + getId() +
                    ", name='" + getName() + '\'' +
                    ", area='" + getArea() + '\'' +
                    ", role='" + getRole() + '\'' +
                    ", salary=" + getSalary() +
                    ", boss=" + getBoss().getName() +
                    ", employees=" + employees  +
                    ", company=" + getCompany().getName() +
                    '}';
        } else {
            return "Boss{" +
                    ", id=" + getId() +
                    ", name='" + getName() + '\'' +
                    ", area='" + getArea() + '\'' +
                    ", role='" + getRole() + '\'' +
                    ", salary=" + getSalary() +
                    ", employees=" + employees  +
                    ", boss=" + null +
                    ", company=" + getCompany().getName() +
                    '}';
        }

    }
}
