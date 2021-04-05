package com.solvd.buildingCompany.product;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Size;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Skyscraper extends Construction{
    private static final Logger logger = LogManager.getLogger(House.class);
    public Skyscraper() {
        setType(ConstructionTypes.SKYSCRAPER);
        logger.info("Skyscraper data created.");
    }

    public Skyscraper(Size size, int floors) {
        super(ConstructionTypes.SKYSCRAPER, size, floors, false);
        logger.info("Skyscraper data created.");
    }
}
