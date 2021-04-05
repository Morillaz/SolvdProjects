package com.solvd.buildingCompany.exceptions;

import com.sun.jdi.AbsentInformationException;

public class EmployeeException extends AbsentInformationException {
    public EmployeeException() {
    }

    public EmployeeException(String s) {
        super(s);
    }
}
