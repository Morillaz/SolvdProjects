package com.solvd.jackson.dao.interfaces;

import com.solvd.jackson.models.Route;

import java.util.List;

public interface IRouteDAO extends IAbstractDAO<Route>{
    List<Route> getByAirportFromId(int id);
    List<Route> getByAirportToId(int id);
}
