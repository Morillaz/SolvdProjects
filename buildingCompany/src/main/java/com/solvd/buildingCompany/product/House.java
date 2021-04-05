package com.solvd.buildingCompany.product;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Size;
import com.solvd.buildingCompany.enums.StyleQuality;
import com.solvd.buildingCompany.exceptions.GardenAlreadyDefinedException;
import org.apache.commons.lang3.time.CalendarUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class House extends Construction {
    private String material;
    private StyleQuality quality;
    private boolean garden;
    private static final Logger logger = LogManager.getLogger(House.class);

    public House() {
        setType(ConstructionTypes.HOUSE);
        logger.info("House data created.");
    }

    public House(Size size, int floors, String material, StyleQuality quality, boolean garden) {
        super(ConstructionTypes.HOUSE, size, floors, false);
        this.material = material;
        this.quality = quality;
        this.garden = garden;
        logger.info("House data created.");
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public StyleQuality getQuality() {
        return quality;
    }

    public void setQuality(StyleQuality quality) {
        this.quality = quality;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public void makeGarden() throws GardenAlreadyDefinedException {
        if(!this.garden){
            this.garden = true;
        }
        else{
            throw new GardenAlreadyDefinedException("The house already has a garden");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return garden == house.garden && Objects.equals(material, house.material) && Objects.equals(quality, house.quality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), material, quality, garden);
    }

    @Override
    public String toString() {
        return "House{" +
                "type=" + getType() +
                ", size=" + getSize() +
                ", floors=" + getFloors() +
                ", stateOwned=" + isStateOwned() +
                ", finishConstructionDate=" + new CalendarUtils(getFinishConstructionDate()).getMonth() + "/" +new CalendarUtils(getFinishConstructionDate()).getYear() +
                ", material='" + material + '\'' +
                ", quality=" + quality +
                ", garden=" + garden +
                '}';
    }
}
