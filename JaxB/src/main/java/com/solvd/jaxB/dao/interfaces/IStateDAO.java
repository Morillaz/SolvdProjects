package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.State;

import java.util.List;

public interface IStateDAO extends IAbstractDAO<State> {
    List<State> getByCountryId(int id);
}
