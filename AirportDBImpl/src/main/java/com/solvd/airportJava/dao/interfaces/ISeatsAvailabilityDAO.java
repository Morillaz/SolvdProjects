package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.SeatsAvailability;

import java.util.List;

public interface ISeatsAvailabilityDAO extends IAbstractDAO<SeatsAvailability>{
    List<SeatsAvailability> getBySeatsId(int id);
}
