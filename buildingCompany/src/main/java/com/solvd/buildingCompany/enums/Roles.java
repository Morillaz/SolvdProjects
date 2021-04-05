package com.solvd.buildingCompany.enums;

public enum Roles {
    GENERAL_MANAGER("General Manager", "Administration"),
    SALES_MANAGER("Sales", "Sales Manager"),
    PLANIFICATION_MANAGER("Planification", "Planification Manager"),
    CONSTRUCTION_MANAGER("Construction", "Construction Manager"),
    LEGAL_MANAGER("Legal", "Legal Manager"),
    DESIGN_MANAGER("Design", "Design Manager"),
    ACCOUNTING_MANAGER("Accounting", "Accounting Manager"),
    ARCHITECT("Architect", "Planification"),
    CIVIL_ENGINEER("Civil Engineer", "Planification"),
    ACCOUNTANT("Accountant", "Accounting"),
    BOOKKEEPER("Bookkeeper", "Accounting"),
    SALES_AGENT("Sales Agent", "Sales"),
    CUSTOMER_SERVICE_AGENT("Customer Service Agent", "Sales"),
    NOTARY("Notary", "Legal"),
    LAWYER("Lawyer", "Legal"),
    DESIGNER("Designer", "Design"),
    WORKER("Worker", "Construction"),
    MASTER_BUILDER("Master Builder", "Construction");

    private String role;
    private String area;

    Roles(String role, String area) {
        this.role = role;
        this.area = area;
    }

    public String area() {
        return area;
    }

    public String role() {
        return role;
    }
}
