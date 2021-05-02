package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.Airplane;

import java.util.List;

public interface IAirplaneDAO extends IAbstractDAO<Airplane>{
    List<Airplane> getByModelId(int id);
    List<Airplane>  getByAirlineId(int id);
}
