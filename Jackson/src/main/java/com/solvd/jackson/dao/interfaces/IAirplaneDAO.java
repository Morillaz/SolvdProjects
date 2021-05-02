package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.Airplane;

import java.util.List;

public interface IAirplaneDAO extends IAbstractDAO<Airplane>{
    List<Airplane> getByModelId(int id);
    List<Airplane>  getByAirlineId(int id);
}
