package com.solvd.jaxB.services;

import com.solvd.jaxB.dao.interfaces.ICityDAO;
import com.solvd.jaxB.dao.jaxB.impl.CityDAO;
import com.solvd.jaxB.models.City;

import java.util.List;

public class CityService {
    private ICityDAO cityDAO = new CityDAO();

    public CityService() {
    }

    public void create(City city){
        cityDAO.create(city);
    }

    public City getByID(int id) {
        return cityDAO.getByID(id);
    }

    public void update(City city){
        cityDAO.update(city);
    }

    public void delete(int id){
        cityDAO.delete(id);
    }

    public List<City> getByStateID(int id){
        return cityDAO.getByStateId(id);
    }
}
