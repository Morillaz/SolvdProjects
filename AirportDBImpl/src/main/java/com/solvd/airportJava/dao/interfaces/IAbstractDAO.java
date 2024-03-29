package com.solvd.airportJava.dao.interfaces;

public interface IAbstractDAO<T> {
    void create(T t);
    T getByID(int id);
    void update(T t);
    void delete (int id);
}
