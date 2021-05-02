package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.FlightService;

import java.util.List;

public interface IFlightServiceDAO extends IAbstractDAO<FlightService>{
    List<FlightService> getByFlightId(int id);
    List<FlightService> getByServiceId(int id);
}
