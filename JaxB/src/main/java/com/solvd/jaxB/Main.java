package com.solvd.jaxB;

import com.solvd.jaxB.models.State;
import com.solvd.jaxB.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        CountryService countryService = new CountryService();
        logger.info(countryService.getByID(1).toString());
        StateService stateService = new StateService();
        State s = new State(6, "Chubut", 1);
        stateService.create(s);
        List<State> states = stateService.getByCountryID(1);
        states.stream().forEach(state -> logger.info(state.toString()));
        AirlineService airlineService = new AirlineService();
        logger.info(airlineService.getByID(1).toString());
        PersonService personService = new PersonService();
        logger.info(personService.getByID(2).toString());
        CityService cityService = new CityService();
        logger.info(cityService.getByID(1).toString());
    }
}
