package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.AirportJob;

import java.util.List;

public interface IAirportJobDAO extends IAbstractDAO<AirportJob>{
    List<AirportJob> getByAirportId(int id);
    List<AirportJob> getByJobId(int id);
}
