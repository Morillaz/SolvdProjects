package com.solvd.buildingCompany.product;

import com.solvd.buildingCompany.enums.ConstructionTypes;
import com.solvd.buildingCompany.enums.Size;
import org.apache.commons.lang3.time.CalendarUtils;

import java.util.Calendar;
import java.util.Objects;

public abstract class Construction implements Constructable{
    private ConstructionTypes type;
    private Size size;
    private int floors;
    private boolean isStateOwned;
    private Calendar finishConstructionDate;

    public Construction() {
    }

    public Construction(ConstructionTypes type, Size size, int floors, boolean isStateOwned) {
        this.type = type;
        this.size = size;
        this.floors = floors;
        this.isStateOwned = isStateOwned;
    }

    public Construction(ConstructionTypes type, Size size, int floors, boolean isStateOwned, Calendar finishConstructionDate) {
        this.type = type;
        this.size = size;
        this.floors = floors;
        this.isStateOwned = isStateOwned;
        this.finishConstructionDate = finishConstructionDate;
    }

    public ConstructionTypes getType() {
        return type;
    }

    public void setType(ConstructionTypes type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public boolean isStateOwned() {
        return isStateOwned;
    }

    public void setStateOwned(boolean stateOwned) {
        isStateOwned = stateOwned;
    }

    public Calendar getFinishConstructionDate() {
        return finishConstructionDate;
    }

    public void setFinishConstructionDate(Calendar finishConstructionDate) {
        this.finishConstructionDate = finishConstructionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Construction that = (Construction) o;
        return floors == that.floors && isStateOwned == that.isStateOwned && type == that.type && size == that.size && Objects.equals(finishConstructionDate, that.finishConstructionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, size, floors, isStateOwned, finishConstructionDate);
    }

    @Override
    public String toString() {
        return "Construction{" +
                "type=" + type +
                ", size='" + size + '\'' +
                ", floors=" + floors +
                ", isStateOwned=" + isStateOwned +
                ", stateOwned=" + isStateOwned() +
                ", finishConstructionDate=" + new CalendarUtils(getFinishConstructionDate()).getMonth() + "/" +new CalendarUtils(getFinishConstructionDate()).getYear() +
                '}';
    }

    public void buildWall() {

    }

    public void tearDownWall() {

    }

    public void extendStructure() {

    }
}
