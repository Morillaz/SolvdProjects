package com.solvd.buildingCompany.exceptions;

import com.sun.jdi.AbsentInformationException;

public class NoBudgetException extends AbsentInformationException {
    public NoBudgetException() {
    }

    public NoBudgetException(String s) {
        super(s);
    }
}
