package com.solvd.jackson.services;

import com.solvd.jackson.dao.interfaces.ICityDAO;
import com.solvd.jackson.dao.jackson.impl.CityDAO;
import com.solvd.jackson.models.City;

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
