package com.solvd.jaxB.dao.jaxB.impl;

import com.solvd.jaxB.dao.interfaces.IAirlineDAO;
import com.solvd.jaxB.models.Airline;
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

@XmlRootElement(name = "airlines")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirlineDAO implements IAirlineDAO {
    private static final Logger logger = LogManager.getLogger(AirlineDAO.class);
    private static final File FILE = new File("src/main/resources/xml/airlines.xml");
    @XmlElement(name = "airline")
    private List<Airline> airlines = null;

    @Override
    public void create(Airline airline) {
        airlines = unmarshall();
        airlines.add(airline);
        marshall(this);
    }

    @Override
    public Airline getByID(int id) {
        airlines = unmarshall();
        return airlines.stream()
                .filter(airline -> airline.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Airline airline) {
        airlines = unmarshall();
        airlines.stream()
                .filter(airlineElement -> airlineElement.getId() == airline.getId())
                .findAny()
                .ifPresent(updateAirline -> updateAirline.setName(airline.getName()));
        marshall(this);
    }

    @Override
    public void delete(int id) {
        airlines = unmarshall();
        airlines.stream()
                .filter(airlineElement -> airlineElement.getId() == id)
                .findAny()
                .ifPresent(deleteAirline ->
                        airlines.remove(deleteAirline));
        marshall(this);
    }

    private static synchronized List<Airline> unmarshall(){
        AirlineDAO a = new AirlineDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AirlineDAO.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            a = (AirlineDAO) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return a.getAirlines();
    }

    private static synchronized void marshall(AirlineDAO a){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(AirlineDAO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(a, FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(List<Airline> airlines) {
        this.airlines = airlines;
    }
}
