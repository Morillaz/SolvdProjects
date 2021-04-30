package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.Seats;

import java.util.List;

public interface ISeatsDAO extends IAbstractDAO<Seats>{
    List<Seats> getByAirplaneModelId(int id);
}
