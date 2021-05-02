package com.solvd.jaxB.dao.jaxB.impl;

import com.solvd.jaxB.dao.interfaces.ICountryDAO;
import com.solvd.jaxB.models.Country;
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

@XmlRootElement(name = "countries")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryDAO implements ICountryDAO {
    private static final Logger logger = LogManager.getLogger(CountryDAO.class);
    private static final File FILE = new File("src/main/resources/xml/countries.xml");

    @XmlElement(name = "country")
    private List<Country> countries = null;

    @Override
    public void create(Country country) {
        countries = unmarshall();
        countries.add(country);
        marshall(this);
    }

    @Override
    public Country getByID(int id) {
        countries = unmarshall();
        return countries.stream()
                .filter(country -> country.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Country country) {
        countries = unmarshall();
        countries.stream()
                .filter(countryElement -> countryElement.getId() == country.getId())
                .findAny()
                .ifPresent(updateCountry -> updateCountry.setName(country.getName()));
        marshall(this);
    }

    @Override
    public void delete(int id) {
        countries = unmarshall();
        countries.stream()
                .filter(countryStream -> countryStream.getId() == id)
                .findAny()
                .ifPresent(deleteCountry ->
                        countries.remove(deleteCountry));
        marshall(this);
    }

    private static synchronized List<Country> unmarshall(){
        CountryDAO c = new CountryDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CountryDAO.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            c = (CountryDAO) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return c.getCountries();
    }

    private static synchronized void marshall(CountryDAO c){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CountryDAO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(c, FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
