package com.solvd.jackson.dao.jackson.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.jackson.dao.interfaces.ICityDAO;
import com.solvd.jackson.models.Airline;
import com.solvd.jackson.models.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CityDAO implements ICityDAO {
    private static final Logger logger = LogManager.getLogger(City.class);
    private static final File file = new File("src/main/resources/json/cities.json");
    List<City> cities = new ArrayList<>();

    @Override
    public void create(City city) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cities = objectMapper.readValue(file, new TypeReference<List<City>>(){});
            cities.add(city);
            objectMapper.writeValue(file, cities);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public City getByID(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cities = objectMapper.readValue(file, new TypeReference<List<Airline>>(){});
        } catch (IOException e){
            logger.error(e.getMessage());
        }
        return cities.stream()
                .filter(city -> city.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(City city) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cities = objectMapper.readValue(file, new TypeReference<List<City>>(){});
            cities.stream()
                    .filter(cityElement -> cityElement.getId() == city.getId())
                    .findAny()
                    .ifPresent(updateCity -> {
                        updateCity.setName(city.getName());
                        updateCity.setStateId(city.getStateId());
                    });
            objectMapper.writeValue(file, cities);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cities = objectMapper.readValue(file, new TypeReference<List<City>>(){});
            cities.stream()
                    .filter(cityElement -> cityElement.getId() == id)
                    .findAny()
                    .ifPresent(deleteCity ->
                            cities.remove(deleteCity));
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<City> getByStateId(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cities = objectMapper.readValue(file, new TypeReference<List<City>>() {
            });
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return cities.stream().filter(cityElement -> cityElement.getStateId() == id).collect(Collectors.toList());
    }
}
