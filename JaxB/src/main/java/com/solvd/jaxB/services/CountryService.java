package com.solvd.jaxB.services;

import com.solvd.jaxB.dao.interfaces.ICountryDAO;
import com.solvd.jaxB.dao.jaxB.impl.CountryDAO;
import com.solvd.jaxB.models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountryService {
    private ICountryDAO countryDAO = new CountryDAO();
    private static final Logger logger = LogManager.getLogger(CountryDAO.class);
    public CountryService() {
    }

    public void create(Country country){
        countryDAO.create(country);
    }

    public Country getByID(int id) {
         Country c = countryDAO.getByID(id);
        return c;

    }

    public void update(Country country){
        countryDAO.update(country);
    }

    public void delete(int id){
        countryDAO.delete(id);
    }
}
