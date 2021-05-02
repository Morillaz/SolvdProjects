package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.City;

import java.util.List;

public interface ICityDAO extends IAbstractDAO<City>{
    List<City> getByStateId(int id);
}
