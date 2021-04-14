package com.solvd.buildingCompany.staff.bosses;


import com.solvd.buildingCompany.exceptions.NoBudgetException;

public interface IAccountingManager {
    double calculateTaxes(double budget) throws NoBudgetException;
}
