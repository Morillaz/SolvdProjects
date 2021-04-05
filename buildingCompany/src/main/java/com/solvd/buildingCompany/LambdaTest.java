package com.solvd.buildingCompany;

import com.solvd.buildingCompany.lambdas.Capitalizator;
import com.solvd.buildingCompany.lambdas.ConstructionDataStyler;
import com.solvd.buildingCompany.product.Construction;
import org.apache.commons.lang3.time.CalendarUtils;

public class LambdaTest<T extends Construction> {
    public String formattedToString(T construction) {
        Capitalizator capitalizator = c -> {
            if (c == null || c.isEmpty()) {
                return c;
            }
            return c.substring(0, 1).toUpperCase() + c.substring(1).toLowerCase();
        };

        ConstructionDataStyler<T> styler = c -> capitalizator.capitalize(c.getType().toString()) + ":\nSize: " +
                                            capitalizator.capitalize(c.getSize().name()) + "" + "\nFloors: " +
                                            c.getFloors() + "\nExpected construction finalization: "
                                            + new CalendarUtils(c.getFinishConstructionDate()).getMonth() +
                                            "/" + new CalendarUtils(c.getFinishConstructionDate()).getYear();

        return styler.returnFormattedData(construction);
    }
}
