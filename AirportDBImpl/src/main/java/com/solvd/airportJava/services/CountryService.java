package com.solvd.airportJava.services;

import com.solvd.airportJava.dao.interfaces.ICountryDAO;
import com.solvd.airportJava.dao.jdbc.impl.CountryDAO;
import com.solvd.airportJava.models.Country;

public class CountryService {
    private ICountryDAO countryDAO = new CountryDAO();

    public CountryService() {
    }

    public void create(Country country){
        countryDAO.create(country);
    }

    public Country getByID(int id) {
        return countryDAO.getByID(id);
    }

    public void update(Country country){
        countryDAO.update(country);
    }

    public void delete(int id){
        countryDAO.delete(id);
    }
}
