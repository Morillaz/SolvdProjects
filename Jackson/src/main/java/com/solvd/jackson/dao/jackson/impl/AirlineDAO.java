package com.solvd.jackson.dao.jackson.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.jackson.dao.interfaces.IAirlineDAO;
import com.solvd.jackson.models.Airline;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirlineDAO implements IAirlineDAO {
    private static final Logger logger = LogManager.getLogger(AirlineDAO.class);
    private static final File file = new File("src/main/resources/json/airlines.json");
    List<Airline> airlines = new ArrayList<>();

    @Override
    public void create(Airline airline) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            airlines = objectMapper.readValue(file, new TypeReference<List<Airline>>(){});
            airlines.add(airline);
            objectMapper.writeValue(file, airlines);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public Airline getByID(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            airlines = objectMapper.readValue(file, new TypeReference<List<Airline>>(){});
        } catch (IOException e){
            logger.error(e.getMessage());
        }
        return airlines.stream()
                .filter(airline -> airline.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Airline airline) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            airlines = objectMapper.readValue(file, new TypeReference<List<Airline>>(){});
            airlines.stream()
                    .filter(airlineElement -> airlineElement.getId() == airline.getId())
                    .findAny()
                    .ifPresent(updateAirline -> updateAirline.setName(airline.getName()));
            objectMapper.writeValue(file, airlines);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            airlines = objectMapper.readValue(file, new TypeReference<List<Airline>>(){});
            airlines.stream()
                    .filter(airlineElement -> airlineElement.getId() == id)
                    .findAny()
                    .ifPresent(deleteAirline -> airlines.remove(deleteAirline));
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }
}
