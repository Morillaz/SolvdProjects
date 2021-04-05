package com.solvd.buildingCompany.product;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultipurposeBuilding extends Construction{
    private static final Logger logger = LogManager.getLogger(House.class);
    public MultipurposeBuilding() {
        setType(ConstructionTypes.MULTIPURPOSE_BUILDING);
        logger.info("Building data created.");
    }

    public MultipurposeBuilding(Size size, int floors, boolean isStateOwned) {
        super(ConstructionTypes.MULTIPURPOSE_BUILDING, size, floors, isStateOwned);
        logger.info("Building data created.");
    }
}
