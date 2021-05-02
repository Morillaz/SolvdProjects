package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.Seats;

import java.util.List;

public interface ISeatsDAO extends IAbstractDAO<Seats>{
    List<Seats> getByAirplaneModelId(int id);
}
