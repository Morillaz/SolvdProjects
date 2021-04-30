package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.PersonJob;

import java.util.List;

public interface IPersonJobDAO extends IAbstractDAO<PersonJob>{
    List<PersonJob> getByPersonId(int id);
    List<PersonJob> getByJobId(int id);
}
