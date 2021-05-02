package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.City;

import java.util.List;

public interface ICityDAO extends IAbstractDAO<City>{
    List<City> getByStateId(int id);
}
