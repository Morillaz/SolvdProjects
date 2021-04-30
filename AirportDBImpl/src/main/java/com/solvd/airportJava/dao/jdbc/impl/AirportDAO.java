package com.solvd.airportJava.dao.jdbc.impl;

import com.solvd.airportJava.dao.interfaces.IAirportDAO;
import com.solvd.airportJava.dao.jdbc.AbstractJDBCDAO;
import com.solvd.airportJava.models.Airport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportDAO extends AbstractJDBCDAO implements IAirportDAO {
    private static final Logger logger = LogManager.getLogger(AirplaneDAO.class);
    private static final String CREATE_AIRPORT = "INSERT INTO Airports (name, Cities_id) VALUES (?,?)";
    private static final String GET_AIRPORT_BY_ID = "SELECT * FROM Airports WHERE id = ?";
    private static final String UPDATE_AIRPORT = "UPDATE Airports SET name = ?, Cities_id = ? WHERE id=?";
    private static final String DELETE_AIRPORT = "DELETE FROM Airports WHERE id = ?";
    private static final String GET_AIRPORTS_BY_CITY_ID  = "SELECT * FROM Airports WHERE Cities_id = ?";

    @Override
    public void create(Airport airport) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(CREATE_AIRPORT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, airport.getName());
            ps.setInt(2, airport.getCityId());
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
    public Airport getByID(int id){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Airport airport = new Airport();
            try{
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPORT_BY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            airport.setId(rs.getInt("id"));
            airport.setName(rs.getString("name"));
            airport.setCityId(rs.getInt("Cities_id"));
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
            return airport;
    }

    @Override
    public void update(Airport airport) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getCp().getConnection();
            ps = c.prepareStatement(UPDATE_AIRPORT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, airport.getName());
            ps.setInt(2, airport.getCityId());
            ps.setInt(3, airport.getId());
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
            ps = c.prepareStatement(DELETE_AIRPORT, Statement.RETURN_GENERATED_KEYS);
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
    public List<Airport> geyByCityId(int id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Airport> airports = new ArrayList<>();
        try {
            c = getCp().getConnection();
            ps = c.prepareStatement(GET_AIRPORTS_BY_CITY_ID, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Airport airport = new Airport();
                airport.setId(rs.getInt("id"));
                airport.setName(rs.getString("name"));
                airport.setCityId(rs.getInt("Cities_id"));
                airports.add(airport);
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
        return airports;
    }
}
