package com.solvd.jackson.services;


import com.solvd.jackson.dao.interfaces.IPersonDAO;
import com.solvd.jackson.dao.jackson.impl.PersonDAO;
import com.solvd.jackson.models.Person;


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
