package com.solvd.airportJava.utils;

import javax.xml.parsers.*;

import com.solvd.airportJava.models.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.*;
import java.io.*;
import java.util.List;


public class XMLSAXParser {
    private static final Logger logger = LogManager.getLogger(SAXParser.class);
    private static final String INPUT = "src/main/resources/xml/cities.xml";

    public void parse() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            Handler handler = new Handler();
            saxParser.parse(new File(INPUT), handler);
            List<City> cities = handler.getCities();
            cities.stream().forEach((city) -> logger.info(city.toString()));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error(e.getMessage());
        }
    }

}
