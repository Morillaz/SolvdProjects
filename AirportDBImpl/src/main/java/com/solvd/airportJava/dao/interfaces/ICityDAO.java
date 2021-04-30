package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.City;

import java.util.List;

public interface ICityDAO extends IAbstractDAO<City>{
    List<City> getByStateId(int id);
}
