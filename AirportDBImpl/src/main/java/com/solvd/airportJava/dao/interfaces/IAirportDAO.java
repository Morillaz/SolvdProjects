package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.Airport;

import java.util.List;

public interface IAirportDAO extends IAbstractDAO<Airport>{
    List<Airport> geyByCityId(int id);
}
