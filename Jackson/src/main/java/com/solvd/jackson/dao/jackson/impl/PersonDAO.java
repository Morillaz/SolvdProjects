package com.solvd.jackson.dao.jackson.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.jackson.dao.interfaces.IPersonDAO;
import com.solvd.jackson.models.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements IPersonDAO {
    private static final Logger logger = LogManager.getLogger(CountryDAO.class);
    private static final File file = new File("src/main/resources/json/people.json");
    List<Person> people = new ArrayList<>();

    @Override
    public void create(Person person) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            people = objectMapper.readValue(file, new TypeReference<List<Person>>(){});
            people.add(person);
            objectMapper.writeValue(file, people);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public Person getByID(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            people = objectMapper.readValue(file, new TypeReference<List<Person>>(){});
        } catch (IOException e){
            logger.error(e.getMessage());
        }
        return people.stream()
                .filter(country -> country.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Person person) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            people = objectMapper.readValue(file, new TypeReference<List<Person>>(){});
            people.stream()
                    .filter(personElement -> personElement.getId() == person.getId())
                    .findAny()
                    .ifPresent(updatePerson ->{
                        updatePerson.setFname(person.getFname());
                        updatePerson.setLname(person.getLname());
                        updatePerson.setAge(person.getAge());
                        updatePerson.setGender(person.getGender());
                    });
            objectMapper.writeValue(file, people);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            people = objectMapper.readValue(file, new TypeReference<List<Person>>(){});
            people.stream()
                    .filter(person -> person.getId() == id)
                    .findAny()
                    .ifPresent(deletePerson -> people.remove(deletePerson));
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }
}
