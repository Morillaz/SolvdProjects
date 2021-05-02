package com.solvd.jackson.dao.jackson.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.jackson.dao.interfaces.IStateDAO;
import com.solvd.jackson.models.Airline;
import com.solvd.jackson.models.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StateDAO implements IStateDAO {
    private static final Logger logger = LogManager.getLogger(State.class);
    private static final File file = new File("src/main/resources/json/states.json");
    List<State> states = new ArrayList<>();

    @Override
    public void create(State state) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            states = objectMapper.readValue(file, new TypeReference<List<State>>(){});
            states.add(state);
            objectMapper.writeValue(file, states);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public State getByID(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            states = objectMapper.readValue(file, new TypeReference<List<Airline>>(){});
        } catch (IOException e){
            logger.error(e.getMessage());
        }
        return states.stream()
                .filter(state -> state.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(State state) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            states = objectMapper.readValue(file, new TypeReference<List<State>>(){});
            states.stream()
                    .filter(stateElement -> stateElement.getId() == state.getId())
                    .findAny()
                    .ifPresent(updateState -> {
                        updateState.setName(state.getName());
                        updateState.setCountryId(state.getCountryId());
                    });
            objectMapper.writeValue(file, states);
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            states = objectMapper.readValue(file, new TypeReference<List<State>>(){});
            states.stream()
                    .filter(stateElement -> stateElement.getId() == id)
                    .findAny()
                    .ifPresent(deleteState ->
                            states.remove(deleteState));
        } catch (IOException e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<State> getByCountryId(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            states = objectMapper.readValue(file, new TypeReference<List<State>>() {
            });
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
        return states.stream().filter(stateElement -> stateElement.getCountryId() == id).collect(Collectors.toList());
    }
}
