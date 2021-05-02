package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.State;

import java.util.List;

public interface IStateDAO extends IAbstractDAO<State> {
    List<State> getByCountryId(int id);
}
