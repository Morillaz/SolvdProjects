package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.Order;

import java.util.List;

public interface IOrderDAO extends IAbstractDAO<Order> {
    List<Order> getByPersonId(int id);
    List<Order> getByFlightId(int id);
}
