package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.Route;

import java.util.List;

public interface IRouteDAO extends IAbstractDAO<Route>{
    List<Route> getByAirportFromId(int id);
    List<Route> getByAirportToId(int id);
}
