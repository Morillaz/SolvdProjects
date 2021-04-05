package com.solvd.buildingCompany.product;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hospital extends Construction{
    private static final Logger logger = LogManager.getLogger(House.class);

    public Hospital() {
        setType(ConstructionTypes.HOSPITAL);
        logger.info("Hospital data created.");
    }

    public Hospital(Size size, int floors, boolean isStateOwned) {
        super(ConstructionTypes.HOSPITAL, size, floors, isStateOwned);
        logger.info("HOspital data created.");
    }
}
