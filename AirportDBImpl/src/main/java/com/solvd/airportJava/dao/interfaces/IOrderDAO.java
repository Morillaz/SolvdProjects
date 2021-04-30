package com.solvd.airportJava.dao.interfaces;

import com.solvd.airportJava.models.Order;

import java.util.List;

public interface IOrderDAO extends IAbstractDAO<Order> {
    List<Order> getByPersonId(int id);
    List<Order> getByFlightId(int id);
}
