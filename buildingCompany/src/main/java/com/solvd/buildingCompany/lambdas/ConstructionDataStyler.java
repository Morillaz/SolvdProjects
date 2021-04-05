package com.solvd.buildingCompany.lambdas;

import com.solvd.buildingCompany.product.Construction;

@FunctionalInterface
public interface ConstructionDataStyler<T extends Construction> {
    String returnFormattedData(T construction);
}
