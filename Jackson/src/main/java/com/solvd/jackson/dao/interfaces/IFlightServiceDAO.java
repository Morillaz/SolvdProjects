package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.FlightService;

import java.util.List;

public interface IFlightServiceDAO extends IAbstractDAO<FlightService>{
    List<FlightService> getByFlightId(int id);
    List<FlightService> getByServiceId(int id);
}
