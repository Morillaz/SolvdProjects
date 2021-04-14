package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.exceptions.EmployeeException;

public interface IConstructionManager {
    double generateConstructionBudget() throws EmployeeException;
}
