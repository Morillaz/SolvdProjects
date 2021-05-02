package com.solvd.jaxB.services;


import com.solvd.jaxB.dao.interfaces.IPersonDAO;
import com.solvd.jaxB.dao.jaxB.impl.PersonDAO;
import com.solvd.jaxB.models.Person;


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
