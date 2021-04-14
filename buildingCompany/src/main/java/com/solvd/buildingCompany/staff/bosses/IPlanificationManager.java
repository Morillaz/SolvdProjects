package com.solvd.buildingCompany.staff.bosses;

import com.solvd.buildingCompany.exceptions.ConstructionException;
import com.solvd.buildingCompany.product.Construction;

public interface IPlanificationManager {
    double generatePlanificationBudget(Construction construction) throws ConstructionException;
    double estimateConstructionTime(Construction construction) throws ConstructionException;
}
