package com.solvd.buildingCompany.exceptions;

import com.sun.jdi.AbsentInformationException;

public class ConstructionException extends AbsentInformationException {
    public ConstructionException(String message) {
        super(message);
    }

    public ConstructionException() {
    }
}
