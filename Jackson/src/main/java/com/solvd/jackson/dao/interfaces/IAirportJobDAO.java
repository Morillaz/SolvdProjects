package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.AirportJob;

import java.util.List;

public interface IAirportJobDAO extends IAbstractDAO<AirportJob>{
    List<AirportJob> getByAirportId(int id);
    List<AirportJob> getByJobId(int id);
}
