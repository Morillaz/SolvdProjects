package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.enums.Roles;
import com.solvd.buildingCompany.exceptions.EmployeeException;
import com.solvd.buildingCompany.staff.subordinates.Employee;

public interface Managerable {
    void addEmployee(Employee employee) throws EmployeeException;
    void addEmployee(String name, Roles ROLES, double salary) throws EmployeeException;
    void removeEmployee(Employee employee) throws EmployeeException;
    void removeEmployee(int id) throws EmployeeException;
    <T extends Employee> T getEmployee(String criteria) throws EmployeeException;
    <T extends Employee> T getEmployee(int id) throws EmployeeException;
}
