package com.solvd.jaxB.dao.jaxB.impl;

import com.solvd.jaxB.dao.interfaces.IStateDAO;
import com.solvd.jaxB.models.State;
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

@XmlRootElement(name = "states")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateDAO implements IStateDAO {
    private static final Logger logger = LogManager.getLogger(StateDAO.class);
    private static final File FILE = new File("src/main/resources/xml/states.xml");
    @XmlElement(name = "state")
    private List<State> states = null;

    @Override
    public void create(State state) {
        states = unmarshall();
        states.add(state);
        marshall(this);
    }

    @Override
    public State getByID(int id) {
        states = unmarshall();
        return states.stream()
                .filter(state -> state.getId()==id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(State state) {
        states = unmarshall();
        states.stream()
                .filter(stateElement -> stateElement.getId() == state.getId())
                .findAny()
                .ifPresent(updateState -> {
                    updateState.setName(state.getName());
                    updateState.setCountryId(state.getCountryId());
                });
        marshall(this);
    }

    @Override
    public void delete(int id) {
        states = unmarshall();
        states.stream()
                .filter(stateElement -> stateElement.getId() == id)
                .findAny()
                .ifPresent(deleteState ->
                        states.remove(deleteState));
        marshall(this);
    }

    @Override
    public List<State> getByCountryId(int id) {
        states = unmarshall();
        return states.stream().filter(stateElement -> stateElement.getCountryId() == id).collect(Collectors.toList());
    }

    private static synchronized List<State> unmarshall(){
        StateDAO s = new StateDAO();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StateDAO.class);
            Unmarshaller jaxUnmarshaller = jaxbContext.createUnmarshaller();
            s = (StateDAO) jaxUnmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
        return s.getStates();
    }

    private static synchronized void marshall(StateDAO s){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StateDAO.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(s, FILE);
        } catch (JAXBException e) {
            logger.error(e);
        }
    }

    public List<State> getStates() {
        return states;
    }

    public void setStates(List<State> states) {
        this.states = states;
    }
}
