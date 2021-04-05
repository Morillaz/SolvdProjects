package com.solvd.buildingCompany.staff.bosses.interfaces;

import com.solvd.buildingCompany.exceptions.EmployeeException;

public interface IConstructionManager {
    double generateConstructionBudget() throws EmployeeException;
}
