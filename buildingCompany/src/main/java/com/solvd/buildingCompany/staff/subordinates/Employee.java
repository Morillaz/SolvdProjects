package com.solvd.buildingCompany.staff.subordinates;

import com.solvd.buildingCompany.staff.Company;
import com.solvd.buildingCompany.staff.bosses.Boss;

import java.util.Objects;
import java.util.Random;

public abstract class Employee {
    private Integer id;
    private String name;
    private String area;
    private String role;
    private double salary;
    private Boss boss;
    private Company company;

    public Employee() {
    }

    public Employee(String name, String area, String role, double salary, Boss boss, Company company) {
        this.name = name;
        this.area = area;
        this.role = role;
        this.salary = salary;
        this.boss = boss;
        setCompany(company);
    }

    public Integer getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        if(company != null){
            Random generator = new Random();
            int id = generator.nextInt();
            while (true){
                if(company.getEmployees() != null && !company.getEmployees().containsKey(id)){

                    this.id = id;
                    break;
                } else if (company.getEmployees() == null){
                    this.id = id;
                    break;
                }
            }
            company.addEmployee(this);
            this.company = company;
        } else {
            this.id = null;
            this.company = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0 && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(area, employee.area) && Objects.equals(role, employee.role) && Objects.equals(boss, employee.boss) && Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, area, role, salary, boss, company);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", role='" + role + '\'' +
                ", salary=" + salary +
                ", boss=" + boss.getName() +
                ", company=" + company.getName() +
                '}';
    }
}
