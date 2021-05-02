package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.SeatsAvailability;

import java.util.List;

public interface ISeatsAvailabilityDAO extends IAbstractDAO<SeatsAvailability>{
    List<SeatsAvailability> getBySeatsId(int id);
}
