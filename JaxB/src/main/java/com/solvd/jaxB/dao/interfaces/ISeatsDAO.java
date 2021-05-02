package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.Seats;

import java.util.List;

public interface ISeatsDAO extends IAbstractDAO<Seats>{
    List<Seats> getByAirplaneModelId(int id);
}
