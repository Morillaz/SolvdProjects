package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IFlightDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO extends AbstractJDBCDAO implements IFlightDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_FLIGHT = "INSERT INTO Flights (status, departure_date, arrival_date, Routes_id, Airplanes_id) VALUES (?,?,?,?,?)";
    private static final String GET_FLIGHT_BY_ID = "SELECT * FROM Flights WHERE id = ?";
    private static final String UPDATE_FLIGHT = "UPDATE Flights SET status = ?, departure_date = ?, arrival_date = ?, Routes_id = ?, Airplanes_id = ? WHERE id=?";
    private static final String DELETE_FLIGHT = "DELETE FROM Flights WHERE id = ?";
    private static final String GET_FLIGHTS_BY_ROUTE_ID = "SELECT * FROM Flights WHERE Routes_id = ?";
    private static final String GET_FLIGHTS_BY_AIRPLANE_ID  = "DELETE FROM Flights WHERE Airplanes_id = ?";

    @Override
    public void create(Flight flight) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_FLIGHT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, flight.getStatus());
            ps.setTimestamp(2, flight.getDeparture());
            ps.setTimestamp(3, flight.getArrival());
            ps.setInt(4, flight.getRouteId());
            ps.setInt(5, flight.getAirplaneId());
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
    public Flight getByID(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Flight flight = new Flight();
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FLIGHT_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            flight.setId(rs.getInt("id"));
            flight.setStatus(rs.getString("status"));
            flight.setDeparture(rs.getTimestamp("departure_time"));
            flight.setArrival(rs.getTimestamp("arrival_time"));
            flight.setRouteId(rs.getInt("Routes_id"));
            flight.setRouteId(rs.getInt("Airplanes_id"));
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
        return flight;
    }

    @Override
    public void update(Flight flight) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_FLIGHT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, flight.getStatus());
            ps.setTimestamp(2, flight.getDeparture());
            ps.setTimestamp(3, flight.getArrival());
            ps.setInt(4, flight.getRouteId());
            ps.setInt(5, flight.getAirplaneId());
            ps.setInt(6, flight.getId());
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
            ps = c.prepareStatement(DELETE_FLIGHT, Statement.RETURN_GENERATED_KEYS);
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
    public List<Flight> getByRouteId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Flight> flights = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FLIGHTS_BY_ROUTE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getInt("id"));
                flight.setStatus(rs.getString("status"));
                flight.setDeparture(rs.getTimestamp("departure_time"));
                flight.setArrival(rs.getTimestamp("arrival_time"));
                flight.setRouteId(rs.getInt("Routes_id"));
                flight.setRouteId(rs.getInt("Airplanes_id"));
                flights.add(flight);
            }
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
        return flights;
    }

    @Override
    public List<Flight> getByAirplaneId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Flight> flights = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_FLIGHTS_BY_AIRPLANE_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Flight flight = new Flight();
                flight.setId(rs.getInt("id"));
                flight.setStatus(rs.getString("status"));
                flight.setDeparture(rs.getTimestamp("departure_time"));
                flight.setArrival(rs.getTimestamp("arrival_time"));
                flight.setRouteId(rs.getInt("Routes_id"));
                flight.setRouteId(rs.getInt("Airplanes_id"));
                flights.add(flight);
            }
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
        return flights;
    }
}
