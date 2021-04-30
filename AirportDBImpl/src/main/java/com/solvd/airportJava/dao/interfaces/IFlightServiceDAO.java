package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.FlightService;

import java.util.List;

public interface IFlightServiceDAO extends IAbstractDAO<FlightService>{
    List<FlightService> getByFlightId(int id);
    List<FlightService> getByServiceId(int id);
}
