package com.solvd.jackson;

import com.solvd.jackson.services.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        CountryService countryService = new CountryService();
        logger.info(countryService.getByID(4).toString());

        PersonService personService = new PersonService();
        logger.info(personService.getByID(1).toString());

        AirlineService airlineService = new AirlineService();
        logger.info(airlineService.getByID(1).toString());

        StateService stateService = new StateService();
        stateService.getByCountryID(1).stream().forEach((st) -> logger.info(st.toString()));

        CityService cityService = new CityService();
        cityService.getByStateID(1).stream().forEach((ct) -> logger.info(ct.toString()));
    }
}