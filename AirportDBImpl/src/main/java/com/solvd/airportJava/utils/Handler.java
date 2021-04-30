package com.solvd.airportJava.utils;

import java.util.ArrayList;
import java.util.List;

import com.solvd.airportJava.models.City;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {

    private boolean hasName = false;
    private boolean hasStateId = false;

    private List <City> cities = null;
    private City city = null;

    public List <City> getCities() {
        return cities;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("City")) {
            // create a new User and put it in Map
            String id = attributes.getValue("id");
            // initialize User object and set id attribute
            city = new City();
            city.setId(Integer.parseInt(id));
            // initialize list
            if (cities == null){
                cities = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("name")) {
            // set boolean values for fields, will be used in setting User variables
            hasName = true;
        } else if (qName.equalsIgnoreCase("States_id")) {
            hasStateId = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("City")) {
            cities.add(city);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (hasName) {
            // age element, set User age
            city.setName(new String(ch, start, length));
            hasName = false;
        } else if (hasStateId) {
            city.setStateId(Integer.parseInt(new String(ch, start, length)));
            hasStateId = false;
        }
    }
}