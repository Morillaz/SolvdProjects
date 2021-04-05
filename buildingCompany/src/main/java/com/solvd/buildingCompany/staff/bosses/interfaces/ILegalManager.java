package com.solvd.buildingCompany.staff.bosses.interfaces;

import com.solvd.buildingCompany.exceptions.ConstructionException;
import com.solvd.buildingCompany.product.Construction;

public interface ILegalManager {
    double generateConstructionLicensesBudget(Construction construction) throws ConstructionException;
}
