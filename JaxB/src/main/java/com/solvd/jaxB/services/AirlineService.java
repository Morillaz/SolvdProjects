package com.solvd.jaxB.services;

import com.solvd.jaxB.dao.interfaces.IAirlineDAO;
import com.solvd.jaxB.dao.jaxB.impl.AirlineDAO;
import com.solvd.jaxB.models.Airline;

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
