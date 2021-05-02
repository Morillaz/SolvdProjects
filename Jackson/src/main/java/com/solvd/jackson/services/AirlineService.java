package com.solvd.jackson.services;

import com.solvd.jackson.dao.interfaces.IAirlineDAO;
import com.solvd.jackson.dao.jackson.impl.AirlineDAO;
import com.solvd.jackson.models.Airline;

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
