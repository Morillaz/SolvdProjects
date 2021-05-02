package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.SeatsAvailability;

import java.util.List;

public interface ISeatsAvailabilityDAO extends IAbstractDAO<SeatsAvailability>{
    List<SeatsAvailability> getBySeatsId(int id);
}
