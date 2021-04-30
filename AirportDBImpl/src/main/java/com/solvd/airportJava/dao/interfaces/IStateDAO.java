package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.State;

import java.util.List;

public interface IStateDAO extends IAbstractDAO<State> {
    List<State> getByCountryId(int id);
}
