package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.Flight;

import java.util.List;

public interface IFlightDAO extends IAbstractDAO<Flight>{
    List<Flight> getByRouteId(int id);
    List<Flight> getByAirplaneId(int id);
}
