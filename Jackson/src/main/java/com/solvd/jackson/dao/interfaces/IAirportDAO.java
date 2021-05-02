package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.Airport;

import java.util.List;

public interface IAirportDAO extends IAbstractDAO<Airport>{
    List<Airport> geyByCityId(int id);
}
