package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IFlightServiceDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.FlightService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightServiceDAO extends AbstractJDBCDAO implements IFlightServiceDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_FLIGHTSERVICE= "INSERT INTO Flights_has_Services (Flights_id, Services_id) VALUES (?,?)";
    private static final String GET_FLIGHTSERVICE_BY_ID = "SELECT * FROM Flights_has_Services WHERE id = ?";
    private static final String UPDATE_FLIGHTSERVICE= "UPDATE Flights_has_Services SET Flights_id = ?, Services_id = ? WHERE id=?";
    private static final String DELETE_FLIGHTSERVICE = "DELETE FROM Flights_has_Services WHERE id = ?";
    private static final String GET_FLIGHTSERVICES_BY_FLIGHT_ID = "SELECT * FROM Flights_has_Services WHERE Flights_id = ?";
    private static final String GET_FLIGHTSERVICES_BY_SERVICE_ID  = "SELECT * FROM Flights_has_Services WHERE Services_id = ?";

    @Override
    public void create(FlightService flightService) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_FLIGHTSERVICE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, flightService.getFlightId());
            ps.setInt(2, flightService.getServiceId());
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public FlightService getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        FlightService flightService = new FlightService();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FLIGHTSERVICE_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            flightService.setId(rs.getInt("id"));
            flightService.setFlightId(rs.getInt("Flights_id"));
            flightService.setServiceId(rs.getInt("Services_id"));
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return flightService;
    }

    @Override
    public void update(FlightService flightService) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_FLIGHTSERVICE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, flightService.getFlightId());
            ps.setInt(2, flightService.getServiceId());
            ps.setInt(3, flightService.getId());
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(DELETE_FLIGHTSERVICE, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    @Override
    public List<FlightService> getByFlightId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FlightService> flightServices = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FLIGHTSERVICES_BY_FLIGHT_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                FlightService flightService = new FlightService();
                flightService.setId(rs.getInt("id"));
                flightService.setFlightId(rs.getInt("Flights_id"));
                flightService.setServiceId(rs.getInt("Services_id"));
                flightServices.add(flightService);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return flightServices;
    }

    @Override
    public List<FlightService> getByServiceId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FlightService> flightServices = new ArrayList<>();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FLIGHTSERVICES_BY_SERVICE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                FlightService flightService = new FlightService();
                flightService.setId(rs.getInt("id"));
                flightService.setFlightId(rs.getInt("Flights_id"));
                flightService.setServiceId(rs.getInt("Services_id"));
                flightServices.add(flightService);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }finally {
            try {
                if (c != null) {
                    c.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return flightServices;
    }
}
