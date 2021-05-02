package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.Airport;

import java.util.List;

public interface IAirportDAO extends IAbstractDAO<Airport>{
    List<Airport> geyByCityId(int id);
}
