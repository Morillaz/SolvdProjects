package com.solvd.jackson.services;

import com.solvd.jackson.dao.interfaces.IStateDAO;
import com.solvd.jackson.dao.jackson.impl.StateDAO;
import com.solvd.jackson.models.State;

import java.util.List;

public class StateService {
    private IStateDAO stateDAO = new StateDAO();

    public StateService() {
    }

    public void create(State State){
        stateDAO.create(State);
    }

    public State getByID(int id) {
        return stateDAO.getByID(id);
    }

    public void update(State state){
        stateDAO.update(state);
    }

    public void delete(int id){
        stateDAO.delete(id);
    }

    public List<State> getByCountryID(int id){
        return stateDAO.getByCountryId(id);
    }
}
