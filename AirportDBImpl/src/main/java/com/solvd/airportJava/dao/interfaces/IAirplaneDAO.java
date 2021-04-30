package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.Airplane;

import java.util.List;

public interface IAirplaneDAO extends IAbstractDAO<Airplane>{
    List<Airplane> getByModelId(int id);
    List<Airplane>  getByAirlineId(int id);
}
