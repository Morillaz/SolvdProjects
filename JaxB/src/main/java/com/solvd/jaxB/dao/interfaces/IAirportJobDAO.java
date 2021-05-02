package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.AirportJob;

import java.util.List;

public interface IAirportJobDAO extends IAbstractDAO<AirportJob>{
    List<AirportJob> getByAirportId(int id);
    List<AirportJob> getByJobId(int id);
}
