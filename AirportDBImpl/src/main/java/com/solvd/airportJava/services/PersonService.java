package com.solvd.airportJava.services;


import com.solvd.airportJava.dao.interfaces.IPersonDAO;
import com.solvd.airportJava.dao.jdbc.impl.PersonDAO;
import com.solvd.airportJava.models.Person;

public class PersonService {
    private IPersonDAO personDAO = new PersonDAO();

    public PersonService() {
    }

    public void create(Person person){
        personDAO.create(person);
    }

    public Person getByID(int id) {
        return personDAO.getByID(id);
    }

    public void update(Person person){
        personDAO.update(person);
    }

    public void delete(int id){
        personDAO.delete(id);
    }
}
