package com.solvd.jaxB.dao.jaxB.impl;

import com.solvd.jaxB.dao.interfaces.ICityDAO;
import com.solvd.jaxB.models.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "cities")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityDAO implements ICityDAO {
    private static final Logger logger = LogManager.getLogger(CityDAO.class);
    private static final File FILE = new File("src/main/resources/xml/cities.xml");
    @XmlElement(name = "city")
    private List<City> cities = null;

    @Override
    public void create(City city) {
        cities = unmarshall();
        cities.add(city);
        marshall(this);
    }

    @Override
    public City getByID(int id) {
        cities = unmarshall();
        return cities.stream()
                .filter(city -> city.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(City city) {
        cities = unmarshall();
        cities.stream()
                .filter(cityElement -> cityElement.getId() == city.getId())
                .findAny()
                .ifPresent(updateCity -> {
                    updateCity.setName(city.getName());
                    updateCity.setStateId(city.getStateId());
                });
        marshall(this);
    }

    @Override
    public void delete(int id) {
        cities = unmarshall();
        cities.stream()
                .filter(cityElement -> cityElement.getId() == id)
                .findAny()
                .ifPresent(deleteCity ->
                        cities.remove(deleteCity));
        marshall(this);
    }

    @Override
    public List<City> getByStateId(int id) {
        cities = unmarshall();
        return cities.stream().filter(cityElement -> cityElement.getStateId() == id).collect(Collectors.toList());
    }

    private static List<City> unmarshall(){
        CityDAO c = new CityDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CityDAO.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            c = (CityDAO) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return c.getCities();
    }

    private static void marshall(CityDAO c){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CityDAO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(c, FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
