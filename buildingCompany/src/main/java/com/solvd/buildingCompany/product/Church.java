package com.solvd.buildingCompany.product;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Size;
import com.solvd.buildingCompany.enums.Style;
import com.solvd.buildingCompany.enums.StyleQuality;
import org.apache.commons.lang3.time.CalendarUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Church extends Construction{
    private static final Logger logger = LogManager.getLogger(House.class);

    private Style style;
    private StyleQuality quality;

    public Church() {
        setType(ConstructionTypes.CHURCH);
        logger.info("Church data created.");
    }

    public Church(Size size, int floors, boolean isStateOwned, Style style, StyleQuality quality) {
        super(ConstructionTypes.CHURCH, size, floors, isStateOwned);
        this.style = style;
        this.quality = quality;
        logger.info("Church data created.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Church church = (Church) o;
        return style == church.style && quality == church.quality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), style, quality);
    }

    @Override
    public String toString() {
        return "Church{" +
                "style=" + style +
                ", quality=" + quality +
                ", type=" + getType() +
                ", size='" + getSize() + '\'' +
                ", floors=" + getFloors() +
                ", finishConstructionDate=" + new CalendarUtils(getFinishConstructionDate()).getMonth() + "/" +new CalendarUtils(getFinishConstructionDate()).getYear() +
                ", stateOwned=" + isStateOwned() +
                '}';
    }
}
