package com.solvd.jaxB.dao.jaxB.impl;

import com.solvd.jaxB.dao.interfaces.IPersonDAO;
import com.solvd.jaxB.models.Person;
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

@XmlRootElement(name = "people")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDAO implements IPersonDAO {
    private static final Logger logger = LogManager.getLogger(PersonDAO.class);
    private static final File FILE = new File("src/main/resources/xml/people.xml");
    @XmlElement(name = "person")
    private List<Person> people = null;

    @Override
    public void create(Person person) {
        people = unmarshall();
        people.add(person);
        marshall(this);
    }

    @Override
    public Person getByID(int id) {
        people = unmarshall();
        return people.stream()
                .filter(person -> person.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Person person) {
        people = unmarshall();
        people.stream()
                .filter(personElement -> personElement.getId() == person.getId())
                .findAny()
                .ifPresent(updatePerson ->{
                    updatePerson.setFname(person.getFname());
                    updatePerson.setLname(person.getLname());
                    updatePerson.setAge(person.getAge());
                    updatePerson.setGender(person.getGender());
                });
        marshall(this);
    }

    @Override
    public void delete(int id) {
        people = unmarshall();
        people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .ifPresent(deletePerson ->
                        people.remove(deletePerson));
        marshall(this);
    }

    private static synchronized List<Person> unmarshall(){
        PersonDAO p = new PersonDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonDAO.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            p = (PersonDAO) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e.getMessage());
        }
        return p.getPeople();
    }

    private static synchronized void marshall(PersonDAO p){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PersonDAO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(p, FILE);
        } catch (JAXBException e) {
            logger.error(e.getMessage());
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
