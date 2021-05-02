package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.Flight;

import java.util.List;

public interface IFlightDAO extends IAbstractDAO<Flight>{
    List<Flight> getByRouteId(int id);
    List<Flight> getByAirplaneId(int id);
}
