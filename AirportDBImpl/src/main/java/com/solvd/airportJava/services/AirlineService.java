package com.solvd.airportJava.services;

import com.solvd.airportJava.dao.interfaces.IAirlineDAO;
import com.solvd.airportJava.dao.jdbc.impl.AirlineDAO;
import com.solvd.airportJava.models.Airline;

public class AirlineService {
    private IAirlineDAO airlineDAO = new AirlineDAO();

    public AirlineService() {
    }

    public void create(Airline airline){
        airlineDAO.create(airline);
    }

    public Airline getByID(int id) {
        return airlineDAO.getByID(id);
    }

    public void update(Airline airline){
        airlineDAO.update(airline);
    }

    public void delete(int id){
        airlineDAO.delete(id);
    }
}
