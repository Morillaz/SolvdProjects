package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.Flight;

import java.util.List;

public interface IFlightDAO extends IAbstractDAO<Flight>{
    List<Flight> getByRouteId(int id);
    List<Flight> getByAirplaneId(int id);
}
